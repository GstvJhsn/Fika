package se.his.it401g.fika;

/**
 * @author Student - Gustav Johansson - DVSUG20G - University of Skövde
 */

/**
 * Sub-class of Coffee with unique name and energy.
 */
public class BlackCoffee extends Coffee {
	private final String TYPE_NAME = "BlackCoffee";
	private final int ENERGY_INTERVAL = getRandom().nextInt(40 - 20) + 20;

	BlackCoffee() {
		setCoffeeName(TYPE_NAME);
		energize(ENERGY_INTERVAL);
	}

}
