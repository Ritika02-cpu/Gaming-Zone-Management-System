package GamingZone;

public class PCGame extends Game {

    private String platform;

    public PCGame(int gameId, String gameName, double pricePerHour, String platform) {
        super(gameId, gameName, pricePerHour);
        this.platform = platform;
    }

    public String getPlatform() {
        return platform;
    }

    @Override
    public void displayGame() {
        System.out.println("Game ID: " + getGameId());
        System.out.println("Game Name: " + getGameName());
        System.out.println("Price Per Hour: ₹" + getPricePerHour());
        System.out.println("Platform: " + platform);
    }
}