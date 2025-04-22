import java.util.LinkedList;
import java.util.Queue;

public class Ride {
    private String name;
    private int capacity;
    private int duration;
    private Queue<Visitor> vipQueue;
    private Queue<Visitor> regularQueue;

    public Ride(String name, int capacity, int duration) {
        this.name = name;
        this.capacity = capacity;
        this.duration = duration;
        this.vipQueue = new LinkedList<>();
        this.regularQueue = new LinkedList<>();
    }
    public String getName() {
        return name;
    }

    public void addVisitor(Visitor visitor) {
        if (visitor instanceof VIPVisitor) {
            vipQueue.add(visitor);
            System.out.println(visitor.getName() + " (VIP) joined the VIP queue for " + name);
        } else {
            regularQueue.add(visitor);
            System.out.println(visitor.getName() + " joined the regular queue for " + name);
        }
    }

    public void startRide() {
        System.out.println("\n--- Starting ride: " + name + " ---");
        int spotsFilled = 0;

        // اول پر کردن از صف VIP
        while (spotsFilled < capacity && !vipQueue.isEmpty()) {
            Visitor v = vipQueue.poll();
            System.out.println(v.getName() + " (VIP) is enjoying " + name);
            spotsFilled++;
        }

        // سپس پر کردن با افراد عادی
        while (spotsFilled < capacity && !regularQueue.isEmpty()) {
            Visitor v = regularQueue.poll();
            System.out.println(v.getName() + " is enjoying " + name);
            spotsFilled++;
        }

        if (spotsFilled == 0) {
            System.out.println("No visitors on the ride.");
        }
    }
}