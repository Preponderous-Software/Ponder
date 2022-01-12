/*
  Copyright (c) 2022 Preponderous Software
  MIT License
 */
package preponderous.ponder.math.random;

import java.util.Random;

/**
 * @author Daniel McCoy Stephenson
 * @since January 7th, 2022
 */
public class RandomNumberGenerator {
    private Random random = new Random();

    /**
     * This can be utilized to generated a random integer up to a bound.
     * @param bound The bound for the possible numbers.
     * @return A random integer up to the given bound.
     */
    public int generateRandomInteger(int bound) {
        reinitialize();
        return random.nextInt(bound);
    }

    /**
     * This can be utilized to generate a random double up to a bound.
     * @param bound The bound for the possible numbers.
     * @return A random double up to the given bound.
     */
    public double generateRandomDouble(int bound) {
        reinitialize();
        return random.nextDouble() * bound;
    }

    /**
     * This can be used to access the inner Random class of the RNG.
     * @return The inner Random class of the RNG.
     */
    public Random getRandom() {
        return random;
    }

    /**
     * Sets the inner Random class of the RNG.
     * @param random The new random class of the RNG.
     */
    public void setRandom(Random random) {
        this.random = random;
    }

    /**
     * Reinitializes the Random class of the RNG.
     */
    public void reinitialize() {
        setRandom(new Random());
    }
}