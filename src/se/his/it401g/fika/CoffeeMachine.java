package se.his.it401g.fika;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * @author Student - Gustav Johansson - DVSUG20G - University of Skövde
 */

/*
 * The purpose of this class is to create and remove coffee objects from the
 * Coffee Machine, represented by the ArrayList<Coffee>. The class also contains
 * methods and Random objects that enables to create 5 more coffee objects with
 * 20% chance.
 * 
 */
public class CoffeeMachine {

	/*
	 * Random object to generate random numbers. ArrayList to store Coffee Objects.
	 */
	private Random random = new Random();
	private ArrayList<Coffee> coffeeReserve = new ArrayList<Coffee>();

	/*
	 * Method to retrieve coffeeReserve outside of the class scope.
	 */
	public ArrayList<Coffee> getCoffeeReserve() {
		return coffeeReserve;
	}

	CoffeeMachine() {
		produceCoffee(20);
		Collections.shuffle(coffeeReserve);
		printCoffeeReserve();
	}

	/*
	 * Local method to create given amount of coffee-objects and add them to the
	 * coffee reserve.
	 */
	private void produceCoffee(int nrOfCoffee) {
		ArrayList<Coffee> coffeeTypes = new ArrayList<Coffee>();

		for (int i = 1; i <= nrOfCoffee; i++) {
			coffeeTypes.add(new BlackCoffee());
			coffeeTypes.add(new Capuccino());
			coffeeTypes.add(new Latte());
			Collections.shuffle(coffeeTypes);
			coffeeReserve.add(coffeeTypes.get(0));
			coffeeTypes.clear();

		}

	}

	/*
	 * Local method the prints the contents of the coffee-machine
	 */
	private void printCoffeeReserve() {
		for (int i = 0; i < getCoffeeReserve().size(); i++) {
			System.out.println(getCoffeeReserve().get(i).getCoffeeName() + " with energy: "
					+ getCoffeeReserve().get(i).getEnergy() + " is produced");
		}
	}

	/*
	 * Method to remove coffee-objects from the coffee reserve.
	 */
	public void removeCoffee() {
		coffeeReserve.trimToSize();
		coffeeReserve.remove(0);
		coffeeReserve.trimToSize();
	}

	/*
	 * Method that with 20% chance calls the method: produceMoreCoffee().
	 */
	public void perhapsProduceMoreCoffee() {
		int perhaps = random.nextInt(6 - 1) + 1;
		if (perhaps == 5) {
			produceCoffee(5);
			System.out.println(
					"The coffee-machine produced 5 more drinks and has now " + coffeeReserve.size() + " drinks");

			coffeeReserve.trimToSize();
		}
	}

	/*
	 * Method to print coffee details.
	 */
	public void printCoffeeMachineDetails() {
		System.out.println("The coffee-machine now has " + getCoffeeReserve().size() + " drinks.");
	}

}
