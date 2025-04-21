import java.util.ArrayList;
import java.util.List;

public class Admin {
     public List<Ride> rides;

    public Admin() {
        this.rides = new ArrayList<>();
    }

    public void addRide(Ride ride) {
        rides.add(ride);
        System.out.println("Ride " + ride + " added to the park.");
    }
}