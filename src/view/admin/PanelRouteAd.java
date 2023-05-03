package view.admin;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import controller.admin.RouteListener;
import DAO.DAORoute;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;

public class PanelRouteAd extends JPanel {
	private JTextField textFieldRoute;
	private JTextField textFieldStartCity;
	private JTextField textFieldEndCity;
	private JTextField textFieldDistance;
	private JTextField textFieldDuration;
	private JTextField textFieldBusID;
	private JTextField textFieldPrice;
	private JTable table;
	private JButton btnAdd, btnUpdate, btnDelete, btnCancel;
	
	public JTextField getTextFieldRoute() {
		return textFieldRoute;
	}

	public void setTextFieldRoute(JTextField textFieldRoute) {
		this.textFieldRoute = textFieldRoute;
	}

	public JTextField getTextFieldStartCity() {
		return textFieldStartCity;
	}

	public void setTextFieldStartCity(JTextField textFieldStartCity) {
		this.textFieldStartCity = textFieldStartCity;
	}

	public JTextField getTextFieldEndCity() {
		return textFieldEndCity;
	}

	public void setTextFieldEndCity(JTextField textFieldEndCity) {
		this.textFieldEndCity = textFieldEndCity;
	}

	public JTextField getTextFieldDistance() {
		return textFieldDistance;
	}

	public void setTextFieldDistance(JTextField textFieldDistance) {
		this.textFieldDistance = textFieldDistance;
	}

	public JTextField getTextFieldDuration() {
		return textFieldDuration;
	}

	public void setTextFieldDuration(JTextField textFieldDuration) {
		this.textFieldDuration = textFieldDuration;
	}

	public JTextField getTextFieldBusID() {
		return textFieldBusID;
	}

	public void setTextFieldBusID(JTextField textFieldBusID) {
		this.textFieldBusID = textFieldBusID;
	}

	public JTextField getTextFieldPrice() {
		return textFieldPrice;
	}

	public void setTextFieldPrice(JTextField textFieldPrice) {
		this.textFieldPrice = textFieldPrice;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

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

	public DefaultTableModel getDtm() {
		return dtm;
	}

	public void setDtm(DefaultTableModel dtm) {
		this.dtm = dtm;
	}

	public List<Object[]> getData() {
		return data;
	}

	public void setData(List<Object[]> data) {
		this.data = data;
	}

	public DefaultTableModel dtm;
	private List<Object[]> data = DAORoute.getInstance().getListRouteAndCity();

	/**
	 * Create the panel.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public PanelRouteAd() throws ClassNotFoundException, SQLException {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(0, 0, 614, 553);
		setLayout(null);
		
		JLabel lblRoute = new JLabel("Thông tin lịch trình");
		lblRoute.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblRoute.setBounds(27, 11, 259, 34);
		add(lblRoute);
		
		JLabel lblRouteID = new JLabel("Mã lịch trình");
		lblRouteID.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblRouteID.setBounds(37, 56, 84, 34);
		add(lblRouteID);
		
		JLabel lblStartCity = new JLabel("Điểm đi");
		lblStartCity.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblStartCity.setBounds(37, 101, 84, 34);
		add(lblStartCity);
		
		JLabel lblEndCity = new JLabel("Điểm đến");
		lblEndCity.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblEndCity.setBounds(37, 146, 84, 34);
		add(lblEndCity);
		
		JLabel lblDistance = new JLabel("Khoảng cách");
		lblDistance.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblDistance.setBounds(37, 191, 84, 34);
		add(lblDistance);
		
		JLabel lblDuration = new JLabel("Thời gian");
		lblDuration.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblDuration.setBounds(349, 56, 84, 34);
		add(lblDuration);
		
		JLabel lblBusID = new JLabel("Mã xe buýt");
		lblBusID.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblBusID.setBounds(349, 101, 84, 34);
		add(lblBusID);
		
		JLabel lblGi = new JLabel("Giá");
		lblGi.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblGi.setBounds(349, 146, 84, 34);
		add(lblGi);
		
		
		
		
		table = new JTable();
		
		String[] columnNames = {"ID","Điểm đi","Điểm đến","Khoảng cách","Thời gian","Mã xe","Giá"};
		
		dtm = new DefaultTableModel(columnNames, 0);
		
		for (int i = 0; i < data.size(); i++)
		{
			
//			String ID = data.get(i).getRouteID();
//			String StartCity = DAOCity.getInstance().getNameCityByID(data.get(i).getCityIDStart());
//			String EndCity =  DAOCity.getInstance().getNameCityByID(data.get(i).getCityIDEnd());
//			int Distance = data.get(i).getDistance();
//			Time time = data.get(i).getDuration();
//			int price = data.get(i).getPrice();
//			String busID = data.get(i).getBusID();
			Object[] rowData = data.get(i);
			dtm.addRow(rowData);
		}
		
		table.setModel(dtm);
		table.getSelectionModel().addListSelectionListener( new RouteListener(this));
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(27, 262, 553, 266);
		add(scrollPane);
		
		textFieldRoute = new JTextField();
		textFieldRoute.setEditable(false);
		textFieldRoute.setBounds(141, 58, 96, 28);
		add(textFieldRoute);
		textFieldRoute.setColumns(10);
		
		textFieldStartCity = new JTextField();
		textFieldStartCity.setEditable(false);
		textFieldStartCity.setColumns(10);
		textFieldStartCity.setBounds(141, 102, 96, 28);
		add(textFieldStartCity);
		
		textFieldEndCity = new JTextField();
		textFieldEndCity.setEditable(false);
		textFieldEndCity.setColumns(10);
		textFieldEndCity.setBounds(141, 147, 96, 28);
		add(textFieldEndCity);
		
		textFieldDistance = new JTextField();
		textFieldDistance.setEditable(false);
		textFieldDistance.setColumns(10);
		textFieldDistance.setBounds(141, 192, 96, 28);
		add(textFieldDistance);
		
		textFieldDuration = new JTextField();
		textFieldDuration.setEditable(false);
		textFieldDuration.setColumns(10);
		textFieldDuration.setBounds(428, 58, 96, 28);
		add(textFieldDuration);
		
		textFieldBusID = new JTextField();
		textFieldBusID.setEditable(false);
		textFieldBusID.setColumns(10);
		textFieldBusID.setBounds(428, 102, 96, 28);
		add(textFieldBusID);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setEditable(false);
		textFieldPrice.setColumns(10);
		textFieldPrice.setBounds(428, 147, 96, 28);
		add(textFieldPrice);
		
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
		btnCancel.setBounds(322, 230, 78, 28);
		add(btnCancel);
		
		btnAdd.addActionListener(new RouteListener(this));
		btnCancel.addActionListener(new RouteListener(this));
	}
	public void SetTextUnEditable() {
		this.textFieldBusID.setEditable(false);
		this.textFieldDistance.setEditable(false);
		this.textFieldDuration.setEditable(false);
		this.textFieldEndCity.setEditable(false);
		this.textFieldPrice.setEditable(false);
		this.textFieldStartCity.setEditable(false);
	}
	public void SetTextEditable() {
		this.textFieldBusID.setEditable(true);
		this.textFieldDistance.setEditable(true);
		this.textFieldDuration.setEditable(true);
		this.textFieldEndCity.setEditable(true);
		this.textFieldPrice.setEditable(true);
		this.textFieldStartCity.setEditable(true);
	}
	public void SetTextInFor(int index) {
		this.textFieldRoute.setText(data.get(index)[0]+"");
		this.textFieldStartCity.setText(data.get(index)[1]+"");
		this.textFieldEndCity.setText(data.get(index)[2]+"");
		this.textFieldDistance.setText(data.get(index)[3]+"");
		this.textFieldDuration.setText(data.get(index)[4]+"");
		this.textFieldBusID.setText(data.get(index)[5]+"");
		this.textFieldPrice.setText(data.get(index)[6]+"");
	}
	public void SetTextNull() {
		this.textFieldBusID.setText("");
		this.textFieldDistance.setText("");
		this.textFieldDuration.setText("");
		this.textFieldEndCity.setText("");
		this.textFieldPrice.setText("");
		this.textFieldStartCity.setText("");
		this.textFieldRoute.setText("");
	}
	public void PressAdd() {
		SetTextNull();
		SetTextEditable();
		btnCancel.setEnabled(true);
		btnDelete.setEnabled(false);
		btnUpdate.setEnabled(false);
		btnAdd.setText("Lưu");
	}
	public void PressCancel() {
		btnCancel.setEnabled(false);
		btnDelete.setEnabled(true);
		btnUpdate.setEnabled(true);
		btnAdd.setEnabled(true);
	}
}
