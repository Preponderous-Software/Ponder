package preponderous.ponder.toolbox.nms;

/**
 * @author Callum Johnson
 * @since 11/12/2021 - 22:45
 */
public class NMSAssistant {

    /**
     * Method to get the NMS Version which stands for the current server-version.
     *
     * @return {@link NMSVersion}.
     */
    public NMSVersion getNMSVersion() {
        return new NMSVersion();
    }

    /**
     * Method to determine if the server version is greater than the given version.
     *
     * @param version to test against.
     * @return {@code true} if it is.
     */
    public boolean isVersionGreaterThan(int version) {
        return getNMSVersion().getMinor() > version;
    }

    /**
     * Method to determine if the server version is less than the given version.
     *
     * @param version to test against.
     * @return {@code true} if it is.
     */
    public boolean isVersionLessThan(int version) {
        return getNMSVersion().getMinor() < version;
    }

    /**
     * Method to determine if the server is currently running this specific version.
     *
     * @param version to check against.
     * @return {@code true} if it is.
     */
    public boolean isVersion(int version) {
        return getNMSVersion().getMinor() == version;
    }

    /**
     * Method to determine if the sever isn't currently running this specific version.
     *
     * @param version to check against.
     * @return {@code true} if it isn't.
     */
    public boolean isntVersion(int version) {
        return getNMSVersion().getMinor() != version;
    }

}
