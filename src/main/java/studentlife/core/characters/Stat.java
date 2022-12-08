package studentlife.core.characters;


/**
 *La classe Stat représente une statistique
 qui possède des seuils, un nom, une valeur qui sera modifiée tout au long de la simulation
 ainsi qu'un pourcentage de 45%, ce pourcentage nous permet de modifier la stat de la fatigue
 par rapport à celle de la faim.
 * */
public class Stat {

    /** le seuil max */
    public static final int MAX_STAT = 100;

    /** le seuil min */
    public static final int MIN_STAT = 0;

    /** pourcentage de modif de la valeur des stats */
    public static final double PRCNT = 0.45;

    /** nom de la stat */
    private final String name;

    /** la valeur de la stat */
    private int value;


    /**
     * constructeur d'une statistique
     * @param name nom de la statistique
     * @param value valeur de la statistique
     * */
    public Stat(String name, int value) {
        this.name = name;
        setValue(value);
    }


    /**
     * cette méthode affecte une valeur à la Stat, si celle-ci dépasse un seuil,
     * elle est remplacée par ce même seuil pour ne pas avoir de dépassement.
     * @param value cette value est la valeur que l'on veut affecter à la valeur de la Stat concernée
     * */
    public void setValue(int value) {

        if(value < MIN_STAT) { //si < 0
            this.value = MIN_STAT;
            return;
        }

        if(value > MAX_STAT) { //si >100
            this.value = MAX_STAT;
            return;
        }

        this.value = value; //sinon affectation normale
    }


    /**
     *  Cette méthode vérifie si après avoir modifié la valeur de la stat avec la valeur de value,
     *  que celle-ci ne dépasse pas les seuils, si oui, la valeur de la stat sera remplacée par un seuil.
     *  Sinon on ajoutera la valeur souhaitée à la valeur actuelle de la Stat.
     *  Value peut être positive ou négative.
     * @param value c'est la valeur que l'on "rajoutera" à la valeur de la stat actuelle.
     * */
    public void updateValue(int value) {
        if (this.value + value < MIN_STAT) {
            this.value = MIN_STAT;
        } else if (this.value + value > MAX_STAT) {
            this.value = MAX_STAT;
        } else {
            this.value += value; //si les seuils ne sont pas dépasses -> ajout normal
        }
    }


    /**
     * getter qui permet d'avoir la valeur de la Stat
     * @return la valeur de la Stat
     * */
    public int getValue() {
        return value;
    }


    /**
     * getter qui retourne la valeur du pourcentage qui sera utilisé ensuite pour manipuler le StatManager
     * @return pourcentage défini
     * */
    public double getPrcnt(){
        return PRCNT;
    }


    /**
     * getter qui permet d'avoir a l'attribut nom de la stat
     * @return le nom de la Stat
     * */
    public String getName() {
        return this.name;
    }


    /**
     * getter qui permet d'avoir le seuil maximal d'une Stat
     * @return la valeur du seuil maximal d'une Stat
     * */
    public int getMaxStat(){
        return MAX_STAT;
    }
}
