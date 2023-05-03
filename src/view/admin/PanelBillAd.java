package view.admin;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;

public class PanelBillAd extends JPanel {

	/**
	 * Create the panel.
	 */
	
	public JButton btnAccept, btnRefuse;
	public JTextField textField;
	public JTextField textField_1;
	public JTextField textField_2;
	public JTextField textField_3;
	public JTextField textField_4;
	public JTextField textField_5;
	public JTextField textField_6;
	
	public PanelBillAd() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(0, 0, 614, 553);
		setLayout(null);
		JLabel lblBill = new JLabel("Thông tin hóa đơn");
		lblBill.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblBill.setBounds(27, 11, 259, 34);
		add(lblBill);
		
		JLabel lblBillID = new JLabel("Mã hóa đơn");
		lblBillID.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblBillID.setBounds(37, 56, 84, 34);
		add(lblBillID);
		
		JLabel lblCustomerID = new JLabel("Mã khách hàng");
		lblCustomerID.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblCustomerID.setBounds(37, 101, 84, 34);
		add(lblCustomerID);
		
		JLabel lblEndCity = new JLabel("Thanh toán");
		lblEndCity.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblEndCity.setBounds(37, 146, 84, 34);
		add(lblEndCity);
		
		JLabel lblDistance = new JLabel("Loại");
		lblDistance.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblDistance.setBounds(37, 191, 84, 34);
		add(lblDistance);
		
		JLabel lblDuration = new JLabel("Thời gian");
		lblDuration.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblDuration.setBounds(349, 56, 84, 34);
		add(lblDuration);
		
		JLabel lblBusID = new JLabel("Mã thông tin");
		lblBusID.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblBusID.setBounds(349, 101, 84, 34);
		add(lblBusID);
		
		JLabel lblGi = new JLabel("Tổng tiền");
		lblGi.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblGi.setBounds(349, 146, 84, 34);
		add(lblGi);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(125, 59, 96, 28);
		add(textField);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(125, 104, 96, 28);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(125, 149, 96, 28);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(125, 194, 96, 28);
		add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(430, 56, 96, 28);
		add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(430, 101, 96, 28);
		add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(430, 146, 96, 28);
		add(textField_6);
		
		 btnAccept = new JButton("Chấp nhận");
		 btnAccept.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 btnAccept.setBackground(new Color(255, 128, 0));
		 btnAccept.setBounds(336, 197, 114, 28);
		add(btnAccept);
		
		 btnRefuse = new JButton("Từ chối");
		 btnRefuse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 btnRefuse.setBackground(Color.RED);
		 btnRefuse.setBounds(483, 197, 114, 28);
		add(btnRefuse);
	}
}