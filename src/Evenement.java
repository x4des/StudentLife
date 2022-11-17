//Un Evenement correspond au differentes "taches" de la journée de l'étudiant
public interface Evenement {
    //TODO: Methodes a rajouter
    public String getNom();
    //method "finaliser" param: etudiant, choix pour changer ses stats
    public void finaliserEvenement(Etudiant utilisateur, boolean valid);
}
