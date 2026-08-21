package course2.Project;

import java.util.Scanner;

// 7. MAIN APPLICATION COORDINATOR CLASS
public  class WasteConnect {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        WasteManager wasteManager = new WasteManager();
        int choice;

        do {
            System.out.println("\n===== WASTECONNECT =====");
            System.out.println("1. Citizen");
            System.out.println("2. Collector");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            // POLYMORPHIC REFERENCE Ptr Variable Usage
            UserRole user = null;

            switch (choice) {
                case 1:
                    user = new CitizenRole(); // Dynamic Binding
                    user.displayMenu(sc, wasteManager);
                    break;
                case 2:
                    user = new CollectorRole(); // Dynamic Binding
                    user.displayMenu(sc, wasteManager);
                    break;
                case 3:
                    System.out.println("Thank You!");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        } while (choice != 3);

        sc.close();
    }
}
