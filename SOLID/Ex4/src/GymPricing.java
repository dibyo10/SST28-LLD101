public class GymPricing implements AddOnPricing {
    public boolean supports(AddOn addOn) {
        return addOn == AddOn.GYM;
    }

    public double price() {
        return 300.0;
    }
}
