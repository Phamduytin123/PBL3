package view;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

import controller.UserListenner;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class PanelUser extends JPanel {

	/**
	 * Create the panel.
	 */
	
	public JTextField txtName;
	public JTextField txtDateOfBirths;
	public JTextField txtAccount;
	public JTextField txtPhoneNumber;
	public JTextField txtEmail;
	public JTextField txtCitizenID;
	public JRadioButton radioMale,radioFemale;	
	public final ButtonGroup buttonGroup = new ButtonGroup();
	public JButton btnUpdate,btnDoiMK;
	
	public void GUI()
	{
		this.setBackground(new Color(255, 255, 255));
		this.setBounds(0, 127, 529, 371);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(40, 26, 290, 320);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Họ và tên");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel.setBounds(26, 16, 67, 27);
		panel.add(lblNewLabel);
		
		txtName = new JTextField();
		txtName.setBounds(103, 16, 166, 27);
		panel.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblGiiTnh = new JLabel("Giới tính");
		lblGiiTnh.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblGiiTnh.setBounds(26, 59, 67, 27);
		panel.add(lblGiiTnh);
		
		JLabel lblNgy = new JLabel("Ngày sinh");
		lblNgy.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNgy.setBounds(26, 102, 67, 27);
		panel.add(lblNgy);
		
		JLabel lblaCh = new JLabel("Tài khoản");
		lblaCh.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblaCh.setBounds(26, 145, 67, 27);
		panel.add(lblaCh);
		
		JLabel lblSinThoai = new JLabel("SDT");
		lblSinThoai.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblSinThoai.setBounds(26, 188, 67, 27);
		panel.add(lblSinThoai);
		
		JLabel lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(26, 231, 67, 27);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("CCCD");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(26, 274, 67, 27);
		panel.add(lblNewLabel_6);
		
		txtDateOfBirths = new JTextField();
		txtDateOfBirths.setColumns(10);
		txtDateOfBirths.setBounds(103, 102, 166, 27);
		panel.add(txtDateOfBirths);
		
		txtAccount = new JTextField();
		txtAccount.setColumns(10);
		txtAccount.setBounds(103, 145, 166, 27);
		panel.add(txtAccount);
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setColumns(10);
		txtPhoneNumber.setBounds(103, 188, 166, 27);
		panel.add(txtPhoneNumber);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(103, 231, 166, 27);
		panel.add(txtEmail);
		
		txtCitizenID = new JTextField();
		txtCitizenID.setColumns(10);
		txtCitizenID.setBounds(103, 274, 166, 27);
		panel.add(txtCitizenID);
		
		radioMale = new JRadioButton("nam");
		buttonGroup.add(radioMale);
		radioMale.setBackground(new Color(192, 192, 192));
		radioMale.setBounds(103, 61, 67, 23);
		panel.add(radioMale);
		
		radioFemale = new JRadioButton("nữ");
		buttonGroup.add(radioFemale);
		radioFemale.setBackground(new Color(192, 192, 192));
		radioFemale.setBounds(211, 61, 58, 23);
		panel.add(radioFemale);
		
		btnUpdate = new JButton("Cập nhập thông tin");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnUpdate.setBackground(new Color(0, 128, 255));
		btnUpdate.setBounds(364, 96, 135, 38);
		add(btnUpdate);
		
		btnDoiMK = new JButton("Đổi mật khẩu");
		btnDoiMK.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnDoiMK.setBackground(new Color(0, 128, 255));
		btnDoiMK.setBounds(364, 170, 135, 38);
		add(btnDoiMK);
		
		btnUpdate.addActionListener(new UserListenner(this));

	}
	
	public PanelUser() 
	{
		this.GUI();
	}
}
