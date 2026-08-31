package model;

public class Performance {
    private final String name;
    private final String date;
    private final int hallId;

    public Performance(String name, String date, int hallId) {
        this.name = name; this.date = date; this.hallId = hallId;
    }
    public String getName() {
        return name;
    }
    public String getDate() {
        return date;
    }
    public int getHallId() {
        return hallId;
    }
    public String key() {
        return name + "|" + date + "|" + hallId;
    }
    public String toString() {
        return name + " - " + date + " - hall " + hallId;
    }
}
