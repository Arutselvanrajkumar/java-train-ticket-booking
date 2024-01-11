import java.util.*;

public class Main {
    public static void bookTicket(PassengerTicket p, TicketBooking tb) {
        if (p.section.equals("A")) {
            System.out.println("A section Given");
            tb.bookTicket(p, TicketBooking.A_section.poll(), "A");
            TicketBooking.available_Asection--;
        } else if (p.section.equals("B")) {
            System.out.println("B section Given");
            tb.bookTicket(p, TicketBooking.B_section.poll(), "B");
            TicketBooking.available_Bsection--;
        }
    }

    public static void cancelTicket(int id, TicketBooking tb) {
        if (!tb.passenger_stored_data.containsKey(id)) {
            System.out.println("Passenger ID is not found!");
        } else {
            tb.cancelTicket(id);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicketBooking tb = new TicketBooking();

        boolean loop = true;
        while (loop) {
            System.out.println("1. Ticket Booking\n2. Ticket Cancellation\n3. Booking Status\n4. Available Tickets\n5. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("Passenger firstname:");
                    String firstname = sc.next();
                    System.out.println("Passenger lastname:");
                    String lastname = sc.next();
                    System.out.println("Passenger mailid:");
                    String mailid = sc.next();
                    System.out.println("From:");
                    String from = sc.next();
                    System.out.println("To:");
                    String to = sc.next();
                    System.out.println("Section [A,B]:");
                    String section = sc.next();
                    PassengerTicket p = new PassengerTicket(firstname, lastname, mailid, from, to, section);
                    bookTicket(p, tb);
                    break;
                }
                case 2: {
                    System.out.println("Enter the Passenger ID:");
                    int id = sc.nextInt();
                    cancelTicket(id, tb);
                    break;
                }
                case 3: {
                    tb.availableTickets();
                    break;
                }
                case 4: {
                    tb.passengersDetail();
                    break;
                }
                case 5: {
                    loop = false;
                    break;
                }
            }
        }
    }
}
