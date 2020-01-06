import java.util.*;

public class GeneticAlgorithm {

    static double mutationRate = 0.001;
	static int breedingGroup = 5;
	static Random ran = new Random();

	public static Population crossOverPopulation(Population pop) {
		Population newPopulation = new Population(pop.size(), false);
		// elistist approach, keep the best individual and dont evolve
		newPopulation.keepIndividual(0, pop.getbest());
		// cross over the whole population, by choosing the best indivuals from breeding pools, it is
		// stochastic, only biased in selection
		for (int i = 1; i < pop.size(); i++) {
			// pick 2 random group and get 2 fit parents from them
			Individual parent1 = BreedingSelection(pop);
			Individual parent2 = BreedingSelection(pop);
			// cross over the parents
			Individual child = crossover(parent1, parent2);
			// save the result
			newPopulation.keepIndividual(i, child);
		}
		return newPopulation;

	}

	// Crossover method
	public static Individual crossover(Individual p1, Individual p2) {
		// create a random breakpoint in the genome
		int breakPoint = ran.nextInt(10000);

		for (int i = 0; i < breakPoint; i++) {
			// swap fragments
			byte temp = p1.getGene(i);
			p1.setGene(i, p2.getGene(i));
			;
			p2.setGene(i, temp);
		}
		// evaluate fitness and get the best one of the resultant
		if (p1.getFitness() > p2.getFitness())
			return p1;

		else
			return p2;
	}
	// Mutate an individual
	static void mutate(Individual individual) {
		// Loop through genes
		for (int i = 0; i < individual.size(); i++) {
			float r = (float) Math.random();
			if (individual.genes[i] == 1)  // assume that its harder to mutate a good gene so lower the rate a bit
				if (r <= 0.0009) { // mutate
					byte gene = 0;
					individual.setGene(i, gene);
				
				}
				
			if (individual.genes[i] == 0)
				if (r < mutationRate) {
					byte gene = 1;
					individual.setGene(i, gene);
				}
		}
	}
	// method that measures the fitness based on the number of 1 in the genome
	static int getFitness(Individual individual) {
		int fitness = 0;
		for (int i = 0; i < individual.size(); i++) {
			if (individual.getGene(i) == 1) 
				fitness++;
		}
		return fitness;

	}
	// Select individuals for crossover
	private static Individual BreedingSelection(Population pop) {
		// Create a breeding population
		Population breedingPopulation = new Population(breedingGroup, false);
		// For each place in the group get a random individual

		for (int i = 0; i < breedingGroup; i++) {
			int randomId = (int) (Math.random() * pop.size());
			breedingPopulation.keepIndividual(i, pop.getIndividual(randomId));
		}
		// Get the fittest from the breeding group
		Individual fittest = breedingPopulation.getbest();
		return fittest;
	}
}