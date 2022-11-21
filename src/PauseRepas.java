public class PauseRepas extends Pause{


    public PauseRepas(){
        super.nom = "Pause Repas";
    }


    public String getNom(){
        return this.nom;
    }

    @override
    public void finaliserEvenement(Etudiant utilisateur, boolean valid){}

    @override
    public void evenementActuel(String evenChoice){}

}
