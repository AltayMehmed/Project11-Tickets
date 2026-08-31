package cli;

import services.CinemaService;

import java.util.Scanner;

public class CommandLine {
    private final CinemaService service;
    private final CommandParser parser = new CommandParser();

    public CommandLine(CinemaService service) {
        this.service = service;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ticket System - FN 24621650");
        System.out.println("Type help for commands.");
        while (true) {
            System.out.print("> ");
            String line = scanner.nextLine();
            Command command = parser.parse(line);
            try {
                if (command.getName().equals("exit")) break;
                execute(command);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void execute(Command c) throws Exception {
        String[] a = c.getArgs();
        switch (c.getName()) {
            case "help" -> service.help();
            case "open" -> service.open(a[0]);
            case "close" -> service.close();
            case "save" -> service.save();
            case "saveas" -> service.saveAs(a[0]);
            case "addevent" -> service.addEvent(a);
            case "freeseats" -> service.freeSeats(a);
            case "book" -> service.book(a);
            case "unbook" -> service.unbook(a);
            case "buy" -> service.buy(a);
            case "bookings" -> service.bookings();
            case "check" -> service.check(a[0]);
            case "report" -> service.report(a);
            default -> System.out.println("Unknown command. Type help.");
        }
    }
}
