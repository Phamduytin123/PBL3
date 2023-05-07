package view.admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import javax.swing.JComboBox;

public class PanelUserAd extends JPanel {

	private JButton btnAdd, btnUpdate, btnDelete, btnCancel, btnReset;
	private JTextField textUserID;
	private JTextField textPassword;
	private JTextField textUserName;
	public DefaultTableModel dtm;
	private JTable table;
	
	private ArrayList<Customer> data = DAOCustomer.getInstance().selectAll();
	private JPanel panel;
	private JLabel lblNii;
	private JLabel lblSearch;
	private JTextField textFieldUserNameFind;
	
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
		lblUser.setForeground(new Color(0, 0, 255));
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblUser.setBounds(177, 11, 259, 34);
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
		btnAdd.setBounds(322, 157, 78, 28);
		add(btnAdd);
		
		 btnUpdate = new JButton("Sửa");
		btnUpdate.setBackground(new Color(255, 0, 0));
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdate.setBounds(425, 157, 78, 28);
		add(btnUpdate);
		
		 btnDelete = new JButton("Xóa");
		btnDelete.setBackground(new Color(0, 128, 255));
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDelete.setBounds(526, 157, 78, 28);
		add(btnDelete);
		
		 btnCancel = new JButton("Hủy");
		btnCancel.setEnabled(false);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBackground(new Color(192, 192, 192));
		btnCancel.setBounds(214, 157, 78, 28);
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
		scrollPane.setBounds(20, 262, 584, 266);
		add(scrollPane);
		
		SetTextUnEditable();
		table.getSelectionModel().addListSelectionListener( new UserListener(this));
		
		btnAdd.addActionListener(new UserListener(this));
		btnCancel.addActionListener(new UserListener(this));
		btnDelete.addActionListener(new UserListener(this));
		btnUpdate.addActionListener(new UserListener(this));
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 206, 594, 35);
		add(panel);
		
		lblNii = new JLabel("Tài khoản");
		lblNii.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNii.setBounds(98, 3, 68, 28);
		panel.add(lblNii);
		
		textFieldUserNameFind = new JTextField();
		textFieldUserNameFind.setColumns(10);
		textFieldUserNameFind.setBounds(234, 3, 109, 28);
		panel.add(textFieldUserNameFind);
		
		ImageIcon icon = new ImageIcon(PanelTripInDay.class.getResource("/photo/SearchButton.png"));
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newImg);
		
		lblSearch = new JLabel("");
		lblSearch.setBounds(379, 3, 25, 28);
		lblSearch.setIcon(newIcon);
		panel.add(lblSearch);
		
		btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnReset.setBackground(Color.LIGHT_GRAY);
		btnReset.setBounds(467, 2, 78, 28);
		panel.add(btnReset);
		
		btnReset.addActionListener(new UserListener(this));
		lblSearch.addMouseListener(new UserListener(this));
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
	public void PressSearch() {
		String Username = textFieldUserNameFind.getText();
		if(!Username.isEmpty()) {
			int n = dtm.getRowCount();
			for(int i = 0; i<n;i++)
			{
				dtm.removeRow(0);
			}
			for(int i =0; i< data.size();i++) {
				if (Username.equals(data.get(i).getAccount())) {
					int ID = data.get(i).getCustomerID();
					String username = data.get(i).getAccount();
					String password =  data.get(i).getPassword();
					Object[] rowData = {ID,username,password};
					dtm.addRow(rowData);
				}
			}
			if(dtm.getRowCount() == 0) {
				JOptionPane.showMessageDialog(null, "Không thể tìm thấy tài khoản phù hợp");
				for (int i = 0; i < data.size(); i++)
				{
					int ID = data.get(i).getCustomerID();
					String username = data.get(i).getAccount();
					String password =  data.get(i).getPassword();
					Object[] rowData = {ID,username,password};
					dtm.addRow(rowData);
				}
				return;
			} else {
				
			}
			table.setModel(dtm);
			table.revalidate();
			table.repaint();
		} else {
			JOptionPane.showMessageDialog(null, "Dữ liệu tên tài khoản không được để trống!");
			return;
		}
	}
	public void PressReset() {
		int n = dtm.getRowCount();
		for(int i = 0; i<n;i++)
		{
			dtm.removeRow(0);
		}
		for (int i = 0; i < data.size(); i++)
		{
			int ID = data.get(i).getCustomerID();
			String username = data.get(i).getAccount();
			String password =  data.get(i).getPassword();
			Object[] rowData = {ID,username,password};
			dtm.addRow(rowData);
		}
		table.setModel(dtm);
		table.revalidate();
		table.repaint();
	}

	public JButton getBtnReset() {
		return btnReset;
	}

	public void setBtnReset(JButton btnReset) {
		this.btnReset = btnReset;
	}

	public JLabel getLblSearch() {
		return lblSearch;
	}

	public void setLblSearch(JLabel lblSearch) {
		this.lblSearch = lblSearch;
	}
}
