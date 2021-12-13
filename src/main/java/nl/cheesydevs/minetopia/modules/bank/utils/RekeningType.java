package nl.cheesydevs.minetopia.modules.bank.utils;

public enum RekeningType {
    SAVINGS,
    PERSONAL,
    COMPANY;

    public static RekeningType get(String s) {
        return valueOf(s.toUpperCase());
    }

    public static boolean exists(String s) {
        try {
            valueOf(s.toUpperCase());
            return true;
        } catch (IllegalArgumentException ignore) {
            return false;
        }
    }
}
