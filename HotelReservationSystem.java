import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class HotelReservationSystem {

    private Hotel hotel;

    public HotelReservationSystem() {
        hotel = new Hotel();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HotelReservationSystem h = new HotelReservationSystem();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        while (true) {
            System.out.println("1. Welcome");
            System.out.println("2. Search for Room");
            System.out.println("3. Make Reservation");
            System.out.println("4. Room Booking Details");
            System.out.println("5. Exit");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Welcome to Hotel Reservation System");
                    break;

                case 2:
                    System.out.println("Enter the Room category (Single/Double)");
                    String category = sc.nextLine();
                    List<Room> availableRooms = h.hotel.searchRoom(category);
                    if (availableRooms.isEmpty()) {
                        System.out.println("The room is not available");
                    } else {
                        for (Room room : availableRooms) {
                            System.out.println("Room number: " + room.getRoomNo() + ", Price: " + room.getPrice());
                        }
                    }
                    break;

                case 3:
                    System.out.println("Enter a room number:");
                    int roomNumber = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter a name:");
                    String name = sc.nextLine();
                    System.out.println("Enter a payment method:");
                    String paymentMethod=sc.nextLine();
                    System.out.println("Enter check-in date (yyyy-MM-dd):");
                    Date checkIn = null;
                    Date checkOut = null;
                    
                    try {
                        checkIn = dateFormat.parse(sc.nextLine());
                        System.out.println("Enter check-out date (yyyy-MM-dd):");
                        checkOut = dateFormat.parse(sc.nextLine());
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please use yyyy-MM-dd.");
                        break;
                    }

                    Reservation reservation = h.hotel.makeReservation(roomNumber, name, checkIn, checkOut,paymentMethod);
                    if (reservation != null) {
                        System.out.println("Reservation Successful");
                        System.out.println("Total Cost: " + reservation.getTotalCost());
                        System.out.println("Payment Method: " + reservation.getPayment());
                    } else {
                        System.out.println("Reservation failed. The room might not be available.");
                    }
                    break;

                case 4:
                    System.out.println("Enter Reservation ID:");
                    int id = sc.nextInt();
                    Reservation res = h.hotel.bookingdetails(id);
                    if (res != null) {
                        System.out.println("Reservation Details:");
                        System.out.println("Room number: " + res.getRoom().getRoomNo());
                        System.out.println("Customer name: " + res.getName());
                        System.out.println("Check-in: " + res.getCheckIn());
                        System.out.println("Check-out: " + res.getCheckOut());
                        System.out.println("Total cost: " + res.getTotalCost());
                    } else {
                        System.out.println("Reservation not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exit...");
                    return;

                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }
}
