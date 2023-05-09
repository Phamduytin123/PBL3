package view.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.admin.FormAdminListener;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.SQLException;

public class AdminForm extends JFrame {

	private JPanel contentPane;
	private JButton btnRoute, btnTripInDay, btnBill, btnUser;
	private PanelRouteAd panelRouteAd = new PanelRouteAd();
	private PanelTripInDay panelTripInDay = new PanelTripInDay();
	private PanelUserAd panelUserAd = new PanelUserAd();
	private PanelBillAd panelBillAd = new PanelBillAd();

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

	public AdminForm() throws ClassNotFoundException, SQLException  {
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

//		body = new PanelRouteAd();
//		body.setBounds(188, 0, 614, 553);
//		body.setLayout(null);

//		body.add(panelRouteAd);
//		body.add(panelTripInDay);

//		contentPane.add(body);
		
		panelRouteAd.setVisible(true);
		panelTripInDay.setVisible(false);
		panelUserAd.setVisible(false);
		panelBillAd.setVisible(false);
		contentPane.add(panelRouteAd);
		contentPane.add(panelTripInDay);
		contentPane.add(panelUserAd);
		contentPane.add(panelBillAd);
		
		btnRoute.addActionListener( new FormAdminListener(this));
		btnTripInDay.addActionListener( new FormAdminListener(this));
		btnUser.addActionListener( new FormAdminListener(this));
		btnBill.addActionListener( new FormAdminListener(this));
	
		this.setVisible(true);
	}

	public JButton getBtnRoute() {
		return btnRoute;
	}

	public void setBtnRoute(JButton btnRoute) {
		this.btnRoute = btnRoute;
	}

	public JButton getBtnTripInDay() {
		return btnTripInDay;
	}

	public void setBtnTripInDay(JButton btnTripInDay) {
		this.btnTripInDay = btnTripInDay;
	}

	public JButton getBtnBill() {
		return btnBill;
	}

	public void setBtnBill(JButton btnBill) {
		this.btnBill = btnBill;
	}

	public JButton getBtnUser() {
		return btnUser;
	}

	public void setBtnUser(JButton btnUser) {
		this.btnUser = btnUser;
	}

	public PanelRouteAd getPanelRouteAd() {
		return panelRouteAd;
	}

	public void setPanelRouteAd(PanelRouteAd panelRouteAd) {
		this.panelRouteAd = panelRouteAd;
	}

	public PanelTripInDay getPanelTripInDay() {
		return panelTripInDay;
	}

	public void setPanelTripInDay(PanelTripInDay panelTripInDay) {
		this.panelTripInDay = panelTripInDay;
	}

	public PanelUserAd getPanelUserAd() {
		return panelUserAd;
	}

	public void setPanelUserAd(PanelUserAd panelUserAd) {
		this.panelUserAd = panelUserAd;
	}

	public PanelBillAd getPanelBillAd() {
		return panelBillAd;
	}

	public void setPanelBillAd(PanelBillAd panelBillAd) {
		this.panelBillAd = panelBillAd;
	}

	public void PnRouteAdSelected() {
		panelRouteAd.setVisible(true);
		panelTripInDay.setVisible(false);
		panelUserAd.setVisible(false);
		panelBillAd.setVisible(false);
	}
	public void PnTripSelected() {
		panelRouteAd.setVisible(false);
		panelTripInDay.setVisible(true);
		panelUserAd.setVisible(false);
		panelBillAd.setVisible(false);
	}
	public void PnUserADSelected() {
		panelRouteAd.setVisible(false);
		panelTripInDay.setVisible(false);
		panelUserAd.setVisible(true);
		panelBillAd.setVisible(false);
	}
	public void PnBillAdSelected() {
		panelRouteAd.setVisible(false);
		panelTripInDay.setVisible(false);
		panelUserAd.setVisible(false);
		panelBillAd.setVisible(true);
	}
}
