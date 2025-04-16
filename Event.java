import java.util.*;

public class Event {

    static class EventManagementSystem {
        String name, date, time;
        List<String> attendees = new ArrayList<>();

        Event(String name, String date, String time) {
            this.name = name;
            this.date = date;
            this.time = time;
        }

        @Override
        public String toString() {
            return name + " on " + date + " at " + time;
        }
    }

    static List<Event> events = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Event Management ---");
            System.out.println("1. Add Event");
            System.out.println("2. View Events");
            System.out.println("3. Register Attendee");
            System.out.println("4. View Attendees");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addEvent();
                case 2 -> viewEvents();
                case 3 -> registerAttendee();
                case 4 -> viewAttendees();
                case 0 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
