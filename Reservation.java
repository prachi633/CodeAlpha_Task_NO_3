import java.util.Date;

public class Reservation {

	public int cutomerID;
	public String name;
	public Room room;
	public Date checkIn;
	public Date checkOut;
	public double totalCost;
	private String paymentmethod;
	
	
	
	public Reservation(int cutomerID, Room room, String name, Date checkIn, Date checkOut, double totalCost, String paymentmethod) {
		// TODO Auto-generated constructor stub
		this.cutomerID = cutomerID;
		this.name = name;
		this.room = room;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.totalCost = totalCost;
		this.paymentmethod=paymentmethod;
	}

	public int getCutomerID() {
		return cutomerID;
	}

	public String getName() {
		return name;
	}

	public Room getRoom() {
		return room;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public double getTotalCost() {
		return totalCost;
	}
	

	public String getPayment() {
		return paymentmethod;
	}

	public double costCalculation() {
	       long diffInMiliies = Math.abs(checkOut.getTime()-checkIn.getTime());
	       long diff = diffInMiliies/(60*60*24);
	       return diff*room.getPrice();
	    		   
	}
	

}
