package nl.cheesydevs.minetopia.modules;

public interface Module {

    String name();
    void onEnable();
    void onDisable();

}
