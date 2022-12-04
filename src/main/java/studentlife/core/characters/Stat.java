package studentlife.core.characters;



public class Stat {

    public static final int MAX_STAT = 100; //le seuil max
    public static final int MIN_STAT = 0; //le seuil min

    public static final double PRCNT = 0.45; //pourcentage de modif de la valeur des stats

    private final String name; //nom de la stat
    private int value; //valeur

    public Stat(String name, int value) {//constructeur
        this.name = name;
        setValue(value);
    }

    //affecte une valeur, vérifie si on ne dépasse pas le seuil
    public void setValue(int value) {

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

    //incrémente ou décrémente la valeur, vérifie si on ne dépasse pas le seuil
    public void updateValue(int value) {
        if (this.value + value < MIN_STAT) {
            this.value = MIN_STAT;
        } else if (this.value + value > MAX_STAT) {
            this.value = MAX_STAT;
        } else {
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

    public double getPrcnt(){
        return PRCNT;
    }

    public String getName() {
        return this.name;
    }


    public int getMaxStat(){
        return MAX_STAT;
    }
}
