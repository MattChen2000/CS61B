import java.util.ArrayList;
import java.util.List;

public class Table {
    private class Row {
        int[] data;

        public Row(int[] data) {
            this.data = data;
        }
    }

    private class Column {
        final String name;
        List<Integer> data;

        Column(String name) {
            this.name = name;
            data = new ArrayList<>();
        }

        void addData(int item) {
            this.data.add(item);
        }

        public List<Integer> getData() {
            return this.data;
        }
    }

    private int numOfColumns;
    private int numOfRows;
    private String[] columnNames;
    private Column[] columns;
    private List<Row> rows;

    public Table(String[] columnNames) {
        this.columnNames = columnNames;
        this.numOfColumns = columnNames.length;
        this.numOfRows = 0;
        this.columns = new Column[numOfColumns];
        this.rows = new ArrayList<>();
        for (int i = 0; i < numOfColumns; i++) {
            Column c = new Column(this.columnNames[i]);
            columns[i] = c;
        }
    }

    public void addRow(int[] rowData) {
        if (rowData.length != numOfColumns) {
            System.out.println("Invalid row data: incorrect number of columns");
            return;
        }
        Row currRow = new Row(rowData);
        rows.add(currRow);
        for (int i = 0; i < numOfColumns; i++) {
            columns[i].addData(rowData[i]);
        }
        numOfRows++;
    }

    public void printTable() {
        for (int i = 0; i < numOfColumns; i++) {
            if (i != 0)
                System.out.print(", ");
            System.out.print(columnNames[i]);
        }
        System.out.print('\n');

        for (Row currRow : rows) {
            for (int j = 0; j < numOfColumns; j++) {
                if (j != 0)
                    System.out.print(", ");
                System.out.print(currRow.data[j]);
            }
            System.out.print('\n');
        }
    }

    public static void main(String[] args) {
        Table t = new Table(new String[]{"x", "y"});
        t.addRow(new int[]{2, 5});
        t.addRow(new int[]{8, 3});
        t.addRow(new int[]{13, 7});
        t.printTable();
    }
}
