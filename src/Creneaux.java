public class Creneaux {
    private String professeur;
    private String name;
    private String type;

    public Creneaux(String name, String type, String prof){
        this.professeur = prof;
        this.name = name;
        this.type = type;
    }

    public String getName(){return this.name;}

    public String getProfesseur() {
        return this.professeur;
    }

    public String getType(){return this.type;}

    public void writte(){
        String pause = "Pause";
        if(this.name.equals(pause)){
            System.out.println(this.name);
            return;
        }
        System.out.println("Matière : " + this.name + ", Type : " + this.type);
    }
}
