package view.Customer;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Models.Customer;
import controller.Customer.FormMainListener;

import javax.swing.JTable;
import javax.swing.JScrollBar;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.Normalizer.Form;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.Window.Type;

public class FormMainPage extends JFrame {

	public JPanel contentPane;
	public JButton btnAcc,btnBookTicket,btnBill,btnLogOut;
	public JPanel body;
	public Customer cus;
	
	public PanelUser userPanel = new PanelUser();
	public BookingTicket1 bookingTicket1Panel = new BookingTicket1();
	public BookingTicket2 bookingTicket2Panel = new BookingTicket2();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FormMainPage frame = new FormMainPage();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	
	public void GUI()
	{

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(0, 255, 255));
		panelMenu.setBounds(0, 0, 167, 498);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		btnAcc = new JButton("Tài khoản");
		btnAcc.setIcon(new ImageIcon(FormMainPage.class.getResource("/photo/Custom-Icon-Design-Silky-Line-User-User.32.png")));
		btnAcc.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnAcc.setHorizontalAlignment(SwingConstants.LEFT);
		btnAcc.setBackground(new Color(0, 128, 192));
		btnAcc.setBounds(10, 84, 147, 53);
		panelMenu.add(btnAcc);
		
		btnBookTicket = new JButton("Đặt vé ");
		btnBookTicket.setIcon(new ImageIcon(FormMainPage.class.getResource("/photo/Icons8-Ios7-Cinema-Ticket.32.png")));
		btnBookTicket.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnBookTicket.setHorizontalAlignment(SwingConstants.LEFT);
		btnBookTicket.setBackground(new Color(0, 128, 192));
		btnBookTicket.setBounds(10, 172, 147, 53);
		panelMenu.add(btnBookTicket);
		
		btnBill = new JButton("Hóa đơn");
		btnBill.setIcon(new ImageIcon(FormMainPage.class.getResource("/photo/Icons8-Ios7-Finance-Bill.32.png")));
		
		btnBill.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnBill.setHorizontalAlignment(SwingConstants.LEFT);
		btnBill.setBackground(new Color(0, 128, 192));
		btnBill.setBounds(10, 260, 147, 53);
		panelMenu.add(btnBill);
		
		btnLogOut = new JButton("Đăng xuất");
		btnLogOut.setIcon(new ImageIcon(FormMainPage.class.getResource("/photo/Github-Octicons-Sign-out-24.32.png")));
		btnLogOut.setHorizontalAlignment(SwingConstants.LEFT);
		btnLogOut.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnLogOut.setBackground(new Color(0, 128, 192));
		btnLogOut.setBounds(10, 348, 147, 53);
		panelMenu.add(btnLogOut);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(167, 142, 546, 356);
		panelMenu.add(panel_2);
		
//		JPanel pn3 = new PanelUser();
//		JPanel pn4 = new PanelUserTop();
//		
//		
		body = new JPanel();
		body.setBounds(167, 0, 529,500);
		body.setBackground(Color.BLACK);
		body.setLayout(null);
//		body.add(pn4);
//		body.add(pn3);
		contentPane.add(body);
	}
	
	public void Init()
	{
		
		ActionListener m = new FormMainListener(this);
		btnAcc.addActionListener(m);
		btnBookTicket.addActionListener(m);
		btnBill.addActionListener(m);
		btnLogOut.addActionListener(m);
		((BookingTicket1)bookingTicket1Panel).btnViewTicket.addActionListener(m);
		((BookingTicket2)bookingTicket2Panel).lblBack.addMouseListener(new FormMainListener(this));
		
		this.body.add(new PanelWelcome());
		this.body.add(new PanelUserTop());
		setVisible(true);
	}
	
	public FormMainPage(Customer Cus) {
		
		this.cus = Cus;
		this.GUI();
		this.Init();
		
	}
	
	public void changeToAcc() {
		body.removeAll();
//		this.contentPane.remove(body);
//		JPanel p2 = new PanelUser();
		body.add(new PanelUserTop());
		
		body.add(userPanel);
//		body.add(p2);
		body.revalidate();
		body.repaint();
	}
	
	public void changeToBooking() {
		body.removeAll();
//		JPanel p = new BookingTicket1(this);
		
		
		body.add(bookingTicket1Panel);
		body.revalidate();
		body.repaint();
	}
	
	public void changeToBill() {
		body.removeAll();
		JPanel p1 = new PanelMainTop();
		JPanel p2 = new PanelListBill(cus.getCustomerID());
		body.add(p1);
		body.add(p2);
		body.revalidate();
		body.repaint();
	}
	
	public void changeToSitting() {
		body.removeAll();
	}
	
	public void changeToListTicket() throws SQLException {
		body.removeAll();
		
		// SetData
		((BookingTicket2)this.bookingTicket2Panel).KindOfBook = ((BookingTicket1)this.bookingTicket1Panel).KindOfBook;
		((BookingTicket2)this.bookingTicket2Panel).listDate = ((BookingTicket1)this.bookingTicket1Panel).listDate;
		((BookingTicket2)this.bookingTicket2Panel).CusID = ((BookingTicket1)this.bookingTicket1Panel).CusID;
		((BookingTicket2)this.bookingTicket2Panel).listRoute = ((BookingTicket1)this.bookingTicket1Panel).listRoute;
		
		((BookingTicket2)this.bookingTicket2Panel).Init();
		
		
		// SetEvent
		body.add(bookingTicket2Panel);
		body.revalidate();
		body.repaint();
	}

	public Boolean BT1_btnViewTicket_Check()
	{
		String DateGo = bookingTicket1Panel.txtNgayDi.getText();
		String DateBack = bookingTicket1Panel.txtNgayVe.getText();
		String KindOfBook = bookingTicket1Panel.KindOfBook;
		
		if(bookingTicket1Panel.listRoute.get(0).size() == 0)
		{
			JOptionPane.showMessageDialog(null, "Vui lòng tìm kiếm chuyến đi phù hợp trước");
			return false;
		}
		
		if(DateGo.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ ngày");
			return false;
		}
		if(KindOfBook.equals("Khứ hồi") && DateBack.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ ngày");
			return false;
		}
		
		bookingTicket1Panel.listDate = new ArrayList<>();	
		
		try {
			LocalDate.parse(DateGo, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Định dạng ngày đi ( dd/MM/yyyy -  VD : 05/05/2023 ) bị sai vui lòng nhập lại");
			return false;
		}
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		bookingTicket1Panel.listDate.add(LocalDate.parse(DateGo, formatter));	
		
		LocalDate DateGo1 = bookingTicket1Panel.listDate.get(0);
		
		if(LocalDate.now().compareTo(DateGo1) > 0)
		{
			JOptionPane.showMessageDialog(null, "Không thể nhập ngày đi nhỏ hơn ngày hiện tại");
			System.out.println(DateGo1.toString() + " - " + LocalDate.now());
			return false;
		}
		
		if(KindOfBook.equals("Khứ hồi"))
		{
			if(bookingTicket1Panel.listRoute.get(1).size() == 0)
			{
				JOptionPane.showMessageDialog(null, "Vui lòng tìm kiếm lại để lấy danh sách chiều về");
				return false;
			}
			
			try {
				LocalDate.parse(DateBack, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Định dạng ngày về ( dd/MM/yyyy -  VD : 05/05/2023 ) bị sai vui lòng nhập lại");
				return false;
			}
			
			bookingTicket1Panel.listDate.add(LocalDate.parse(DateBack, formatter));		
			List<LocalDate> listDate = bookingTicket1Panel.listDate;
			
			
			if(listDate.get(1).compareTo(listDate.get(0)) < 0)
			{
				JOptionPane.showMessageDialog(null, "Ngày về không thể nhỏ hơn ngày đi");
				return false;
			}
		}
		
		return true;
	}
	
	public void BT1_btnViewTicket_Select()
	{
		bookingTicket1Panel.CusID = cus.getCustomerID();
		try {
			changeToListTicket();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
