package nl.cheesydevs.minetopia.utils;

public enum Version {
    unknown("unknown"),
    v1_12_2("1.12.2"),
    v1_13_2("1.13.2"),
    v1_14_4("1.14.4"),
    v1_15_2("1.15.2"),
    v1_16_5("1.16.5"),
    v1_17_1("1.17.1"),
    v1_18("1.18");

    private final String version;

    Version(String version) {
        this.version = version;
    }

    public String toString() {
        return version;
    }
}
