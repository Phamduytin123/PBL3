package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.DAOBill;
import DAO.DAOBus;
import DAO.DAOInfoCustomer;
import DAO.DAORoute;
import DAO.DAOTicket;
import DAO.DAOTrip;
import Models.Bill;
import Models.Bus;
import Models.Customer;
import Models.InfoCustomer;
import Models.Route;
import Models.Ticket;
import Models.Trip;

public class FormBookTicket extends JFrame {

	public JPanel contentPane;
	public Trip trip;
	public int cusID;
	public List<Ticket> SelectedTicket;
	public List<Ticket> BusyTicket;
	public InfoCustomer IC;
	public Bus bus;
	public Bill bl;
	public Route r;
	public int BuocTruocDo;
	public String kindOfBook;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Trip trip1 = null;
				InfoCustomer IC2 = new InfoCustomer(0, "", "", "", "");
				try {
					trip1 = DAOTrip.getInstance().selectByID(110 +"");
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					FormBookTicket frame = new FormBookTicket(trip1, IC2, 1, "Khứ hồi");
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
	
	// GUI
	public void init() throws ClassNotFoundException, SQLException
	{
		this.SelectedTicket = new ArrayList<>();

		this.BusyTicket = new ArrayList<>();
		
		this.BusyTicket = DAOTicket.getInstance().getBusySeat(trip.getTripID());
	
		int BillID = DAOBill.getInstance().getNextID();
		bl = new Bill(BillID, cusID, "", "Đã Thanh Toán", kindOfBook, LocalDate.now(),0 , 0);
		
	}
	
	public FormBookTicket(Trip trip, InfoCustomer IC , int cusID, String KindOfBook) throws ClassNotFoundException, SQLException {
		this.trip = trip;
		this.cusID = cusID;
		this.IC = IC;
		this.kindOfBook = KindOfBook;
		
		r = DAORoute.getInstance().selectByID(trip.getRouteID());
		this.bus = DAOBus.getInstance().selectByID(r.getBusID());
		
		init();
		this.GUI();
	}

	public void GUI()
	{
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 529,500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(1, 1));
		setContentPane(contentPane);
		BuocTruocDo = 1;
		JPanel temp = new PanelSitting(bus, this.BusyTicket, this.SelectedTicket, this);
		contentPane.add(temp);
	}

	// Support
	public void Process2()
	{
		int PriceBase = r.getPrice();
		int TotalPrice = 0;
		for(Ticket item : SelectedTicket)
		{
			String SN = item.getSeatNumber();
			if(bus.getKindOfBus().equals("1tang") || bus.getKindOfBus().equals("2tang"))
			{
				
				if(SN.equals("G01") || SN.equals("G02") || SN.equals("G03") ||
					SN.equals("G07") || SN.equals("G08") || SN.equals("G09") ||
					SN.equals("G13") || SN.equals("G14") || SN.equals("G15") )
				{
					item.setPrice((int)(PriceBase + PriceBase*0.1));
					item.setKindOfTicket("Hạng nhất");
				}
				else if(SN.equals("G19") || SN.equals("G25") || SN.equals("G31") ||
						SN.equals("G20") || SN.equals("G26") || SN.equals("G32") ||
						SN.equals("G21") || SN.equals("G27") || SN.equals("G33") )
					{
						item.setPrice((int)(PriceBase + PriceBase*0.08));
						item.setKindOfTicket("Hạng trung");
					}
				else {
					item.setPrice(PriceBase);
					item.setKindOfTicket("Hạng phổ thông");
				}
			}
			else
			{
				if(SN.equals("G01") || SN.equals("G02") || 
						SN.equals("G06") || SN.equals("G07") )
					{
						item.setPrice((int)(PriceBase + PriceBase*0.1));
						item.setKindOfTicket("Hạng nhất");
					}
					else if(SN.equals("G11") || SN.equals("G16") || 
							SN.equals("G12") || SN.equals("G17") )
						{
							item.setPrice((int)(PriceBase + PriceBase*0.08));
							item.setKindOfTicket("Hạng trung");
						}
					else {
						item.setPrice(PriceBase);
						item.setKindOfTicket("Hạng phổ thông");
					}
			}
			TotalPrice += item.getPrice();
			System.out.println(item);
		}
		bl.setTotalPrice(TotalPrice);
		
	}
	
	public void InsertIntoDate() throws ClassNotFoundException, SQLException
	{
		
		int InfoID = DAOInfoCustomer.getInstance().checkID(IC);
		
		// Init Bill
		
		for(Ticket item : SelectedTicket)
		{
			item.setBillID(DAOBill.getInstance().getNextID());
			item.setTripID(trip.getTripID());
		}
		
		if(InfoID != -1)
		{
			bl.setInfoID(InfoID);
		}
		else
		{
			IC.setInfoID(DAOInfoCustomer.getInstance().getNextID());
			bl.setInfoID(IC.getInfoID());
			DAOInfoCustomer.getInstance().insert(IC);
		}
		DAOBill.getInstance().insert(bl);
		for(Ticket item : SelectedTicket)
		{
			DAOTicket.getInstance().insert(item);
		}
	}
	
	// Event
	
	// Buoc 1
	public void Buoc2Lui1()
	{
		
	}
	
	// Buoc 2
	public void Buoc2Sang3()
	{
		this.Process2();
		contentPane.removeAll();
		JPanel pn = new XacNhanThongTin_B3(this, IC);
		contentPane.add(pn);
		contentPane.revalidate();
		contentPane.repaint();
		BuocTruocDo = 2;
	}
	
	public void Buoc2Sang4()
	{
		this.Process2();
		contentPane.removeAll();
		JPanel pn = new ThanhToan_B4(this, IC, SelectedTicket.size(), bl, bus, trip);
		
		contentPane.add(pn);
		contentPane.revalidate();
		contentPane.repaint();
		BuocTruocDo = 2;
	}

	public void Lui2()
	{
		contentPane.removeAll();
		JPanel pn = new PanelSitting(bus, this.BusyTicket, this.SelectedTicket, this);
		contentPane.add(pn);
		contentPane.revalidate();
		contentPane.repaint();
	}
	
	// Buoc 3
	public void Buoc3Sang4()
	{
		contentPane.removeAll();
		JPanel pn = new ThanhToan_B4(this, IC, SelectedTicket.size(), bl, bus, trip);
		
		contentPane.add(pn);
		contentPane.revalidate();
		contentPane.repaint();
		BuocTruocDo = 3;
	}
	
	public void Buoc4Lui3()
	{
		contentPane.removeAll();
		JPanel pn = new XacNhanThongTin_B3(this, IC);
		contentPane.add(pn);
		contentPane.revalidate();
		contentPane.repaint();
		BuocTruocDo = 4;
	}
	
	// Buoc 4
	public void Buoc4Sang4A()
	{
		contentPane.removeAll();
		JPanel pn = new ThanhToanBangNganHang(this);
		contentPane.add(pn);
		contentPane.revalidate();
		contentPane.repaint();
		BuocTruocDo = 4;
	}
	
	public void Buoc4ALui4()
	{
		contentPane.removeAll();
		JPanel pn = new ThanhToan_B4(this, IC, SelectedTicket.size(), bl, bus, trip);
		
		contentPane.add(pn);
		contentPane.revalidate();
		contentPane.repaint();
		BuocTruocDo = 3;
		BuocTruocDo = 41;
	}
	
	// Buoc 5
	public void Sang5()
	{
		contentPane.removeAll();
		JPanel pn = new CamOn_B5(this);
		contentPane.add(pn);
		contentPane.revalidate();
		contentPane.repaint();
		BuocTruocDo = 4;
	}
	
	public void KetThucBuoc5()
	{
		try {
			this.InsertIntoDate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(ABORT);
	}
}
