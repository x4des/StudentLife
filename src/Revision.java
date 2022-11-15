public class Revision implements Evenement{
    String name;
    public Revision() {
        this.name = "Révision";
    }

    @Override
    public String getNom(){
        return name;
    }

}
