package view.admin;

import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import DAO.DAOCity;
import DAO.DAOCustomer;
import Models.Customer;

import javax.swing.JTextField;

public class PanelUserAd extends JPanel {

	public JButton btnAdd, btnUpdate, btnDelete, btnCancel;
	private JTextField textUserID;
	private JTextField textPassword;
	private JTextField textUserName;
	public DefaultTableModel dtm;
	public JTable table;
	
	private ArrayList<Customer> data = DAOCustomer.getInstance().selectAll();
	
	/**
	 * Create the panel.
	 */
	public PanelUserAd() throws ClassNotFoundException, SQLException {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(0, 0, 614, 553);
		setLayout(null);
		
		JLabel lblUser = new JLabel("Thông tin tài khoản");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblUser.setBounds(27, 11, 259, 34);
		add(lblUser);
		
		JLabel lblUserID = new JLabel("Mã tài khoản");
		lblUserID.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblUserID.setBounds(20, 56, 84, 34);
		add(lblUserID);
		
		JLabel lblPassword = new JLabel("Mật khẩu");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblPassword.setBounds(300, 56, 84, 34);
		add(lblPassword);
		
		JLabel lblUserName = new JLabel("Tài khoản");
		lblUserName.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblUserName.setBounds(20, 105, 84, 34);
		add(lblUserName);
		
		btnAdd = new JButton("Thêm");
		btnAdd.setBackground(new Color(255, 128, 0));
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdd.setBounds(322, 191, 78, 28);
		add(btnAdd);
		
		 btnUpdate = new JButton("Sửa");
		btnUpdate.setBackground(new Color(255, 0, 0));
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdate.setBounds(425, 191, 78, 28);
		add(btnUpdate);
		
		 btnDelete = new JButton("Xóa");
		btnDelete.setBackground(new Color(0, 128, 255));
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDelete.setBounds(526, 191, 78, 28);
		add(btnDelete);
		
		 btnCancel = new JButton("Hủy");
		btnCancel.setEnabled(false);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBackground(new Color(192, 192, 192));
		btnCancel.setBounds(214, 191, 78, 28);
		add(btnCancel);
		
		textUserID = new JTextField();
		textUserID.setEditable(false);
		textUserID.setColumns(10);
		textUserID.setBounds(128, 59, 109, 28);
		add(textUserID);
		
		textPassword = new JTextField();
		textPassword.setEditable(false);
		textPassword.setColumns(10);
		textPassword.setBounds(394, 59, 109, 28);
		add(textPassword);
		
		textUserName = new JTextField();
		textUserName.setEditable(false);
		textUserName.setColumns(10);
		textUserName.setBounds(128, 108, 109, 28);
		add(textUserName);
		
		table = new JTable();
		
		String[] columnNames = {"ID","Tài khoản","Mật khẩu"};
		
		dtm = new DefaultTableModel(columnNames, 0);
		
		for (int i = 0; i < data.size(); i++)
		{
			
			int ID = data.get(i).getCustomerID();
			String username = data.get(i).getAccount();
			String password =  data.get(i).getPassword();
			Object[] rowData = {ID,username,password};
			dtm.addRow(rowData);
		}
		
		table.setModel(dtm);
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(27, 262, 553, 266);
		add(scrollPane);
		
	}
}
