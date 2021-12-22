package nl.cheesydevs.minetopia.utils.interfaces;

@SuppressWarnings("unused")
public class GuiSlots {
    private final int rows;
    private int extraSlots = -1;

    public GuiSlots(int rows, int extraSlots) {
        this.rows = rows;
        this.extraSlots = extraSlots;
    }
    public GuiSlots(int rows) {
        this.rows = rows;
    }

    public int toInteger() {
        if(rows > 0 && extraSlots > -1) return 9*(rows-1)+extraSlots;
        return 9*rows;
    }

    public String toString() {
        if(rows > 0 && extraSlots > -1) return String.valueOf(9*(rows-1)+extraSlots);
        return String.valueOf(9*rows);
    }

    public int getExtraSlots() {
        return extraSlots;
    }
    public int getRows() {
        return rows;
    }
}
