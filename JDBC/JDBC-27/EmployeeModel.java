import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;


public class EmployeeModel extends AbstractTableModel {
	private ArrayList<Employee> empList;
	String columns[] = {"empno","name","salary"};
	public EmployeeModel(ArrayList<Employee> empList){
		this.empList = empList;
	}
	
	// No of Records
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return empList.size();
	}
	
	
	// Value of Header Columns
	@Override
    public String getColumnName(int column) {
        return columns[column];
    }

	// No of Columns
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columns.length;
	}

	// Give Column Value
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Employee empObject  = empList.get(rowIndex);
		switch(columnIndex){
		case 0:
			return empObject.getId();
		case 1:
			return empObject.getName();
		case 2:
			return empObject.getSalary();
		}
		return null;
	}

}
