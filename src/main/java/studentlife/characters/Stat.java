package studentlife.characters;

public class Stat {

    private final String name;
    private int value;

    public Stat(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return this.name;
    }
}
