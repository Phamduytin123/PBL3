package view.Login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Models.Customer;
import controller.LogIn.PanelLoginListenner;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FormLogin extends JFrame {

	private JPanel contentPane;
	public JTextField txtAccount;
	public JTextField txtPassword;
	public JButton btnDangNhap;
	public Customer cus = new Customer(-1, "", "", "", null, "", "", "", "");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormLogin frame = new FormLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void GUI()
	{
		setTitle("BusMap");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 538, 541);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(FormLogin.class.getResource("/photo/Graphicloads-Transport-Bus-4.96.png")));
		lblNewLabel_1.setBounds(56, 36, 96, 102);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(128, 255, 255));
		panel_2.setBounds(31, 205, 460, 155);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(24, 31, 106, 34);
		panel_2.add(panel);
		panel.setBackground(new Color(0, 128, 192));
		
		JLabel lblNewLabel = new JLabel("Tài khoản: ");
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		txtAccount = new JTextField();
		txtAccount.setBounds(155, 31, 275, 34);
		panel_2.add(txtAccount);
		txtAccount.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(24, 112, 106, 34);
		panel_2.add(panel_1);
		panel_1.setBackground(new Color(0, 128, 192));
		
		JLabel lblMtKhu = new JLabel("Mật khẩu: ");
		lblMtKhu.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_1.add(lblMtKhu);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(155, 112, 275, 37);
		panel_2.add(txtPassword);
		txtPassword.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Đăng nhập");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(159, 149, 216, 45);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("GAVN");
		lblNewLabel_3.setForeground(new Color(0, 128, 128));
		lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 55));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBackground(new Color(128, 255, 255));
		lblNewLabel_3.setBounds(222, 36, 235, 102);
		contentPane.add(lblNewLabel_3);
		
		btnDangNhap = new JButton("");
		btnDangNhap.setBackground(new Color(55, 174, 67));
		btnDangNhap.setIcon(new ImageIcon(FormLogin.class.getResource("/photo/Icons8-Windows-8-Users-Enter-2.64.png")));
		btnDangNhap.setBounds(235, 375, 64, 64);
		contentPane.add(btnDangNhap);
		
		JLabel lblNewLabel_4 = new JLabel("Quên mật khẩu ?");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(341, 391, 116, 26);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Đăng ký tài khoản");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_1.setBounds(56, 388, 145, 32);
		contentPane.add(lblNewLabel_4_1);
		btnDangNhap.addActionListener(new PanelLoginListenner(this));
		this.setVisible(true);
	}
	
	public FormLogin() {
		this.GUI();
	}
}
