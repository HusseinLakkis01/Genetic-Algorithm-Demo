/*this class is to generate a pool of individuals
 * from the population we choose parents to cross over and mutate
 * Individuals within a population are randomly generated
 */

public class Population {

	Individual[] individuals;

	// constructor
	public Population(int populationSize, boolean initialise) 
	{   /* create a list of individuals, use the boolean initialise to determine 
	    if we are creating a random pop, or merely 
	    creating an empty array to fill in with fit individuals, see more in the actual algorithm*/
		
		individuals = new Individual[populationSize];

		if (initialise) {
			for (int i = 0; i < size(); i++) {
				Individual newIndividual = new Individual();
				newIndividual.generateIndividual();
				keepIndividual(i, newIndividual);
			}
		}
	}
    
	public Individual getIndividual(int index) {
		return individuals[index];
	}
    // important method that gets the best individual within a population, used for cross over
	public Individual getbest() {
		Individual fittest = individuals[0];

		for (int i = 0; i < size(); i++) {
			if (fittest.getFitness() <= getIndividual(i).getFitness()) {
				fittest = getIndividual(i);
			}
			
		}
		return fittest;
	}
    // size of the population
	public int size() {
		return individuals.length;
	}
    // method to keep our individual and save it at an index
	public void keepIndividual(int index, Individual indiv) {
		individuals[index] = indiv;
	}

}