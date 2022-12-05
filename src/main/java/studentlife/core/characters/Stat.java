package studentlife.core.characters;


/**
 *La classe Stat represente une statistique
 qui possède des seuils, un nom, une valeur qui sera modifier tout au long de la simu
 ainsi qu'un pourcentage de 45%, ce pourcentage enous permet de modifier la stat de la fatigue
 par rapport a celle de la faim.
 }
 * */
public class Stat {

    public static final int MAX_STAT = 100; //le seuil max
    public static final int MIN_STAT = 0; //le seuil min

    public static final double PRCNT = 0.45; //pourcentage de modif de la valeur des stats

    private final String name; //nom de la stat
    private int value; //valeur

    /**
     * @param name
     * @param value
     * constructeur d'une statistique
     * */
    public Stat(String name, int value) {//constructeur
        this.name = name;
        setValue(value);
    }

    /**
     * @param value cette value est la valeur que l'on veut affecter à la valeur de la stat actuel
     * cette procedure change la valeur de la stat actuel, si celle si depasse un seuil,
     elle est remplacé par ce meme seuil pour ne pas avoir de depassement.
     * */
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

    /**
     * @param value c'est la valeure que l'on rajoutera à la valeur de la stat actuel
     * cette procedure verifie si apres avoir incrementer la valeur de la stat avec la valeur de value,
     celle-ci ne depasse pas les euils, si oui, la valeur de la stat sera remplacé par un seuil
     sinon sera incremente par value (le parametre)
     * */
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

    /**
     * @return getter permet d'acceder à la valeur de la stat
     * */
    public int getValue() {
        return value;
    }
    /**
     * @return getter qui retroune la valeur du pourcentage afin d'y acceder
     * */
    public double getPrcnt(){
        return PRCNT;
    }

    /**
     * @return getter qui permet d'acceder a l'attribut nom de la stat
     * */
    public String getName() {
        return this.name;
    }

    /**
     * @return retourn la valeur du seuil max d'une stat
     * */
    public int getMaxStat(){
        return MAX_STAT;
    }
}
