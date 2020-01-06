import java.util.Arrays;

public class Individual {
    //length of the chromosome we have
	static int defaultGeneLength = 10000; 
	// make a binary array to store genes as vlues of 0 and 1
	byte[] genes = new byte[defaultGeneLength];
    // initially fitness is set to 0
	private int fitness = 0;
    
	// method to generate randomly an individual solutio in the population
	public void generateIndividual() {
		for (int i = 0; i < defaultGeneLength; i++) {

			byte gene = (byte) Math.round(Math.random());
			genes[i] = gene;
		}
	}
    // method that you can use to change the length of the chromosome 
	public static void setDefaultGeneLength(int length) {
		defaultGeneLength = length;
	}
    // setters and getters
	public byte getGene(int index) {
		return genes[index];
	}

	public void setGene(int index, byte value) {
		genes[index] = value;
		fitness = 0;
	}

	public int size() {
		return genes.length;
	}

	public int getFitness() {
		if (fitness == 0) {
			fitness = GeneticAlgorithm.getFitness(this);
		}
		return fitness;
	}
	@Override
	public String toString() {
		return "Individual has a fitness score = " + fitness + "]";
	}
	

}