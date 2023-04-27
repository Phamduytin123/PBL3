package view.Customer;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.DAOInfoCustomer;
import Models.Bill;
import Models.InfoCustomer;
import Models.Ticket;

public class FormBillDetail extends JFrame {

	private JPanel contentPane;

	public Bill bl;
	public List<Ticket> listTicket;
	public InfoCustomer IC;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bill l = new Bill(-1, 1, "", "", "", null, 1, 120000);
					List<Ticket> listTicket = new ArrayList<>();
					
					FormBillDetail frame = new FormBillDetail(l, listTicket);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public void GUI()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	
	}
	
	public void Init() throws ClassNotFoundException, SQLException
	{
		IC = DAOInfoCustomer.getInstance().selectByID(bl.getInfoID() +"");
	}
	
	public FormBillDetail(Bill bl, List<Ticket> listTicket) {
		
		this.bl = bl;
		this.listTicket = listTicket;
		this.GUI();
		
		try {
			this.Init();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
