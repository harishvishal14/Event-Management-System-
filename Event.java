import java.util.*;
public class Event
 {
    String name, date, time;
    List<String> attendees = new ArrayList<>();
    Event(String name, String date, String time)
    {
        this.name = name;
        this.date = date;
        this.time = time;
    }

    @Override
    public String toString()
    {
        return name + " on " + date + " at " + time;
    }

    static List<Event> events = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) 
    {
        while (true) 
        {
            System.out.println("\n--- Event Management ---");
            System.out.println("1. Add Event");
            System.out.println("2. View Events");
            System.out.println("3. Register Attendee");
            System.out.println("4. View Attendees");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) 
            {
                case 1 -> addEvent();
                case 2 -> viewEvents();
                case 3 -> registerAttendee();
                case 4 -> viewAttendees();
       
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void addEvent() 
    {
        System.out.print("Event Name: ");
        String name = scanner.nextLine();
        System.out.print("Date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        System.out.print("Time (HH:MM): ");
        String time = scanner.nextLine();

        events.add(new Event(name, date, time));
        System.out.println("Event added.");
    }

    static void viewEvents() 
    {
        if (events.isEmpty()) 
        {
            System.out.println("No events found.");
            return;
        }
        for (int i = 0; i < events.size(); i++)
        {
            System.out.println((i + 1) + ". " + events.get(i));
        }
    }

    static void registerAttendee() 
    {
        if (events.isEmpty()) 
        {
            System.out.println("No events available.");
            return;
        }
        viewEvents();
        System.out.print("Select event number: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); 

        if (index < 0 || index >= events.size()) 
        {
            System.out.println("Invalid event.");
            return;
        }
        System.out.print("Attendee Name: ");
        String name = scanner.nextLine();
        events.get(index).attendees.add(name);
        System.out.println("Attendee registered.");
    }

    static void viewAttendees() 
    {
        if (events.isEmpty()) 
        {
            System.out.println("No events available.");
            return;
        }
        viewEvents();
        System.out.print("Select event number: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); 

        if (index < 0 || index >= events.size()) 
        {
            System.out.println("Invalid event.");
            return;
        }
        List<String> attendees = events.get(index).attendees;
        if (attendees.isEmpty()) 
        {
            System.out.println("No attendees registered.");
        } 
        else 
        {
            System.out.println("Attendees:");
            for (String attendee : attendees) 
            {
                System.out.println("- " + attendee);
            }
        }
    }
}

