import com.example.tickets.IncidentTicket;
import com.example.tickets.TicketService;

import java.util.List;

/**
 * Demo showing immutability in action.
 */
public class TryIt {

    public static void main(String[] args) {
        TicketService service = new TicketService();

        IncidentTicket t = service.createTicket("TCK-1001", "reporter@example.com", "Payment failing on checkout");
        System.out.println("Created: " + t);

        // Service methods now return NEW instances instead of mutating
        IncidentTicket t2 = service.assign(t, "agent@example.com");
        System.out.println("\nAfter assign (new instance): " + t2);
        System.out.println("Original unchanged: " + t);

        IncidentTicket t3 = service.escalateToCritical(t2);
        System.out.println("\nAfter escalate (new instance): " + t3);
        System.out.println("Previous instance unchanged: " + t2);

        // Demonstrate that tags list is now unmodifiable
        List<String> tags = t3.getTags();
        System.out.println("\nTrying to modify tags externally...");
        try {
            tags.add("HACKED_FROM_OUTSIDE");
            System.out.println("ERROR: Should have thrown exception!");
        } catch (UnsupportedOperationException e) {
            System.out.println("SUCCESS: Tags list is immutable, cannot be modified from outside");
        }
        System.out.println("Ticket unchanged: " + t3);
    }
}
