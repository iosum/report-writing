import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TableTest extends AbstractTableModel {
    private List<String> columnNames;
    private List<Volunteer> volunteers;

    public TableTest(List<String> columnNames, List<Volunteer> volunteers) {
        this.columnNames = columnNames;
        this.volunteers = volunteers;
    }

    // configure the table column w/ corresponding class
    public Class<?> getColumnClass(int column) {
        switch(column){
            case 0:
            case 1:
                return String.class;
            case 2:
                return Date.class;
            case 3:
                return String.class;
            case 4:
            case 5:
                return Boolean.class;
            case 6:
                return Date.class;
            case 7:
            case 8:
                return Boolean.class;
        }
        throw new AssertionError("invalid column");
    }

    public String getColumnNames(int column) {
        String name = "";
        switch (column) {
            case 0:
                name = "First Name";
                break;
            case 1:
                name = "Last Name";
                break;
            case 2:
                name = "Birthdate";
                break;
            case 3:
                name = "Phone Number";
                break;
            case 4:
                name = "Membership";
                break;
            case 5:
                name = "Police Check";
                break;
            case 6:
                name = "Police Check Date";
                break;
            case 7:
                name = "Interview";
                break;
            case 8:
                name = "Filled Application";
                break;
        }
        return name;
    }

    // returns the num of rows
    @Override
    public int getRowCount() {
        return volunteers.size();
    }

    // return the num of columns
    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Volunteer volunteer = volunteers.get(rowIndex);
        Object result = null;
        switch (columnIndex) {
            case 0:
                result = volunteer.getFirstName();
                break;
            case 1:
                result = volunteer.getLastName();
                break;
            case 2:
                result = volunteer.getDOB();
                break;
            case 3:
                result = volunteer.getPhoneNumber();
                break;
            case 4:
                result = volunteer.isMembership();
                break;
            case 5:
                result = volunteer.isPoliceCheck();
                break;
            case 6:
                result = volunteer.getPoliceCheckDate();
                break;
            case 7:
                result = volunteer.isInterview();
                break;
            case 8:
                result = volunteer.isFilledApplication();
                break;
        }
        return result;
    }
}
