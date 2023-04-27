package view.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.SQLException;

public class AdminForm extends JFrame {

	private JPanel contentPane;
	private JButton btnRoute, btnTripInDay, btnBill, btnUser;
	private JPanel body;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminForm frame = new AdminForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public AdminForm() throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 806, 590);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pnMenu = new JPanel();
		pnMenu.setBackground(new Color(128, 255, 255));
		pnMenu.setBounds(0, 0, 190, 553);
		contentPane.add(pnMenu);
		pnMenu.setLayout(null);

		btnRoute = new JButton("Lịch trình");
		btnRoute.setBackground(new Color(0, 128, 192));
		btnRoute.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnRoute.setBounds(0, 209, 190, 46);
		pnMenu.add(btnRoute);

		btnTripInDay = new JButton("Chuyến đi");
		btnTripInDay.setBackground(new Color(0, 128, 192));
		btnTripInDay.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnTripInDay.setBounds(0, 293, 190, 46);
		pnMenu.add(btnTripInDay);

		btnBill = new JButton("Hóa đơn");
		btnBill.setBackground(new Color(0, 128, 192));
		btnBill.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnBill.setBounds(0, 361, 190, 46);
		pnMenu.add(btnBill);

		btnUser = new JButton("Tài khoản");
		btnUser.setBackground(new Color(0, 128, 192));
		btnUser.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnUser.setBounds(0, 431, 190, 46);
		pnMenu.add(btnUser);

		body = new PanelRouteAd();
		body.setBounds(188, 0, 614, 553);
		contentPane.add(body);
		body.setLayout(null);
	}
}
