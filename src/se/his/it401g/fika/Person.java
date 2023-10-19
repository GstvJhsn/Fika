package se.his.it401g.fika;

/**
 * @author Student - Gustav Johansson - DVSUG20G - University of Skövde
 */

/*
 * This class represents the persons in the program. Each person person object
 * can be given a name and a random energy level between 30 and 90 and a
 * location which changes depending on the energy level of the person. The class
 * implements runnable to make it the energy level decrease by 10 every second.
 * 
 * 
 */
public class Person implements Runnable, Energize {
	/*
	 * Randomize object to retrieve a value between 30 and 90.
	 */
	private Randomise randomizer = new Randomise();

	/*
	 * Variables to store name and energy and location of the object.
	 */
	private String name;
	private int energy;
	private String location;

	private CoffeeMachine coffeeMachine;

	/*
	 * Getters and setters to retrieve variables outside of the class scope.
	 */
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int getEnergy() {
		return energy;
	}

	@Override
	public void energize(int energy) {
		this.energy = randomizer.randomize(energy);
	}

	public void gainEnergy(int energy) {
		this.energy = this.energy + energy;
	}

	Person(String name, CoffeeMachine cm) {
		this.coffeeMachine = cm;
		energize(randomizer.randomize(energy));
		setName(name);
		setLocation("Office");
	}

	/*
	 * Method to print out details to the console.
	 */
	private void printPersonDetails() {
		if (location == "Home") {
			System.out.println(name + " has 0 energy and goes " + location);
		} else {
			System.out.println(name + " has " + energy + " energy and goes to the " + location);

		}
	}

	/*
	 * Overwritten method run(); from the runnable interface. This method runs when
	 * a person thread is started. It decreases the energy of persons, changes their
	 * location depending on energy, and prints out details to the console.
	 */
	@Override
	public void run() {

		System.out.println(getName() + " is created with " + getEnergy() + " energy");

		while (energy > 0) {

			try {
				energy = energy - 10;
				Thread.sleep(1000);
				if (energy <= 30 && location != "Coffee-Room") {
					setLocation("Coffee-Room");
					printPersonDetails();
				}

				if (energy <= 0 && location != "Home") {
					setLocation("Home");
					printPersonDetails();
					Thread.yield();
				}

				if (energy >= 100 && location != "Office") {
					setLocation("Office");
					printPersonDetails();
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

}
