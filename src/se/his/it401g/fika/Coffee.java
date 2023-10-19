package se.his.it401g.fika;

import java.util.Random;
/**
 * @author Student - Gustav Johansson - DVSUG20G - University of Skövde
 */

/*
 *  The class Coffee is a abstract class that defines the coffee which energizes the persons within the simulation.
 *  Coffee has 3 children with unique names and energies: BlackCoffee, Capuccino and Latte.
 *  Coffee implements the Energize interface to get and set the energy variable.
 */
abstract class Coffee implements Energize {
	/*
	 * Variables to store name and energy. 
	 * Random-object to randomize energy.
	 */
	private String coffeeName;
	private int energy;
	private Random random = new Random();

	/*
	 * Getters and setters to retrieve coffeeName energy outside of the class scope.
	 */
	public String getCoffeeName() {
		return coffeeName;
	}

	public void setCoffeeName(String coffeeName) {
		this.coffeeName = coffeeName;
	}

	public Random getRandom() {
		return random;
	}

	@Override
	public int getEnergy() {

		return energy;
	}

	@Override
	public void energize(int energy) {
		this.energy = energy;

	}

}
