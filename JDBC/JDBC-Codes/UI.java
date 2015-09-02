import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class UI extends JFrame {
	private JTextField empIdTxtField;
	Icon searchIcon = new ImageIcon(UI.class.getResource("search.png"));
	private JTable table;
	private JTextField txtName;
	private JTextField txtSalary;
	private JTextField anyTxt;
	
	public static void main(String[] args) {
		
					UI frame = new UI();
					frame.setVisible(true);
				
	}

	/**
	 * Create the frame.
	 */
	public UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 471);
		getContentPane().setLayout(null);
		
		JLabel lblEmpno = new JLabel("Empno");
		lblEmpno.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEmpno.setBounds(34, 44, 114, 32);
		getContentPane().add(lblEmpno);
		
		empIdTxtField = new JTextField();
		empIdTxtField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		empIdTxtField.setBounds(143, 44, 191, 30);
		getContentPane().add(empIdTxtField);
		empIdTxtField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doSearch();
			}
		});
		btnSearch.setToolTipText("Click to Search");
		btnSearch.setMnemonic('S');
		btnSearch.setIcon(searchIcon);
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSearch.setBounds(344, 79, 146, 32);
		getContentPane().add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 200, 456, 224);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblName.setBounds(34, 97, 89, 14);
		getContentPane().add(lblName);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtName.setBounds(141, 87, 193, 29);
		getContentPane().add(txtName);
		txtName.setColumns(10);
		
		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSalary.setBounds(36, 136, 74, 14);
		getContentPane().add(lblSalary);
		
		txtSalary = new JTextField();
		txtSalary.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtSalary.setBounds(143, 127, 191, 20);
		getContentPane().add(txtSalary);
		txtSalary.setColumns(10);
		
		anyTxt = new JTextField();
		anyTxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		anyTxt.setBounds(143, 11, 191, 20);
		getContentPane().add(anyTxt);
		anyTxt.setColumns(10);
		
		JLabel lblAny = new JLabel("Any");
		lblAny.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAny.setBounds(32, 14, 59, 19);
		getContentPane().add(lblAny);
		
		JButton btnNewButton = new JButton("Any");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anySearch();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(356, 11, 114, 32);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("1");
		btnNewButton_1.setBounds(59, 169, 49, 20);
		getContentPane().add(btnNewButton_1);
		
		JButton button = new JButton("2");
		button.setBounds(125, 169, 49, 20);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("3");
		button_1.setBounds(195, 169, 49, 20);
		getContentPane().add(button_1);
		
	}
	
	private void doSearch(){
		String empno = empIdTxtField.getText();
		String name = txtName.getText();
		double salary = Double.parseDouble(txtSalary.getText().trim().length()==0?"0":txtSalary.getText());
		EmpDTO empDTO  = new EmpDTO();
		empDTO.setId(Integer.parseInt(empno.trim().length()==0?"0":empno));
		empDTO.setName(name);
		empDTO.setSalary(salary);
		try {
			ArrayList<Employee> empList = JdbcDemo1.fetchEmployees(empDTO);
			EmployeeModel empModel = new EmployeeModel(empList);
			table.setModel(empModel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Some Problem on Server Side , Please Check");
		}
	}
	
	private void anySearch(){
		String anyData = anyTxt.getText();
		try {
			ArrayList<Employee> empList = JdbcDemo1.anyEmployees(anyData);
			EmployeeModel empModel = new EmployeeModel(empList);
			table.setModel(empModel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Some Problem on Server Side , Please Check");
		}
	}
}
