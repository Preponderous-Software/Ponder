package preponderous.ponder.misc;

import java.util.Random;

public class RandomStringGenerator {
    private Random random = new Random();

    /**
     * @param length The length of the string to generate.
     * @return A random string of the given length.
     */
    public String generateRandomString(int length) {
        final char[] alphabetArray = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        Random random = new Random();
        StringBuilder toReturn = new StringBuilder();
        for (int i = 0; i < length; i++) {
            toReturn.append(alphabetArray[random.nextInt(alphabetArray.length)]);
        }
        return toReturn.toString();
    }

    /**
     * @return The inner Random class of the RSG.
     */
    public Random getRandom() {
        return random;
    }

    /**
     * @param random The new random class of the RSG.
     */
    public void setRandom(Random random) {
        this.random = random;
    }

    public void reinitializeRandom() {
        setRandom(new Random());
    }
}
