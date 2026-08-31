import cli.CommandLine;
import services.CinemaService;

public class Application {
    public static void main(String[] args) {
        CinemaService service = new CinemaService(24621650);
        new CommandLine(service).run();
    }
}
