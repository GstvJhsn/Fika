package se.his.it401g.fika;

/**
 * @author Student - Gustav Johansson - DVSUG20G - University of Skövde
 */

/**
 * This class is for threads to handle the process of persons consuming Coffee
 * from the coffee-machine.
 */
public class Consume implements Runnable {

	/*
	 * Objects to retrieve energy level of persons and coffee from the
	 * CoffeeMachine.
	 */
	private Person person;
	private CoffeeMachine coffeeMachine;

	public Consume(Person person, CoffeeMachine cm) {
		this.person = person;
		this.coffeeMachine = cm;
	}

	/*
	 * Method that increases the energy level of a person object. The method is
	 * synchronized so only one thread can execute the method at a time.
	 */
	private synchronized void consumeCoffee() {

		if (coffeeMachine.getCoffeeReserve().isEmpty() || coffeeMachine.getCoffeeReserve() == null
				|| coffeeMachine.getCoffeeReserve().size() == 0) {
			return;
		}

		if (!coffeeMachine.getCoffeeReserve().isEmpty()) {
			
			if (person.getLocation() == "Coffee-Room" && coffeeMachine.getCoffeeReserve() != null) {
				
				try {
					person.gainEnergy(coffeeMachine.getCoffeeReserve().get(0).getEnergy());
					printConsumeDetails();
					coffeeMachine.removeCoffee();
					coffeeMachine.perhapsProduceMoreCoffee();
					coffeeMachine.printCoffeeMachineDetails();
					
				} catch (NullPointerException e) {
					return;
				}
				
				try {
					Thread.sleep(1000);

				} catch (InterruptedException e) {
					e.printStackTrace();
				
				}
			}

		}

	}

	/*
	 * Method that prints consume details to the console.
	 */
	private void printConsumeDetails() {
		System.out.println(
				person.getName() + " Drinks a cup of " + coffeeMachine.getCoffeeReserve().get(0).getCoffeeName()
						+ " and has now energy level of " + person.getEnergy());
	}

	/*
	 * Overwritten method run(); from the runnable interface. This method runs when
	 * a Consume thread is started. It increases the energy of persons when they
	 * drink from the coffee machine.
	 */
	@Override
	public void run() {

		while (person.getEnergy() > 0) {

			try {
				consumeCoffee();
			} catch (IndexOutOfBoundsException e) {

				System.out.println(person.getName() + " spilled his cup!");
				consumeCoffee();

			}

		}

	}

}
