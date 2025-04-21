import java.util.ArrayList;
import java.util.List;

public class Admin {
    private List<Court> courts;

    public Admin() {
        this.courts = new ArrayList<>();
    }

    public void addCourt(Court court) {
        courts.add(court);
        System.out.println("Added " + court.getSportType() + " court.");
    }

    public List<Court> getCourts() {
        return courts;
    }
}