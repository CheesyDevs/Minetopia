package nl.cheesydevs.minetopia.utils.interfaces;

public class GuiSlots {
    private final int rows;
    private int extraSlots = 0;

    public GuiSlots(int rows, int extraSlots) {
        this.rows = rows;
        this.extraSlots = extraSlots;
    }
    public GuiSlots(int rows) {
        this.rows = rows;
    }

    public int toInteger() {
        return (9*rows)+extraSlots;
    }

    public int getExtraSlots() {
        return extraSlots;
    }
    public int getRows() {
        return rows;
    }
}
