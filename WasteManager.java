package course2.Project;

//3. SERVICE CLASS (Implements Interface)
public class WasteManager implements WasteAnalytics {
    private WasteSubmission[] storage = new WasteSubmission[100];
    private int count = 0;

    public int getCount() { return count; }

    public void addWaste(String cat, int qty) {
        if (count >= 100) {
            System.out.println("Storage limit reached!");
            return;
        }
        storage[count] = new WasteSubmission(count, cat, qty);
        count++;
        System.out.println("Waste Added Successfully!");
    }

    public void viewSubmissions() {
        if (count == 0) {
            System.out.println("No submissions found.");
            return;
        }
        System.out.println("\nWaste Submissions");
        for (int i = 0; i < count; i++) {
            System.out.println("ID: " + storage[i].getId());
            System.out.println("Category: " + storage[i].getCategory());
            System.out.println("Quantity: " + storage[i].getQuantity() + " kg");
            System.out.println("Cashback: Rs." + storage[i].getCashback());
            System.out.println("Status: " + storage[i].getStatus());
            System.out.println("-------------------");
        }
    }

    public void updateStatus(int id) {
        if (id < 0 || id >= count) {
            System.out.println("Invalid ID!");
            return;
        }
        if (storage[id].getStatus().equals("Collected")) {
            System.out.println("Already Updated!");
            return;
        }
        storage[id].setStatus("Collected");
        System.out.println("Status Updated Successfully!");
    }

    @Override
    public void categorySummary() {
        int plastic = 0, paper = 0, metal = 0;
        for (int i = 0; i < count; i++) {
            if (storage[i].getCategory().equalsIgnoreCase("Plastic")) plastic += storage[i].getQuantity();
            else if (storage[i].getCategory().equalsIgnoreCase("Paper")) paper += storage[i].getQuantity();
            else if (storage[i].getCategory().equalsIgnoreCase("Metal")) metal += storage[i].getQuantity();
        }
        System.out.println("\nCategory Summary");
        System.out.println("Plastic : " + plastic + " kg");
        System.out.println("Paper   : " + paper + " kg");
        System.out.println("Metal   : " + metal + " kg");
    }

    @Override
    public void mostCommonWaste() {
        if (count == 0) {
            System.out.println("No waste recorded yet.");
            return;
        }
        int plastic = 0, paper = 0, metal = 0;
        for (int i = 0; i < count; i++) {
            if (storage[i].getCategory().equalsIgnoreCase("Plastic")) plastic += storage[i].getQuantity();
            else if (storage[i].getCategory().equalsIgnoreCase("Paper")) paper += storage[i].getQuantity();
            else if (storage[i].getCategory().equalsIgnoreCase("Metal")) metal += storage[i].getQuantity();
        }
        if (plastic >= paper && plastic >= metal)
            System.out.println("Most Common Waste: Plastic (" + plastic + " kg)");
        else if (paper >= plastic && paper >= metal)
            System.out.println("Most Common Waste: Paper (" + paper + " kg)");
        else
            System.out.println("Most Common Waste: Metal (" + metal + " kg)");
    }
}
