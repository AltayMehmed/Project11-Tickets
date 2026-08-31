package session;

public class Session {
    private String activeFile;
    public boolean isOpen() { return activeFile != null; }
    public String getActiveFile() { return activeFile; }
    public void open(String file) { activeFile = file; }
    public void close() { activeFile = null; }
}
