//Un Evenement correspond au differentes "taches" de la journée de l'étudiant
public interface Evenement {
    //TODO: Methodes a rajouter
    String getNom();
    public boolean goPause();
    public boolean goCours();
    public boolean goRevision();
}
