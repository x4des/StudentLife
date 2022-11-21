public class Revision implements Evenement{
    String name;
    public Revision() {
        this.name = "Révision";
    }

    @Override
    public String getNom(){
        return name;
    }

    @Override
    public void finaliserEvenement(Etudiant utilisateur, boolean valid) {

    }

    @Override
    public void evenementActuel(String evenChoice){

    }

}
