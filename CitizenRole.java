package course2.Project;

import java.util.Scanner;

// 5. INHERITANCE CONCEPT (Citizen Role Class)
public class CitizenRole extends UserRole {
    @Override
    public void displayMenu(Scanner sc, WasteManager manager) {
        int choice;
        do {
            System.out.println("\n--- Citizen Menu ---");
            System.out.println("1. Add Waste");
            System.out.println("2. View Submissions");
            System.out.println("3. Back");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    if (manager.getCount() >= 100) {
                        System.out.println("Storage limit reached!");
                        break;
                    }
                    System.out.print("Enter Waste Category (Plastic/Paper/Metal): ");
                    String cat = sc.nextLine().trim();
                    if (!(cat.equalsIgnoreCase("Plastic") || cat.equalsIgnoreCase("Paper") || cat.equalsIgnoreCase("Metal"))) {
                        System.out.println("Invalid Category!");
                        break;
                    }
                    System.out.print("Enter Quantity (kg): ");
                    int qty = sc.nextInt();
                    sc.nextLine();
                    if (qty <= 0) {
                        System.out.println("Quantity must be greater than 0!");
                        break;
                    }
                    manager.addWaste(cat, qty);
                    break;
                case 2:
                    manager.viewSubmissions();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        } while (choice != 3);
    }
}
