package se.his.it401g.fika;

import java.util.Random;

/**
 * @author Student - Gustav Johansson - DVSUG20G - University of Skövde
 */

/*
 * This class is used to generate a random value between 30 and 90.
 * 
 */
public class Randomise {
	Random random = new Random();
	int randomValue;

	enum RandomEnums {
		MAX(90), MIN(0), START_MIN(30);

		int randomEnum;

		RandomEnums(int randomEnum) {
			this.randomEnum = randomEnum;
		}
	}

	int randomize(int a) {
		a = random.nextInt(RandomEnums.MAX.randomEnum - RandomEnums.START_MIN.randomEnum)
				+ RandomEnums.START_MIN.randomEnum;
		return a;
	}

}
