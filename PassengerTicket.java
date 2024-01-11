public class PassengerTicket {
    static int id = 1;
    String firstname;
    String lastname;
    String mailid;
    String from;
    String to;
    String section;
    String allotted;
    int number;
    int ticketprice;
    int ticketnumber = id++;

    public PassengerTicket(String firstname, String lastname, String mailid, String from, String to, String section) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.mailid = mailid;
        this.from = from;
        this.to = to;
        this.section = section;
        allotted = " ";
        number = 1;
    }
}

