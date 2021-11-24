package nl.cheesydevs.minetopia.Utils;

public enum Version {
    unknown("unknown"),
    v1_12_2("1.12.2"),
    v1_13("1.13"),
    v1_14("1.14"),
    v1_15("1.15"),
    v1_16("1.16"),
    v1_17("1.17");

    String version;

    Version(String version) {
        this.version = version;
    }

    public String toString() {
        return version;
    }
}
