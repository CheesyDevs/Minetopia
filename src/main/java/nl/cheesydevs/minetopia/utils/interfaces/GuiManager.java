package nl.cheesydevs.minetopia.utils.interfaces;

import nl.cheesydevs.minetopia.Minetopia;

import java.util.ArrayList;
import java.util.List;

public class GuiManager {
    private static final List<Gui> guiList = new ArrayList<>();

    public static void register(Gui gui) {
        if(!guiList.contains(gui)) {
            guiList.add(gui);
        } else {
            Minetopia.getInstance().getLogger().severe("Double gui register... ["+gui.getTitle()+"]");
        }
    }

    public static Gui get(String title) {
        for (Gui gui : getGuiList()) {
            if(gui.getTitle().equals(title)) {
                return gui;
            }
        }
        return null;
    }

    public static List<Gui> getGuiList() {
        return guiList;
    }
}
