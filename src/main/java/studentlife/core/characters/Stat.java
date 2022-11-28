package studentlife.core.characters;

//import org.jetbrains.annotations.NotNull;

public class Stat {

    public static final int MAX_STAT = 100;
    public static final int MIN_STAT = 0;

    public static final double PRCNT = 0.25;

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
        }else if (this.value + value > MAX_STAT){
            this.value = MAX_STAT;
        }else {
            this.value += value;
        }
    }

    /*public void updateValue(@NotNull Stat stat, char operation){ //augmente ou diminue la valeur d'une stat en fonction d'une autre stat
        int newval = (int)(stat.value*PRCNT);

        if (operation == '+'){
            if (this.value + newval > MAX_STAT){
                this.value = MAX_STAT;
            }else{
                this.value += newval;
            }
        }

        if (operation == '-'){
            if (this.value - newval < MIN_STAT){
                this.value = MIN_STAT;
            }else{
                this.value-=newval;
            }
        }

    }*/



    public int getValue() {
        return value;
    }

    public String getName() {
        return this.name;
    }
}
