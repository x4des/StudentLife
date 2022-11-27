package studentlife.core.characters;

public class Stat {

    public static final int MAX_STAT = 100;
    public static final int MIN_STAT = 0;

    private final String name;
    private int value;

    public Stat(String name, int value) {
        this.name = name;
        setValue(value);
    }


    public void setValue(int value) { //sets the value

        if(value < MIN_STAT) {
            this.value = MIN_STAT;
            return;
        }

        if(value > MAX_STAT) {
            this.value = MAX_STAT;
            return;
        }

        this.value = value;
    }

    public void updateValue(int value){ //increases or decreases the value
        if (this.value + value < MIN_STAT){
            this.value = MIN_STAT;
        }

        if (this.value + value > MAX_STAT){
            this.value = MAX_STAT;
        }

        this.value += value;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return this.name;
    }
}
