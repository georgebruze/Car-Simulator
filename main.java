import java.util.Scanner;

public class DrivingSimulationLab {
    public static String gear = "P";
    public static int speed = 0;
    public static boolean isEngineOn = false;
    public static Scanner keyBoard = new Scanner(System.in);
    public static void startSimulation() {
    
        boolean displayMenu = true;
        while (displayMenu) {
            
            displayDashboard();
            int choice = getUserChoice();
            processChoice(choice);
            System.out.println();
        }
    }

    public static void displayDashboard() {
        System.out.println("------ Car Dashboard ------");
        System.out.println("Speed: " + speed);
        System.out.println("Engine: " + (isEngineOn ? "On" : "Off"));
        System.out.println("Gear: " + gear);
        System.out.println("Menu:");
        System.out.println("1. Turn on/off the engine");
        System.out.println("2. Change gear (P, D, R)");
        System.out.println("3. Accelerate");
        System.out.println("4. Brake");
        System.out.println("5. Exit");
    }

    public static int getUserChoice() {
        System.out.print("Enter your choice: ");
        return keyBoard.nextInt();
    }

    public static void processChoice(int choice) {
        switch (choice) {
            case 1:
                toggleEngine();
                break;
            case 2:
                changeGear();
                break;
            case 3:
                accelerate();
                break;
            case 4:
                brake();
                break;
            case 5:
                exitSimulation();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public static void toggleEngine() {
        if (!isEngineOn) {
            isEngineOn = true;
        } else {
            isEngineOn = false;
        }

        System.out.println("Engine status: " + isEngineOn);
    }

    public static void changeGear() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter gear (D for Drive, R for Reverse): ");
        String input = scanner.nextLine().toUpperCase();
        
        if (input.equals("D") || input.equals("R")) {
            gear = input;
            System.out.println("Gear changed to: " + gear);
        } else {
            System.out.println("Invalid input. Gear remains: " + gear);
        }
    }

    public static void accelerate() {
        if (isEngineOn && !gear.equals("P")) {
            speed = speed + 10;
            System.out.println("Accelerating... Speed is now: " + speed + " km/h");
        } else {
            System.out.println("Car could not be accelerated since engine is either off or not in the correct gear.");
        }
    }

    public static void brake() {
 
        if (isEngineOn && speed > 5) {
            speed = speed - 5;
            System.out.println("Brakes applied. Speed reduced to: " + speed + " km/h");

        } else {
            System.out.println("Braking system could not be initiated. Either engine is off or speed is too low.");
        }
    }

    public static void exitSimulation() {

        System.out.println("Car simulation is about to be terminated");
        System.exit(0);

    }

    public static void main(String[] args) {
        startSimulation();
    }
}
