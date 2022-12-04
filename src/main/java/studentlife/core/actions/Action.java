package studentlife.core.actions;



import java.util.ArrayList;
public class Action {
    private String Scenario;
    private ArrayList<Choix> listRep;

    public Action(String scenario) {
        Scenario = scenario;
        listRep = new ArrayList<Choix>();
    }

    public String getScenario() {
        return Scenario;
    }

    public void setScenario(String scenario) {
        Scenario = scenario;
    }
}
