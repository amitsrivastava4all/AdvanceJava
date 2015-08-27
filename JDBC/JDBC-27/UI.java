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
	
	public static void main(String[] args) {
		
					UI frame = new UI();
					frame.setVisible(true);
				
	}

	/**
	 * Create the frame.
	 */
	public UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 385);
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
		btnSearch.setBounds(344, 45, 146, 32);
		getContentPane().add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 110, 456, 224);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
	}
	
	private void doSearch(){
		String empno = empIdTxtField.getText();
		try {
			ArrayList<Employee> empList = JdbcDemo1.fetchEmployees(empno);
			EmployeeModel empModel = new EmployeeModel(empList);
			table.setModel(empModel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Some Problem on Server Side , Please Check");
		}
	}
}
