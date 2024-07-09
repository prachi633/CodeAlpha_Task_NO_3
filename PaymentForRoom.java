public class PaymentForRoom {
    private double amount;
    private String paymentMethod; 
    private boolean isPaid;

    public PaymentForRoom(double amount, String paymentMethod) {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.isPaid = false;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }
}
