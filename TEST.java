
public class TEST {
	
	 public static void main(String[] args) {
            int cutoff = 900;
	        int targetFitness = 10000; // every gene is 1
	        // Create an initial population, size 50
	        Population myPop = new Population(50, true);
	        
	        // Evolve our population until we reach an optimum solution
	        int Counter = 0;
	        // evaluate initial and iterate while the fitness of the best is less than the target, and still within allowed cuttoff
	        while (myPop.getbest().getFitness() < targetFitness && Counter < cutoff) {
	            
	            System.out.println("Generation: " + Counter + " Fittest: " + myPop.getbest().getFitness());
	            Counter++;
	            if(Math.random()<0.7) // probabilty of crossing over
	            myPop = GeneticAlgorithm.crossOverPopulation(myPop);
	            // mutate whole population
				for (int j = 0; j < myPop.size(); j++)
					GeneticAlgorithm.mutate(myPop.getIndividual(j));
	        }
	        System.out.println("Finally got the best!");
	        System.out.println("The generation that contains it is " + Counter);
	        
	        System.out.println(myPop.getbest().toString());
	       

	    }
}

