package module5;

public class test {

    public static void main(String[] args) {

        Coordinate coordinate = new Coordinate(1,1);
        Coordinate[] coordinates = new Coordinate[3];
        coordinates[0] = coordinate;
        coordinates[1] = coordinate;
        coordinates[2] = coordinate;
        CoordinateRow row = new CoordinateRow(coordinates);

        StringBuilder route = new StringBuilder();

        for(int i = 0; i < row.getNumCoordinates(); i++) {
            System.out.println(i);
            route.append(row.getCoordinates()[i].toString());
            if(i != row.getNumCoordinates() - 1) {
                route.append("\n");
            }
        }

        System.out.println(route.toString());

        CoordinateRow emptyRow = new CoordinateRow();

        emptyRow.addBack(row);
        emptyRow.addFront(row);

        StringBuilder finalRoute = new StringBuilder();

        for(int i = 0; i < emptyRow.getNumCoordinates(); i++) {
            System.out.println(i);
            finalRoute.append(emptyRow.getCoordinates()[i].toString());
            if(i != emptyRow.getNumCoordinates() - 1) {
                finalRoute.append("\n");
            }
        }

    }

}
