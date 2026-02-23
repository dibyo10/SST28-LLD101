import java.util.*;

public class HostelFeeCalculator {
    private final FakeBookingRepo repo;
    private final List<RoomPricing> roomPricings;
    private final List<AddOnPricing> addOnPricings;

    public HostelFeeCalculator(FakeBookingRepo repo, List<RoomPricing> roomPricings, List<AddOnPricing> addOnPricings) {
        this.repo = repo;
        this.roomPricings = roomPricings;
        this.addOnPricings = addOnPricings;
    }

    public void process(BookingRequest req) {
        Money monthly = calculateMonthly(req);
        Money deposit = new Money(5000.00);

        ReceiptPrinter.print(req, monthly, deposit);

        String bookingId = "H-" + (7000 + new Random(1).nextInt(1000));
        repo.save(bookingId, req, monthly, deposit);
    }

    private Money calculateMonthly(BookingRequest req) {
        double base = 16000.0;
        for (RoomPricing rp : roomPricings) {
            if (rp.supports(req.roomType)) {
                base = rp.basePrice();
                break;
            }
        }

        double add = 0.0;
        for (AddOn a : req.addOns) {
            for (AddOnPricing ap : addOnPricings) {
                if (ap.supports(a)) {
                    add += ap.price();
                    break;
                }
            }
        }

        return new Money(base + add);
    }
}
