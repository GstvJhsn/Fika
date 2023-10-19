package se.his.it401g.fika;

/**
 * @author Student - Gustav Johansson - DVSUG20G - University of Skövde
 */

/**
 * Sub-class of Coffee with unique name and energy.
 */
public class Capuccino extends Coffee {
	private final String TYPE_NAME = "Capuccino";
	private final int ENERGY_INTERVAL = getRandom().nextInt(30 - 20) + 20;

	Capuccino() {
		setCoffeeName(TYPE_NAME);
		energize(ENERGY_INTERVAL);
	}
}
