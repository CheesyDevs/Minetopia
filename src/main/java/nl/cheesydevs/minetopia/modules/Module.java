package nl.cheesydevs.minetopia.modules;

public interface Module {

    /**
     * The name of the module
     * @return name of module
     */
    String name();

    /**
     * When the module enables
     */
    void onEnable();

    /**
     * When the module disabled
     */
    void onDisable();

}
