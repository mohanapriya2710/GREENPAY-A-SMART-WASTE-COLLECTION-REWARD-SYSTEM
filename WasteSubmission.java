package course2.Project;

//2. ENCAPSULATED MODEL CLASS
public class WasteSubmission {
    private int id;
    private String category;
    private int quantity;
    private double cashback;
    private String status;

    public WasteSubmission(int id, String category, int quantity) {
        this.id = id;
        this.category = category;
        this.quantity = quantity;
        this.cashback = quantity * 2.0; // Rs.2 per kg calculation
        this.status = "Pending";
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getCategory() { return category; }
    public int getQuantity() { return quantity; }
    public double getCashback() { return cashback; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
