package preponderous.ponder.math.random;

import java.util.Random;

/**
 * @author Daniel McCoy Stephenson
 * @since January 7th, 2022
 */
public class RandomNumberGenerator {
    Random random = new Random();

    public int generateRandomInteger(int bound) {
        reinitialize();
        return random.nextInt(bound);
    }

    public double generateRandomDouble(int bound) {
        reinitialize();
        return random.nextDouble() * bound;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public void reinitialize() {
        setRandom(new Random());
    }
}