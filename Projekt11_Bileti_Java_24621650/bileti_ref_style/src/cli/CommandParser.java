package cli;

public class CommandParser {
    public Command parse(String line) {
        line = line.trim();
        if (line.isEmpty()) return new Command("", new String[0]);
        String[] parts = line.split("\\s+");
        String[] args = new String[parts.length - 1];
        System.arraycopy(parts, 1, args, 0, args.length);
        return new Command(parts[0].toLowerCase(), args);
    }
}
