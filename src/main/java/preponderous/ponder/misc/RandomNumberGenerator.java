/*
  Copyright (c) 2022 Preponderous Software
  MIT License
 */
package preponderous.ponder.misc;

import java.util.Random;

/**
 * @author Daniel McCoy Stephenson
 * @since January 7th, 2022
 */
public class RandomNumberGenerator {
    private Random random = new Random();

    /**
     * @param bound The bound for the possible numbers.
     * @return A random integer up to the given bound.
     */
    public int generateRandomInteger(int bound) {
        reinitializeRandom();
        return random.nextInt(bound);
    }

    /**
     * @param bound The bound for the possible numbers.
     * @return A random double up to the given bound.
     */
    public double generateRandomDouble(int bound) {
        reinitializeRandom();
        return random.nextDouble() * bound;
    }

    /**
     * @return The inner Random class of the RNG.
     */
    public Random getRandom() {
        return random;
    }

    /**
     * @param random The new random class of the RNG.
     */
    public void setRandom(Random random) {
        this.random = random;
    }

    public void reinitializeRandom() {
        setRandom(new Random());
    }
}