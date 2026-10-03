package GamingZone;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Game[] games = new Game[4];

		games[0] = new PCGame(101, "FIFA", 100, "PC");
		games[1] = new PCGame(102, "GTA V", 120, "PC");
		games[2] = new VRGame(201, "Beat Saber", 200, "Meta Quest");
		games[3] = new VRGame(202, "VR Racing", 250, "Oculus");

		Player[] players = new Player[10];

		Booking[] bookings = new Booking[10];

		int playerIndex = 0;
		int bookingIndex = 0;

		int choice;

		while (true) {

			System.out.println("\n===== GAMING ZONE MANAGEMENT SYSTEM =====");
			System.out.println("1. View Games");
			System.out.println("2. Register Player");
			System.out.println("3. Book Game");
			System.out.println("4. View Bookings");
			System.out.println("5. Make Payment");
			System.out.println("6. Exit");

			System.out.print("Enter your choice: ");
			choice = sc.nextInt();

			switch (choice) {

			case 1:

				System.out.println("\n----- AVAILABLE GAMES -----");

				for (int i = 0; i < games.length; i++) {
					games[i].displayGame();
					System.out.println("-------------------");
				}

				break;

			case 2:

				if (playerIndex < players.length) {

					System.out.print("Enter Player ID: ");
					int playerId = sc.nextInt();

					sc.nextLine();

					System.out.print("Enter Player Name: ");
					String name = sc.nextLine();

					System.out.print("Enter Age: ");
					int age = sc.nextInt();

					sc.nextLine();

					System.out.print("Enter Contact: ");
					String contact = sc.nextLine();

					if (age >= 10) {

						players[playerIndex] = new Player(playerId, name, age, contact);

						playerIndex++;

						System.out.println("Player Registered Successfully!");

					} else {
						System.out.println("Player age must be 10 or above.");
					}

				} else {
					System.out.println("Player limit is full.");
				}

				break;

			case 3:

				if (playerIndex == 0) {
					System.out.println("First register a player.");
					break;
				}

				if (bookingIndex < bookings.length) {

					System.out.print("Enter Player ID: ");
					int pid = sc.nextInt();

					Player selectedPlayer = null;

					for (int i = 0; i < playerIndex; i++) {

						if (players[i].getPlayerId() == pid) {
							selectedPlayer = players[i];
							break;
						}
					}

					if (selectedPlayer == null) {
						System.out.println("Player not found.");
						break;
					}

					System.out.println("\nAvailable Games:");

					for (int i = 0; i < games.length; i++) {
						System.out.println(i + " - " + games[i].getGameName());
					}

					System.out.print("Select Game Number: ");
					int gameChoice = sc.nextInt();

					if (gameChoice >= 0 && gameChoice < games.length) {

						System.out.print("Enter Hours: ");
						int hours = sc.nextInt();

						if (hours > 0) {

							System.out.print("Enter Booking ID: ");
							int bookingId = sc.nextInt();

							bookings[bookingIndex] = new Booking(bookingId, selectedPlayer, games[gameChoice], hours);

							bookingIndex++;

							System.out.println("Game Booked Successfully!");

						} else {
							System.out.println("Hours must be greater than 0.");
						}

					} else {
						System.out.println("Invalid game choice.");
					}

				} else {
					System.out.println("Booking limit is full.");
				}

				break;

			case 4:

				if (bookingIndex == 0) {

					System.out.println("No bookings available.");

				} else {

					System.out.println("\n----- BOOKINGS -----");

					for (int i = 0; i < bookingIndex; i++) {

						bookings[i].displayBooking();

						System.out.println("-------------------");
					}
				}

				break;

			case 5:

				if (bookingIndex == 0) {

					System.out.println("No booking available for payment.");

				} else {

					System.out.print("Enter Booking ID: ");
					int bid = sc.nextInt();

					Booking selectedBooking = null;

					for (int i = 0; i < bookingIndex; i++) {

						if (bookings[i].getBookingId() == bid) {
							selectedBooking = bookings[i];
							break;
						}
					}

					if (selectedBooking != null) {

						Payment payment = new Payment(501, selectedBooking);

						payment.displayPayment();

					} else {

						System.out.println("Booking not found.");
					}
				}

				break;

			case 6:

				System.out.println("Thank you for using Gaming Zone!");
				sc.close();
				return;

			default:

				System.out.println("Invalid choice!");
			}
		}
	}
}