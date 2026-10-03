package GamingZone;

public class Player {

    private int playerId;
    private String playerName;
    private int age;
    private String contact;

    static int playerCount = 0;

    public Player(int playerId, String playerName, int age, String contact) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.age = age;
        this.contact = contact;

        playerCount++;
    }

    public int getPlayerId() {
        return playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getAge() {
        return age;
    }

    public String getContact() {
        return contact;
    }

    public void displayPlayer() {
        System.out.println("Player ID: " + playerId);
        System.out.println("Player Name: " + playerName);
        System.out.println("Age: " + age);
        System.out.println("Contact: " + contact);
    }

    public static void displayPlayerCount() {
        System.out.println("Total Players: " + playerCount);
    }
}