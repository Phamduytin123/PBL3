
package view.admin;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;

public class PanelTripInDay extends JPanel {

	/**
	 * Create the panel.
	 */
	
	public JButton btnDelete, btnAdd, btnUpdate, btnCancel;
	public JTextField textTripID;
	public JTextField textFieldTimeStart;
	public JTextField textFieldTimeEnd;
	private JTextField textFieldRouteID;
	public JTextField textFieldDayStart;
	public JTextField textFieldDayEnd;
	public JTextField textFieldDay;
	public JTable table;

	public PanelTripInDay() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(0, 0, 614, 553);
		setLayout(null);
		
		JLabel lblTripInDay = new JLabel("Thông tin chuyến đi");
		lblTripInDay.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTripInDay.setBounds(27, 11, 259, 34);
		add(lblTripInDay);
		
		JLabel lblTripID = new JLabel("Mã chuyến đi");
		lblTripID.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblTripID.setBounds(37, 56, 84, 28);
		add(lblTripID);
		
		JLabel lblStartCity = new JLabel("Thời gian đi");
		lblStartCity.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblStartCity.setBounds(37, 101, 84, 28);
		add(lblStartCity);
		
		JLabel lblEndCity = new JLabel("Thời gian đến");
		lblEndCity.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblEndCity.setBounds(37, 146, 84, 28);
		add(lblEndCity);
		
		JLabel lblDistance = new JLabel("Mã lịch trình");
		lblDistance.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblDistance.setBounds(37, 191, 84, 28);
		add(lblDistance);
		
		JLabel lblDuration = new JLabel("Ngày đi");
		lblDuration.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblDuration.setBounds(349, 56, 84, 28);
		add(lblDuration);
		
		JLabel lblBusID = new JLabel("Ngày về");
		lblBusID.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblBusID.setBounds(349, 101, 84, 28);
		add(lblBusID);
		
		JLabel lblGi = new JLabel("Lịch ngày");
		lblGi.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblGi.setBounds(349, 146, 84, 28);
		add(lblGi);
		
		
		
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
		
		textTripID = new JTextField();
		textTripID.setEditable(false);
		textTripID.setColumns(10);
		textTripID.setBounds(131, 56, 109, 28);
		add(textTripID);
		
		textFieldTimeStart = new JTextField();
		textFieldTimeStart.setEditable(false);
		textFieldTimeStart.setColumns(10);
		textFieldTimeStart.setBounds(131, 101, 109, 28);
		add(textFieldTimeStart);
		
		textFieldTimeEnd = new JTextField();
		textFieldTimeEnd.setEditable(false);
		textFieldTimeEnd.setColumns(10);
		textFieldTimeEnd.setBounds(131, 146, 109, 28);
		add(textFieldTimeEnd);
		
		textFieldRouteID = new JTextField();
		textFieldRouteID.setEditable(false);
		textFieldRouteID.setColumns(10);
		textFieldRouteID.setBounds(131, 191, 109, 28);
		add(textFieldRouteID);
		
		textFieldDayStart = new JTextField();
		textFieldDayStart.setEditable(false);
		textFieldDayStart.setColumns(10);
		textFieldDayStart.setBounds(412, 56, 109, 28);
		add(textFieldDayStart);
		
		textFieldDayEnd = new JTextField();
		textFieldDayEnd.setEditable(false);
		textFieldDayEnd.setColumns(10);
		textFieldDayEnd.setBounds(412, 101, 109, 28);
		add(textFieldDayEnd);
		
		textFieldDay = new JTextField();
		textFieldDay.setEditable(false);
		textFieldDay.setColumns(10);
		textFieldDay.setBounds(412, 146, 109, 28);
		add(textFieldDay);
		
		table = new JTable();
		
		String[] columnNames = {"Mã chuyến đi","Thời gian đi","Thời gian đến","Mã lịch trình","Ngày đi","Ngày đến"};
		
	}
}