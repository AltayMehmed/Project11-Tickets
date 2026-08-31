package model;

public class Hall {
    private final int id;
    private final int rows;
    private final int seatsPerRow;
    public Hall(int id, int rows, int seatsPerRow) {
        this.id = id; this.rows = rows; this.seatsPerRow = seatsPerRow;
    }
    public int getId() {
        return id;
    }
    public int getRows() {
        return rows;
    }
    public int getSeatsPerRow() {
        return seatsPerRow;
    }
    public boolean validSeat(int row, int seat) {
        return row >= 1 && row <= rows && seat >= 1 && seat <= seatsPerRow;
    }
}
