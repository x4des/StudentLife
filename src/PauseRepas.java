public class PauseRepas extends Pause{


    public PauseRepas(){
        super.nom = "Pause Repas";
    }


    public String getNom(){
        return this.nom;
    }

    @Override
    public void finaliserEvenement(Etudiant utilisateur, boolean valid){}

    @Override
    public void evenementActuel(String evenChoice){}

}
