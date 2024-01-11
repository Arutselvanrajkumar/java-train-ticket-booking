import java.util.*;

public class TicketBooking {
    static int available_Asection = 10; // available section A
    static int available_Bsection = 10; // available section B
    static int available_waiting = 6; // available waiting
    static Queue<Integer> A_section = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    static Queue<Integer> B_section = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    static Queue<Integer> waitinglist = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
    static Map<Integer, PassengerTicket> passenger_stored_data = new HashMap<>();
    static List<Integer> bookedTicketList = new ArrayList<>();

    public void bookTicket(PassengerTicket p, int snumber, String allotted_section) {
        p.number = snumber;
        p.allotted = allotted_section;
        passenger_stored_data.put(p.ticketnumber, p);
        bookedTicketList.add(p.ticketnumber);
        System.out.println("Passenger firstname: " + p.firstname + " " + p.lastname);
        System.out.println("Passenger from " + p.from);
        System.out.println("Passenger to " + p.to);
        System.out.println("Passenger section " + p.section);
        System.out.println("Allotted number " + snumber + allotted_section);
        System.out.println("-----------------------------------Booked successfully");
    }

    public void cancelTicket(int passengerId) {
        PassengerTicket p = passenger_stored_data.get(passengerId);
        passenger_stored_data.remove(passengerId);
        bookedTicketList.remove(Integer.valueOf(passengerId));
        int psnumber = p.number;
        System.out.println("-------------------Cancelled Successfully");
        if (p.allotted.equals("A")) {
            A_section.add(psnumber);
            available_Asection++;
        } else if (p.allotted.equals("B")) {
            B_section.add(psnumber);
            available_Bsection++;
        }
    }

    public void availableTickets() {
        System.out.println("The A available Ticket is: " + available_Asection);
        System.out.println("The B available Ticket is: " + available_Bsection);
    }

    public void passengersDetail() {
        if (passenger_stored_data.size() == 0) {
            System.out.println("No Passengers Detail Found");
            return;
        } else {
            for (PassengerTicket p : passenger_stored_data.values()) {
                System.out.println("Passenger Id: " + p.ticketnumber);
                System.out.println("Passenger firstName: " + p.firstname);
                System.out.println("Passenger lastnmame: " + p.lastname);
                System.out.println("Passenger mailid: " + p.mailid);
                System.out.println("Passenger from: " + p.from);
                System.out.println("Passenger to: " + p.to);
                System.out.println("Allotted Berth: " + p.number + p.allotted);

                System.out.println("=========================================");
            }
        }
    }
}
