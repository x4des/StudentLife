package studentlife.core.characters;


/**
 *La classe Stat représente une statistique
 qui possède des seuils, un nom, une valeur qui sera modifier tout au long de la simulation
 ainsi qu'un pourcentage de 45%, ce pourcentage nous permet de modifier la stat de la fatigue
 par rapport à celle de la faim.
 * */
public class Stat {

    /**le seuil max*/
    public static final int MAX_STAT = 100;

    /**le seuil min*/
    public static final int MIN_STAT = 0;

    /** pourcentage de modif de la valeur des stats */
    public static final double PRCNT = 0.45;

    /**nom de la stat*/
    private final String name;

    /**la valeur de la stat*/
    private int value;

    /**
     * @param name nom de la statistique
     * @param value valeur de la statistique
     * constructeur d'une statistique
     * */
    public Stat(String name, int value) {
        this.name = name;
        setValue(value);
    }

    /**
     * @param value cette value est la valeur que l'on veut affecter à la valeur de la stat actuel
     * cette procedure change la valeur de la stat actuel, si celle-ci dépasse un seuil,
     elle est remplacée par ce même seuil pour ne pas avoir de dépassement.
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
     * @param value c'est la valeur que l'on rajoutera à la valeur de la stat actuel
     * cette procedure vérifie si apres avoir incrementer la valeur de la stat avec la valeur de value,
     celle-ci ne dépasse pas les seuils, si oui, la valeur de la stat sera remplacé par un seuil
     sinon sera incrémenté par value (le paramètre).
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



    /**
     * @return getter qui permet d'accéder à la valeur de la stat
     * */
    public int getValue() {
        return value;
    }

    /**
     * @return getter qui retourne la valeur du pourcentage afin d'y accéder
     * */
    public double getPrcnt(){
        return PRCNT;
    }

    /**
     * @return getter qui permet d'accéder a l'attribut nom de la stat
     * */
    public String getName() {
        return this.name;
    }

    /**
     * @return retourne la valeur du seuil max d'une stat
     * */
    public int getMaxStat(){
        return MAX_STAT;
    }
}
