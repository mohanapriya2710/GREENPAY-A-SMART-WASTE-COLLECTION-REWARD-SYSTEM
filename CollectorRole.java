package course2.Project;

import java.util.Scanner;

//6. INHERITANCE CONCEPT (Collector Role Class)
public class CollectorRole extends UserRole {
    @Override
    public void displayMenu(Scanner sc, WasteManager manager) {
        int choice;
        do {
            System.out.println("\n--- Collector Menu ---");
            System.out.println("1. View All Submissions");
            System.out.println("2. Update Collection Status");
            System.out.println("3. View Category Summary");
            System.out.println("4. Most Common Waste");
            System.out.println("5. Back");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    manager.viewSubmissions();
                    break;
                case 2:
                    if (manager.getCount() == 0) {
                        System.out.println("No submissions available.");
                        break;
                    }
                    System.out.print("Enter Submission ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    manager.updateStatus(id);
                    break;
                case 3:
                    manager.categorySummary();
                    break;
                case 4:
                    manager.mostCommonWaste();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        } while (choice != 5);
    }
}
