package view.Customer;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextField;

import Models.InfoCustomer;
import controller.Customer.Buoc3Listener;

public class PanelXacNhanThongTin_B3 extends JPanel {
	public JTextField txt_HoVaTen;
	public JTextField txt_SoDienThoai;
	public JTextField txt_Email;
	public JTextField txt_DiaChi;
	public FormBookTicket fbt;
	public InfoCustomer IC;
	public JCheckBox chkbx_XacNhan;
	/**
	 * Create the panel.
	 */
	
	public void GUI()
	{
		this.setBounds(0,0,529,500);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(170,244,240));
		panel.setBounds(10, 11, 509, 478);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 69, 489, 336);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		chkbx_XacNhan = new JCheckBox("Tôi xin xác nhận thông tin trên là đúng\r\n");
		chkbx_XacNhan.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chkbx_XacNhan.setBounds(95, 298, 303, 23);
		panel_1.add(chkbx_XacNhan);
		
		JLabel lblNewLabel_1 = new JLabel("Họ và tên : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(20, 42, 97, 35);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Số điện thoại : ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(20, 104, 125, 35);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Email : ");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(20, 230, 97, 35);
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Địa chỉ : ");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(20, 168, 97, 35);
		panel_1.add(lblNewLabel_1_2);
		
		txt_HoVaTen = new JTextField();
		txt_HoVaTen.setBounds(152, 42, 315, 35);
		panel_1.add(txt_HoVaTen);
		txt_HoVaTen.setColumns(10);
		
		txt_SoDienThoai = new JTextField();
		txt_SoDienThoai.setColumns(10);
		txt_SoDienThoai.setBounds(152, 104, 315, 35);
		panel_1.add(txt_SoDienThoai);
		
		txt_Email = new JTextField();
		txt_Email.setColumns(10);
		txt_Email.setBounds(152, 230, 315, 35);
		panel_1.add(txt_Email);
		
		txt_DiaChi = new JTextField();
		txt_DiaChi.setColumns(10);
		txt_DiaChi.setBounds(152, 168, 315, 35);
		panel_1.add(txt_DiaChi);
		
		JLabel lblNewLabel = new JLabel("Thông tin khách hàng");
		lblNewLabel.setBounds(118, 21, 282, 37);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JButton btnNewButton = new JButton("Quay lại");
		btnNewButton.setBackground(new Color(255,224,164));btnNewButton.setBounds(178, 416, 151, 51);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new Buoc3Listener(this));
		
		JButton btnXcNhn = new JButton("Xác nhận");
		btnXcNhn.setBackground(new Color(255,224,164));
		btnXcNhn.setBounds(348, 416, 151, 51);
		panel.add(btnXcNhn);
		btnXcNhn.addActionListener(new Buoc3Listener(this));
		
	}
	
	public void InputData()
	{
		txt_HoVaTen.setText(IC.getRealName());
		txt_SoDienThoai.setText(IC.getPhoneNumber());
		txt_Email.setText(IC.getEmail());
		txt_DiaChi.setText(IC.getHomeAddress());
	}
	
	public void OutputData()
	{
		IC.setEmail(txt_Email.getText());
		IC.setRealName(txt_HoVaTen.getText());
		IC.setPhoneNumber(txt_SoDienThoai.getText());
		IC.setHomeAddress(txt_DiaChi.getText());
	}
	
	public PanelXacNhanThongTin_B3(FormBookTicket fbt, InfoCustomer IC) {
		this.GUI();
		this.fbt = fbt;
		this.IC = IC;
		InputData();
	}
	
}
