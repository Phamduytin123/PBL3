package view.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.admin.FormAdminListener;
import view.Login.FormLogin;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.SQLException;

public class AdminForm extends JFrame {

	private JPanel contentPane;
	private JButton btnRoute, btnTripInDay, btnBill, btnUser,btnSignOut;
	public JButton btnStatisticByMonth, btnStatisticByYear, btnLogOut_2, btnStatisticAll;
	public JButton getBtnSignOut() {
		return btnSignOut;
	}

	public void setBtnSignOut(JButton btnSignOut) {
		this.btnSignOut = btnSignOut;
	}
	private PanelRouteAd panelRouteAd ;
	private PanelTripInDay panelTripInDay ;
	private PanelUserAd panelUserAd ;
	private PanelBillAd panelBillAd ;
	
	private PanelStatisticByMonth panelStatisticByMonth;
	private PanelStatisticByYear panelStatisticByYear;
	private PanelStatisticAll panelStatisticAll;
	
	private JMenuBar menuBar = new JMenuBar();
	public JMenuItem menuQuanLy = new JMenuItem("Quản lý");
	public JMenuItem menuThongKe = new JMenuItem("Thống kê");
	
	
	
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

	public void GUI()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 806, 623);
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
		btnRoute.setBounds(0, 53, 190, 46);
		pnMenu.add(btnRoute);

		btnTripInDay = new JButton("Chuyến đi");
		btnTripInDay.setBackground(new Color(0, 128, 192));
		btnTripInDay.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnTripInDay.setBounds(0, 152, 190, 46);
		pnMenu.add(btnTripInDay);

		btnBill = new JButton("Hóa đơn");
		btnBill.setBackground(new Color(0, 128, 192));
		btnBill.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnBill.setBounds(0, 251, 190, 46);
		pnMenu.add(btnBill);

		btnUser = new JButton("Tài khoản");
		btnUser.setBackground(new Color(0, 128, 192));
		btnUser.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnUser.setBounds(0, 350, 190, 46);
		pnMenu.add(btnUser);
		
		 btnSignOut = new JButton("Đăng xuất");
		btnSignOut.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnSignOut.setBackground(new Color(0, 128, 192));
		btnSignOut.setBounds(0, 449, 190, 46);
		pnMenu.add(btnSignOut);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128,255,255));
		panel.setBounds(0, 55, 190, 413);
		pnMenu.add(panel);
		panel.setLayout(null);
		
		 btnStatisticByMonth = new JButton("Theo tháng");
		btnStatisticByMonth.setBounds(0, 136, 190, 46);
		panel.add(btnStatisticByMonth);
		btnStatisticByMonth.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnStatisticByMonth.setBackground(new Color(0, 128, 192));
		
		 btnStatisticByYear = new JButton("Theo năm");
		btnStatisticByYear.setBounds(0, 227, 190, 46);
		panel.add(btnStatisticByYear);
		btnStatisticByYear.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnStatisticByYear.setBackground(new Color(0, 128, 192));
		
		 btnLogOut_2 = new JButton("Đăng xuất");
		btnLogOut_2.setBounds(0, 318, 190, 46);
		panel.add(btnLogOut_2);
		btnLogOut_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnLogOut_2.setBackground(new Color(0, 128, 192));
		
		 btnStatisticAll = new JButton("Doanh Thu");
		btnStatisticAll.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnStatisticAll.setBackground(new Color(0, 128, 192));
		btnStatisticAll.setBounds(0, 45, 190, 46);
		panel.add(btnStatisticAll);
		
		menuThongKe.setBackground(Color.LIGHT_GRAY);
		menuThongKe.setFont(new Font("Times New Roman", Font.BOLD, 16));
		menuThongKe.addActionListener(new FormAdminListener(this));
		
		menuQuanLy.setBackground(Color.LIGHT_GRAY);
		menuQuanLy.setFont(new Font("Times New Roman", Font.BOLD, 16));
		menuQuanLy.addActionListener(new FormAdminListener(this));
		
		menuBar.add(menuQuanLy);
		menuBar.add(menuThongKe);
		
		menuQuanLy.setHorizontalAlignment(SwingConstants.CENTER);
		
		menuThongKe.setHorizontalAlignment(SwingConstants.CENTER);
		
		this.setJMenuBar(menuBar);
		
	}
	
	public void Management_Select()
	{
		btnRoute.setVisible(true);
		btnSignOut.setVisible(true);
		btnTripInDay.setVisible(true);
		btnUser.setVisible(true);
		btnBill.setVisible(true);
		
		btnLogOut_2.setVisible(false);
		btnStatisticByMonth.setVisible(false);
		btnStatisticByYear.setVisible(false);
		btnStatisticAll.setVisible(false);
		
		panelRouteAd.setVisible(true);
		panelTripInDay.setVisible(false);
		panelUserAd.setVisible(false);
		panelBillAd.setVisible(false);
		
		panelStatisticByMonth.setVisible(false);
		panelStatisticByYear.setVisible(false);
		panelStatisticAll.setVisible(false);
	}
	
	public void Statistic_Select()
	{
		btnRoute.setVisible(false);
		btnSignOut.setVisible(false);
		btnTripInDay.setVisible(false);
		btnUser.setVisible(false);
		btnBill.setVisible(false);
		
		btnLogOut_2.setVisible(true);
		btnStatisticByMonth.setVisible(true);
		btnStatisticByYear.setVisible(true);
		btnStatisticAll.setVisible(true);
		
		panelRouteAd.setVisible(false);
		panelTripInDay.setVisible(false);
		panelUserAd.setVisible(false);
		panelBillAd.setVisible(false);
		
		panelStatisticByMonth.setVisible(false);
		panelStatisticByYear.setVisible(false);
		panelStatisticAll.setVisible(true);
	}
	
	public void Init() throws ClassNotFoundException, SQLException
	{
		this.panelBillAd = new PanelBillAd();
		this.panelRouteAd = new PanelRouteAd();
		this.panelTripInDay = new PanelTripInDay();
		this.panelUserAd = new PanelUserAd();
		this.panelStatisticByMonth = new PanelStatisticByMonth();
		this.panelStatisticByYear = new PanelStatisticByYear();
		this.panelStatisticAll = new PanelStatisticAll();
		
		panelRouteAd.setVisible(true);
		panelTripInDay.setVisible(false);
		panelUserAd.setVisible(false);
		panelBillAd.setVisible(false);
		
		panelStatisticByMonth.setVisible(false);
		panelStatisticByYear.setVisible(false);
		panelStatisticAll.setVisible(false);
		
		contentPane.add(panelRouteAd);
		contentPane.add(panelTripInDay);
		contentPane.add(panelUserAd);
		contentPane.add(panelBillAd);
		contentPane.add(panelStatisticByMonth);
		contentPane.add(panelStatisticByYear);
		contentPane.add(panelStatisticAll);
		
		btnRoute.addActionListener( new FormAdminListener(this));
		btnTripInDay.addActionListener( new FormAdminListener(this));
		btnUser.addActionListener( new FormAdminListener(this));
		btnBill.addActionListener( new FormAdminListener(this));
		btnSignOut.addActionListener( new FormAdminListener(this));
		
		btnLogOut_2.addActionListener( new FormAdminListener(this));
		btnStatisticByMonth.addActionListener( new FormAdminListener(this));
		btnStatisticByYear.addActionListener( new FormAdminListener(this));
		btnStatisticAll.addActionListener(new FormAdminListener(this));
		
		this.setVisible(true);
	}
	
	public AdminForm() throws ClassNotFoundException, SQLException  {
		
		this.GUI();
		this.Init();
		this.Management_Select();
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
		
		panelStatisticByMonth.setVisible(false);
		panelStatisticByYear.setVisible(false);
		panelStatisticAll.setVisible(false);
	}
	public void PnTripSelected() {
		panelRouteAd.setVisible(false);
		panelTripInDay.setVisible(true);
		panelUserAd.setVisible(false);
		panelBillAd.setVisible(false);
		panelTripInDay.Init();
		
		panelStatisticByMonth.setVisible(false);
		panelStatisticByYear.setVisible(false);
		panelStatisticAll.setVisible(false);
	}
	public void PnUserADSelected() {
		panelRouteAd.setVisible(false);
		panelTripInDay.setVisible(false);
		panelUserAd.setVisible(true);
		panelBillAd.setVisible(false);
		
		panelStatisticByMonth.setVisible(false);
		panelStatisticByYear.setVisible(false);
		panelStatisticAll.setVisible(false);
	}
	public void PnBillAdSelected() {
		panelRouteAd.setVisible(false);
		panelTripInDay.setVisible(false);
		panelUserAd.setVisible(false);
		panelBillAd.setVisible(true);
		
		panelStatisticByMonth.setVisible(false);
		panelStatisticByYear.setVisible(false);
		panelStatisticAll.setVisible(false);
	}
	
	public void btnStatisticByMonth_Selected()
	{
		panelRouteAd.setVisible(false);
		panelTripInDay.setVisible(false);
		panelUserAd.setVisible(false);
		panelBillAd.setVisible(false);
		
		panelStatisticByMonth.setVisible(true);
		panelStatisticByYear.setVisible(false);
		panelStatisticAll.setVisible(false);
	}
	
	public void btnStatisticByYear_Selected()
	{
		panelRouteAd.setVisible(false);
		panelTripInDay.setVisible(false);
		panelUserAd.setVisible(false);
		panelBillAd.setVisible(false);
		
		panelStatisticByMonth.setVisible(false);
		panelStatisticByYear.setVisible(true);
		panelStatisticAll.setVisible(false);
	}
	
	public void btnStatisticAll_Select()
	{
		panelRouteAd.setVisible(false);
		panelTripInDay.setVisible(false);
		panelUserAd.setVisible(false);
		panelBillAd.setVisible(false);
		
		panelStatisticByMonth.setVisible(false);
		panelStatisticByYear.setVisible(false);
		panelStatisticAll.setVisible(true);
	}
	public void SignOut() {
		this.dispose();
		new FormLogin();
	}
}
