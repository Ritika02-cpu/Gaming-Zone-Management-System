package GamingZone;

public class VRGame extends Game {

    private String vrDevice;

    public VRGame(int gameId, String gameName, double pricePerHour, String vrDevice) {
        super(gameId, gameName, pricePerHour);
        this.vrDevice = vrDevice;
    }

    public String getVrDevice() {
        return vrDevice;
    }

    @Override
    public void displayGame() {
        System.out.println("Game ID: " + getGameId());
        System.out.println("Game Name: " + getGameName());
        System.out.println("Price Per Hour: ₹" + getPricePerHour());
        System.out.println("VR Device: " + vrDevice);
    }
}