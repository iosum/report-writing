import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.print.PrinterException;
import java.sql.*;
import java.text.MessageFormat;

public class DefaultTable extends JFrame{

    static Object[][] databaseInfo;
    static Object[] columns = {"First Name", "Last Name", "DOB", "Phone Number", "MemberShip",
            "Police Check", "Police Check Date", "Interview", "Filled Application"};
    static ResultSet rows;
    static ResultSetMetaData metaData;
    static DefaultTableModel defaultTableModel = new DefaultTableModel(databaseInfo, columns) {
        public Class getColumnClass(int column) {
            Class returnValue;

            // Verifying that the column exists (index > 0 && index < number of columns
            if (column >= 0 && column < getColumnCount()) {
                returnValue = getValueAt(0, column).getClass();
            }
            else {
                // Returns the class for the item in the column
                returnValue = Object.class;
            }
            return returnValue;
        }
    };






    public static void main(String[] args) throws SQLException {
        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            Connection connection = null;
            DBConnection dbConnection = new DBConnection();
            connection = dbConnection.getConnection();

            // Statement objects executes a SQL query
            Statement statement = connection.createStatement();

            String sql = "SELECT * FROM volunteers";

            rows = statement.executeQuery(sql);

            // Temporarily holds the row results
            Object[] tempRow;
            while (rows.next()) {
                // Gets the column values based on class type expected
                tempRow = new Object[]{
                        rows.getString(2),
                        rows.getString(3),
                        rows.getDate(4),
                        rows.getString(5),
                        rows.getBoolean(6),
                        rows.getBoolean(7),
                        rows.getDate(8),
                        rows.getBoolean(9),
                        rows.getBoolean(10)
                };
                defaultTableModel.addRow(tempRow);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }



        JTable table = new JTable(defaultTableModel);
        table.setRowHeight(table.getRowHeight() + 10);



        // Allows the user to sort the data
        table.setAutoCreateRowSorter(true);




        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);


        JButton printButton = new JButton("print");
        printButton.addActionListener(e -> {
            MessageFormat header = new MessageFormat("Page Header");
            MessageFormat footer = new MessageFormat("Page {0}");
            try {
                table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
            } catch (PrinterException ex) {
                System.err.println(ex.getMessage());
            }
        });

        JPanel inputPanel = new JPanel();
        inputPanel.add(printButton);
        frame.add(inputPanel, BorderLayout.SOUTH);

        frame.setSize(800, 600);
        frame.setVisible(true);



    }

}
