public class Room {
    private int roomNo;
    private String category;
    private boolean isAvailable;
    private double price;

    public Room(int roomNo, String category, boolean isAvailable, double price) {
        this.roomNo = roomNo;
        this.category = category;
        this.isAvailable = isAvailable;
        this.price = price;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public String getCategory() {
        return category;
    }

    public boolean isAvailableRoom() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public double getPrice() {
        return price;
    }
}
