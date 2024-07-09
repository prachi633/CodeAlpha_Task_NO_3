import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Hotel {

    private List<Room> rooms;
    private List<Reservation> reservations;
    private int reservationCounter = 1;

    public Hotel() {
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();

        rooms.add(new Room(101, "Single", true, 500));
        rooms.add(new Room(102, "Double", true, 1000));
    }

    public List<Room> searchRoom(String category) {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.isAvailableRoom() && room.getCategory().equalsIgnoreCase(category)) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public Reservation makeReservation(int roomNumber, String name, Date checkIn, Date checkOut,String paymentmethod) {
        for (Room room : rooms) {
            if (room.getRoomNo() == roomNumber && room.isAvailableRoom()) {
                double totalCost = (checkOut.getTime() - checkIn.getTime()) / (1000 * 60 * 60 * 24) * room.getPrice();
                Reservation reservation = new Reservation(reservationCounter++, room, name, checkIn, checkOut, totalCost,paymentmethod);
                room.setAvailable(false);
                reservations.add(reservation);
                return reservation;
            }
        }
        return null;
    }

	public Reservation bookingdetails(int id) {
		// TODO Auto-generated method stub
		for (Reservation reservation : reservations) {
            if (reservation.getCutomerID() == id) {
                return reservation;
            }
        }
		return null;
	}

    

}
