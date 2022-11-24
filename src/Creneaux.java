public class Creneaux {
    private String name;
    private String type;

    public Creneaux(String name, String type){
        this.name = name;
        this.type = type;
    }

    public String getName(){return this.name;}

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
