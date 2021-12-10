package nl.cheesydevs.minetopia.utils.version;

public enum Version {
    unknown("unknown"),
    v1_12_2("1.12"),
    v1_13_2("1.13"),
    v1_14_4("1.14"),
    v1_15_2("1.15"),
    v1_16_5("1.16"),
    v1_17_1("1.17"),
    v1_18("1.18");

    private final String version;

    Version(String version) {
        this.version = version;
    }

    public String toString() {
        return version;
    }
}
