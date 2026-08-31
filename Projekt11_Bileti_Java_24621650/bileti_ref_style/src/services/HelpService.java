package services;

public class HelpService {
    public void print() {
        System.out.println("open <file> | close | save | saveas <file> | help | exit");
        System.out.println("addevent <name> <date> <hall>");
        System.out.println("freeseats <name> <date> | book <name> <date> <row> <seat> [note]");
        System.out.println("unbook <name> <date> <row> <seat> | buy <name> <date> <row> <seat>");
        System.out.println("bookings | check <code> | report <date>");
    }
}
