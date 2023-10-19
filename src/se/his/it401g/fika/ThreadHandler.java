package se.his.it401g.fika;

import java.util.ArrayList;
import java.util.Collections;

/*
 * The class initializes the threads used in the program. It creates thread-objects and starts them. This class is also used to start the simulation.
 */

public class ThreadHandler {

	/*
	 * person objects to use as arguments in the thread constructor when creating
	 * person-threads.
	 */
	private Person person;

	/*
	 * Consume objects to use as arguments in the thread constructor when creating
	 * consume-threads.
	 */
	private Consume consume;

	/*
	 * Person thread that handles the person energy-countdown and location etc.
	 */
	private Thread personThread;

	/*
	 * Consume thread that handles when and if person consumes coffee.
	 */
	private Thread consumeThread;

	/*
	 * ArrayLists to easier loop through threads.
	 */
	ArrayList<String> names = new ArrayList<String>();
	ArrayList<Person> people = new ArrayList<Person>();
	ArrayList<Thread> consumeThreads = new ArrayList<Thread>();
	ArrayList<Thread> personThreads = new ArrayList<Thread>();

	/*
	 * CoffeeMachine object to retrieve coffee.
	 */
	private static CoffeeMachine coffeemachine;

	public ThreadHandler() {
		startSimulation();
	}

	/*
	 * Methods that starts the simulation.
	 */
	public void startSimulation() {
		setNames();
		instantiateThreads();
		startThreads();
	}

	/*
	 * Methods that instantiate the threads used in the program.
	 */
	private void instantiateThreads() {

		coffeemachine = new CoffeeMachine();

		for (int i = 0; i < 3; i++) {

			person = new Person(names.get(i), coffeemachine);
			people.add(person);
			names.remove(i);
			personThread = new Thread(people.get(i));
			personThreads.add(personThread);

			consume = new Consume(people.get(i), coffeemachine);
			consumeThread = new Thread(consume);
			consumeThreads.add(consumeThread);

		}

	}

	/*
	 * Methods that starts the threads used in the program.
	 */
	private void startThreads() {
		for (int i = 0; i < personThreads.size(); i++) {

			personThreads.get(i).start();

		}

		for (int i = 0; i < consumeThreads.size(); i++) {
			consumeThreads.get(i).start();

		}

		for (int i = 0; i < consumeThreads.size(); i++) {

			try {
				consumeThreads.get(i).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	/*
	 * Method that adds person names to a list. Used as arguments when creating
	 * person objects.
	 */
	private void setNames() {
		names.add("Tintin");
		names.add("Haddock");
		names.add("Kalkyl");
		names.add("Dupondt");
		names.add("Castafiore");
		names.add("Rastapopoulos");
		Collections.shuffle(names);

	}

}
