package WeeklyTemperature;
// import arraylist and scanner
import java.util.ArrayList;
import java.util.Scanner;

public class WeeklyTemperature {
    private static final ArrayList<String> daysOfWeek = new ArrayList<>();
    private static final ArrayList<Double> temperatures = new ArrayList<>();
    
    static {
        // Initialize the days of the week
        daysOfWeek.add("Monday");
        daysOfWeek.add("Tuesday");
        daysOfWeek.add("Wednesday");
        daysOfWeek.add("Thursday");
        daysOfWeek.add("Friday");
        daysOfWeek.add("Saturday");
        daysOfWeek.add("Sunday");
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input temperatures
        inputTemperatures(scanner);

        // Display temperatures or weekly average
        handleUserQuery(scanner);

        scanner.close();
    }

    private static void inputTemperatures(Scanner scanner) {
        for (String day : daysOfWeek) {
            while (true) {
                System.out.println("Enter the temperature for " + day + ":");
                if (scanner.hasNextDouble()) {
                    temperatures.add(scanner.nextDouble());
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next(); // Clear the invalid input
                }
            }
        }
    }

    private static void handleUserQuery(Scanner scanner) {
        while (true) {
            System.out.println("\nEnter a day of the week to see the temperature, or type 'week' to see all temperatures and the weekly average:");
            String input = scanner.next().trim();

            if (input.equalsIgnoreCase("week")) {
                displayWeeklySummary();
                break; // Exit after displaying the weekly summary
            } else {
                displayTemperatureForDay(input);
            }
        }
    }

    private static void displayWeeklySummary() {
        double sum = 0;
        System.out.println("\nTemperatures for the week:");
        for (int i = 0; i < daysOfWeek.size(); i++) {
            System.out.println(daysOfWeek.get(i) + ": " + temperatures.get(i) + "°F");
            sum += temperatures.get(i);
        }
        double average = sum / temperatures.size();
        System.out.println("\nThe average temperature for the week is: " + average + "°F");
    }

    private static void displayTemperatureForDay(String day) {
        int index = daysOfWeek.indexOf(day);
        if (index != -1) {
            System.out.println(day + "'s temperature was: " + temperatures.get(index) + "°F");
        } else {
            System.out.println("Invalid input. Please enter a valid day or 'week'.");
        }
    }
}
