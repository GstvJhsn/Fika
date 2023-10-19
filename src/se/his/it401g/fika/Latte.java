package se.his.it401g.fika;

/**
 * @author Student - Gustav Johansson - DVSUG20G - University of Skövde
 */

/**
 * Sub-class of Coffee with unique name and energy.
 */
public class Latte extends Coffee {
	private final String TYPE_NAME = "Latte";
	private final int ENERGY_INTERVAL = getRandom().nextInt(35 - 25) + 25;

	Latte() {
		setCoffeeName(TYPE_NAME);
		energize(ENERGY_INTERVAL);
	}
}
