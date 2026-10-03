package GamingZone;

public class Booking {

    private int bookingId;
    private Player player;
    private Game game;
    private int hours;
    private double totalAmount;

    static int bookingCount = 0;

    public Booking(int bookingId, Player player, Game game, int hours) {

        this.bookingId = bookingId;
        this.player = player;
        this.game = game;
        this.hours = hours;

        bookingCount++;

        if (hours > 0) {
            totalAmount = game.getPricePerHour() * hours;
        } else {
            totalAmount = 0;
        }
    }

    public int getBookingId() {
        return bookingId;
    }

    public Player getPlayer() {
        return player;
    }

    public Game getGame() {
        return game;
    }

    public int getHours() {
        return hours;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void displayBooking() {

        System.out.println("Booking ID: " + bookingId);
        System.out.println("Player: " + player.getPlayerName());
        System.out.println("Game: " + game.getGameName());
        System.out.println("Hours: " + hours);
        System.out.println("Total Amount: ₹" + totalAmount);
    }

    public static void displayBookingCount() {
        System.out.println("Total Bookings: " + bookingCount);
    }
}