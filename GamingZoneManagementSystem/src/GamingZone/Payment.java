package GamingZone;

public class Payment {

    private int paymentId;
    private Booking booking;
    private double amount;

    public static final double TAX_RATE = 0.18;

    public Payment(int paymentId, Booking booking) {

        this.paymentId = paymentId;
        this.booking = booking;

        double baseAmount = booking.getTotalAmount();

        if (baseAmount > 0) {
            amount = baseAmount + (baseAmount * TAX_RATE);
        } else {
            amount = 0;
        }
    }

    public int getPaymentId() {
        return paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public void displayPayment() {

        System.out.println("Payment ID: " + paymentId);
        System.out.println("Booking ID: " + booking.getBookingId());
        System.out.println("Game: " + booking.getGame().getGameName());
        System.out.println("Amount: ₹" + amount);
    }
}