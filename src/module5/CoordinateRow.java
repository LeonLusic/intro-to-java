package module5;

public class CoordinateRow {

    private Coordinate[] coordinates = new Coordinate[0];
    private int numCoordinates = this.coordinates.length;

    public CoordinateRow() {

    }

    public CoordinateRow(Coordinate[] coordinates) {
        this.coordinates = coordinates;
        this.numCoordinates = coordinates.length;
    }

    public Coordinate[] getCoordinates() {
        return this.coordinates;
    }
    public int getNumCoordinates() {
        return this.numCoordinates;
    }

    public void setCoordinates(Coordinate[] coordinates) {
        this.coordinates = coordinates;
    }
    public void setNumCoordinates(int numCoordinates) {
        this.numCoordinates = numCoordinates;
    }

    public void addFront(CoordinateRow row) {

        int numCoordinatesPrime = this.numCoordinates + row.getNumCoordinates();

        Coordinate[] rowConcat = new Coordinate[numCoordinatesPrime];

        Coordinate[] rowNewCoordinates = row.getCoordinates();

        for(int i = 0; i < row.getNumCoordinates(); i++) {
            rowConcat[i] = rowNewCoordinates[i];
        }
        for(int i = 0; i < this.numCoordinates; i++) {
            rowConcat[row.getNumCoordinates() + i] = this.coordinates[i];
        }

        this.coordinates = rowConcat;
        this.numCoordinates = numCoordinatesPrime;

    }

    public void addBack(CoordinateRow row) {

        int numCoordinatesPrime = this.numCoordinates + row.getNumCoordinates();

        Coordinate[] rowConcat = new Coordinate[numCoordinatesPrime];

        Coordinate[] rowNewCoordinates = row.getCoordinates();

        for(int i = 0; i < this.numCoordinates; i++) {
            rowConcat[i] = this.coordinates[i];
        }
        for(int i = 0; i < row.getNumCoordinates(); i++) {
            rowConcat[this.numCoordinates + i] = rowNewCoordinates[i];
        }

        this.coordinates = rowConcat;
        this.numCoordinates = numCoordinatesPrime;

    }

    public void appendCoordinate(Coordinate coordinate) {

        Coordinate[] extendedCoordinates = new Coordinate[this.numCoordinates + 1];

        for(int i = 0; i < this.numCoordinates; i++) {
            extendedCoordinates[i] = this.coordinates[i];
        }

        extendedCoordinates[this.numCoordinates] = coordinate;

        this.coordinates = extendedCoordinates;
        this.numCoordinates = extendedCoordinates.length;

    }

    public void reshiftRow() {

        for(int i = 0; i < numCoordinates; i++) {
            this.coordinates[i].reshift();
        }

    }

    public String toString() {

        StringBuilder route = new StringBuilder();

        for(int i = 0; i < numCoordinates; i++) {

            route.append(coordinates[i].toString());

            if(i != numCoordinates - 1) {
                route.append("\n");
            }

        }

        return route.toString();
    }

}
