package view.admin;

import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
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
import controller.admin.RouteListener;
import controller.admin.UserListener;

import javax.swing.JTextField;

public class PanelUserAd extends JPanel {

	private JButton btnAdd, btnUpdate, btnDelete, btnCancel;
	private JTextField textUserID;
	private JTextField textPassword;
	private JTextField textUserName;
	public DefaultTableModel dtm;
	private JTable table;
	
	private ArrayList<Customer> data = DAOCustomer.getInstance().selectAll();
	public JButton getBtnAdd() {
		return btnAdd;
	}

	public void setBtnAdd(JButton btnAdd) {
		this.btnAdd = btnAdd;
	}

	public JButton getBtnUpdate() {
		return btnUpdate;
	}

	public void setBtnUpdate(JButton btnUpdate) {
		this.btnUpdate = btnUpdate;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public void setBtnCancel(JButton btnCancel) {
		this.btnCancel = btnCancel;
	}

	public JTextField getTextUserID() {
		return textUserID;
	}

	public void setTextUserID(JTextField textUserID) {
		this.textUserID = textUserID;
	}

	public JTextField getTextPassword() {
		return textPassword;
	}

	public void setTextPassword(JTextField textPassword) {
		this.textPassword = textPassword;
	}

	public JTextField getTextUserName() {
		return textUserName;
	}

	public void setTextUserName(JTextField textUserName) {
		this.textUserName = textUserName;
	}

	public DefaultTableModel getDtm() {
		return dtm;
	}

	public void setDtm(DefaultTableModel dtm) {
		this.dtm = dtm;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public ArrayList<Customer> getData() {
		return data;
	}

	public void setData(ArrayList<Customer> data) {
		this.data = data;
	}


	
	/**
	 * Create the panel.
	 */
	public PanelUserAd() throws ClassNotFoundException, SQLException {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(188, 0, 614, 553);
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
		
		SetTextUnEditable();
		table.getSelectionModel().addListSelectionListener( new UserListener(this));
		
		btnAdd.addActionListener(new UserListener(this));
		btnCancel.addActionListener(new UserListener(this));
		btnDelete.addActionListener(new UserListener(this));
		btnUpdate.addActionListener(new UserListener(this));
	}
	public void SetTextEditable() {
		textPassword.setEditable(true);
		textUserName.setEditable(true);
	}
	public void SetTextUnEditable() {
		textPassword.setEditable(false);
		textUserName.setEditable(false);
		textUserID.setEditable(false);
	}
	public void SetTextNull() {
		textUserID.setText("");
		textPassword.setText("");
		textUserName.setText("");
	}
	public void SetTextInfor(int index) {
		textUserID.setText(data.get(index).getCustomerID()+"");
		textPassword.setText(data.get(index).getPassword()+"");
		textUserName.setText(data.get(index).getAccount()+"");
	}
	public void PressAdd() {
		SetTextNull();
		SetTextEditable();
		btnCancel.setEnabled(true);
		btnDelete.setEnabled(false);
		btnUpdate.setEnabled(false);
		btnAdd.setText("Lưu");
		textUserID.setText((data.get(data.size()-1).getCustomerID()+1)+"");
	}
	public void PressSaveAdd() {
		int ID = Integer.parseInt(textUserID.getText());
		String UserName = textUserName.getText();
		String Password = textPassword.getText();
		
		if (UserName != null && Password != null) {
			try {
				DAOCustomer.getInstance().insert(new Customer(ID,UserName,Password,null,LocalDate.now(),null,null,null,null));
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			btnAdd.setText("Thêm");
			data.add(new Customer(ID,UserName,Password,null,LocalDate.now(),null,null,null,null));
			
			Object[] newRow = {ID,UserName,Password};
			dtm.addRow(newRow);
			table.revalidate();
			table.repaint();
			
			btnDelete.setEnabled(true);
			btnUpdate.setEnabled(true);
			SetTextUnEditable();
			btnCancel.setEnabled(false);
			
		}
		
	}
	public void PressCancel() {
		btnCancel.setEnabled(false);
		btnDelete.setEnabled(true);
		btnUpdate.setEnabled(true);
		btnAdd.setEnabled(true);
		btnAdd.setText("Thêm");
		btnDelete.setText("Xóa");
		btnUpdate.setText("Sửa");
		SetTextUnEditable();
	}
	public void PressDelete() {
		if (table.getSelectedRow() != -1) {
			try {
				DAOCustomer.getInstance().delete(Integer.parseInt(textUserID.getText()));
			} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			SetTextNull();
			dtm.removeRow(table.getSelectedRow());
			dtm.fireTableDataChanged();
			table.revalidate();
			table.repaint();
			data.remove(table.getSelectedRow());
		}
	}
	public void PressUpdate() {
		if (table.getSelectedRow() != -1) {
			SetTextEditable();
			btnAdd.setEnabled(false);
			btnDelete.setEnabled(false);
			btnCancel.setEnabled(true);
			btnUpdate.setText("Lưu");
		}
	}
	public void PressSaveUpdate() {
		int selectedRow = table.getSelectedRow();
		if (selectedRow != -1) {
			int ID = Integer.parseInt(textUserID.getText());
			String UserName = textUserName.getText();
			String Password = textPassword.getText();
			try {
				DAOCustomer.getInstance().update(new Customer(ID,UserName,Password,null,LocalDate.now(),null,null,null,null));
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			data.get(selectedRow).setCustomerID(ID);
			data.get(selectedRow).setAccount(UserName);
			data.get(selectedRow).setPassword(Password);
			dtm.setValueAt(ID, selectedRow, 0);
			dtm.setValueAt(UserName, selectedRow, 1);
			dtm.setValueAt(Password, selectedRow, 2);
			dtm.fireTableDataChanged();
			table.revalidate();
			table.repaint();
			
			btnUpdate.setText("Sửa");
			btnDelete.setEnabled(true);
			btnAdd.setEnabled(true);
			SetTextUnEditable();
			btnCancel.setEnabled(false);
		}
	}
}
