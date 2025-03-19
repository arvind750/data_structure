import java.util.Scanner;

class Ticket {
    int ticketID;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    public Ticket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservationSystem {
    private Ticket last;
    private int totalTickets;

    public TicketReservationSystem() {
        this.last = null;
        this.totalTickets = 0;
    }

    public void addTicket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketID, customerName, movieName, seatNumber, bookingTime);
        if (last == null) {
            last = newTicket;
            last.next = last;
        } else {
            newTicket.next = last.next;
            last.next = newTicket;
            last = newTicket;
        }
        totalTickets++;
        System.out.println("Ticket booked successfully for " + customerName);
    }

    public void removeTicket(int ticketID) {
        if (last == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket current = last.next, prev = last;
        do {
            if (current.ticketID == ticketID) {
                if (current == last && current.next == last) {
                    last = null;
                } else if (current == last) {
                    prev.next = last.next;
                    last = prev;
                } else {
                    prev.next = current.next;
                }
                totalTickets--;
                System.out.println("Ticket with ID " + ticketID + " cancelled.");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != last.next);

        System.out.println("Ticket with ID " + ticketID + " not found.");
    }

    public void displayTickets() {
        if (last == null) {
            System.out.println("No tickets booked.");
            return;
        }
        System.out.println("\nBooked Tickets:");
        Ticket temp = last.next;
        do {
            System.out.println("Ticket ID: " + temp.ticketID + " | Customer: " + temp.customerName + " | Movie: " + temp.movieName +
                    " | Seat: " + temp.seatNumber + " | Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != last.next);
    }

    public void searchByCustomer(String customerName) {
        if (last == null) {
            System.out.println("No tickets booked.");
            return;
        }
        Ticket temp = last.next;
        boolean found = false;
        do {
            if (temp.customerName.equalsIgnoreCase(customerName)) {
                System.out.println("Ticket ID: " + temp.ticketID + " | Movie: " + temp.movieName + " | Seat: " + temp.seatNumber +
                        " | Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != last.next);
        if (!found) {
            System.out.println("No ticket found for customer " + customerName);
        }
    }

    public void searchByMovie(String movieName) {
        if (last == null) {
            System.out.println("No tickets booked.");
            return;
        }
        Ticket temp = last.next;
        boolean found = false;
        do {
            if (temp.movieName.equalsIgnoreCase(movieName)) {
                System.out.println("Ticket ID: " + temp.ticketID + " | Customer: " + temp.customerName + " | Seat: " + temp.seatNumber +
                        " | Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != last.next);
        if (!found) {
            System.out.println("No tickets found for movie " + movieName);
        }
    }

    public void totalBookedTickets() {
        System.out.println("Total booked tickets: " + totalTickets);
    }
}

public class TicketManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicketReservationSystem ticketSystem = new TicketReservationSystem();

        while (true) {
            System.out.println("\n1. Book Ticket\n2. Cancel Ticket\n3. View Tickets\n4. Search by Customer\n5. Search by Movie\n6. Total Tickets\n7. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Ticket ID: ");
                    int ticketID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Customer Name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter Movie Name: ");
                    String movieName = scanner.nextLine();
                    System.out.print("Enter Seat Number: ");
                    String seatNumber = scanner.nextLine();
                    System.out.print("Enter Booking Time: ");
                    String bookingTime = scanner.nextLine();
                    ticketSystem.addTicket(ticketID, customerName, movieName, seatNumber, bookingTime);
                    break;
                case 2:
                    System.out.print("Enter Ticket ID to cancel: ");
                    int removeID = scanner.nextInt();
                    ticketSystem.removeTicket(removeID);
                    break;
                case 3:
                    ticketSystem.displayTickets();
                    break;
                case 4:
                    System.out.print("Enter Customer Name to search: ");
                    String searchCustomer = scanner.nextLine();
                    ticketSystem.searchByCustomer(searchCustomer);
                    break;
                case 5:
                    System.out.print("Enter Movie Name to search: ");
                    String searchMovie = scanner.nextLine();
                    ticketSystem.searchByMovie(searchMovie);
                    break;
                case 6:
                    ticketSystem.totalBookedTickets();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
