package view;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import Algorithm.floydWarshall;
import DAO.DAOCity;
import DAO.DAOTrip;
import Models.InfoCustomer;
import Models.Route;
import controller.BookingTicket2Listener;

public class BookingTicket2 extends JPanel {

	private JTextField txtNgayDi;
	public Choice choice_DiemDi, choice_DiemDen;
	public JButton btn_ChieuDi, btn_ChieuVe;
	public JTextField txtMap;
	public JLabel lblSearch, lblBack;
	public JPanel panel = new JPanel();
	// Date
	public List<List<Route>> listRoute;
	public List<LocalDate> listDate;
	public String KindOfBook;
	public InfoCustomer IC;
	public int CusID;
	
	
	
	public void GUI()
	{
		setBackground(new Color(255, 255, 255));
		this.setBounds(0, 0, 529, 500);
		setLayout(null);
		
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 140, 529, 360);
		add(panel);
		
		JLabel lblNewLabel = new JLabel("Danh sách vé");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(163, 0, 202, 45);
		add(lblNewLabel);
		
		JLabel lblNewLabel_3_1 = new JLabel("-Các điểm phải đi qua: ");
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_3_1.setBounds(23, 41, 145, 35);
		add(lblNewLabel_3_1);
		
		txtMap = new JTextField("");
		txtMap.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtMap.setHorizontalAlignment(SwingConstants.LEFT);
		txtMap.setEditable(false);
		
		JScrollPane temp = new JScrollPane(txtMap);
		temp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		temp.setBounds(199, 52, 320, 40);
		temp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(temp);
		
		btn_ChieuDi = new JButton("Chiều đi");
		btn_ChieuDi.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btn_ChieuDi.setBounds(18, 69, 86, 23);
		btn_ChieuDi.setVisible(false);
		add(btn_ChieuDi);
		
		btn_ChieuVe = new JButton("Chiều về");
		btn_ChieuVe.setBounds(108, 69, 86, 23);
		btn_ChieuVe.setVisible(false);
		add(btn_ChieuVe);
		
		JLabel lblNewLabel_1 = new JLabel("Điểm đi");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(18, 115, 50, 20);
		add(lblNewLabel_1);
		
		choice_DiemDi = new Choice();
		choice_DiemDi.setBounds(71, 115, 97, 20);
		add(choice_DiemDi);
		
		choice_DiemDen = new Choice();
		choice_DiemDen.setBounds(238, 115, 97, 20);
		add(choice_DiemDen);
		
		JLabel lblNewLabel_1_1 = new JLabel("Điểm đến");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(173, 115, 61, 20);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Ngày đi");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(343, 115, 57, 20);
		add(lblNewLabel_1_1_1);
		
		txtNgayDi = new JTextField();
		txtNgayDi.setBounds(395, 115, 94, 20);
		add(txtNgayDi);
		txtNgayDi.setColumns(10);
		
		ImageIcon icon = new ImageIcon(BookingTicket2.class.getResource("/photo/SearchButton.png"));
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newImg);
		
		lblSearch = new JLabel("");
		lblSearch.setBounds(496, 112, 23, 23);
		lblSearch.setIcon(newIcon);
		lblSearch.addMouseListener(new BookingTicket2Listener(this));
		add(lblSearch);
		
		icon = new ImageIcon(BookingTicket2.class.getResource("/photo/BackButton.png"));
		img = icon.getImage();
		newImg = img.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		newIcon = new ImageIcon(newImg);
		
		lblBack = new JLabel("");
		lblBack.setBounds(23, 7, 35, 35);
		lblBack.setIcon(newIcon);
		lblBack.addMouseListener(new BookingTicket2Listener(this));
		add(lblBack);
	}
	
	public void Init() throws SQLException
	{
		IC = new InfoCustomer(-1, "", "", "", "");

		if(KindOfBook.equals("Khứ hồi"))
		{
			btn_ChieuVe.setVisible(true);
			btn_ChieuDi.setVisible(true);
		}else
		{
			btn_ChieuVe.setVisible(false);
			btn_ChieuDi.setVisible(false);
		}
		
		SetListChoiceRoute(listRoute.get(0));
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		txtNgayDi.setText(listDate.get(0).format(formatter));
		
		txtMap.setText(floydWarshall.getInstance().getMap(listRoute.get(0)));
	
		SetListTrip(listRoute.get(0), listDate.get(0));
	}
	
	public void SetListChoiceRoute(List<Route> list) throws SQLException
	{
		choice_DiemDi.removeAll();
		choice_DiemDen.removeAll();
		
		if(list.size() > 0) {
			String CityID = list.get(0).getCityIDStart();
			String CityName = DAOCity.getInstance().getNameCityByID(CityID);
			choice_DiemDi.add(CityName);
			
			for(int i = 0;i<list.size()-1;i++)
			{
				CityID = list.get(i).getCityIDEnd();
				CityName = DAOCity.getInstance().getNameCityByID(CityID);
				choice_DiemDi.add(CityName);
				choice_DiemDen.add(CityName);
			}
			
			CityID = list.get(list.size()-1).getCityIDEnd();
			CityName = DAOCity.getInstance().getNameCityByID(CityID);
			choice_DiemDen.add(CityName);
			
			choice_DiemDi.select(0);
			choice_DiemDen.select(0);
		}
	}
	
	public void SetListTrip(List<Route> listRoute, LocalDate date) throws SQLException
	{
		if(listRoute.size() == 0)
		{
			JLabel lblCanFind = new JLabel("Không thể tìm thấy chuyến đi phù hợp");
			lblCanFind.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			
			
			panel.setLayout(new BorderLayout());
			panel.setBackground(new Color(255,255,128));
			
			panel.add(lblCanFind, BorderLayout.CENTER);
			return;
		}
		
		String CityNameStart = DAOCity.getInstance().getNameCityByID(listRoute.get(0).getCityIDStart());
		String CityNameEnd = DAOCity.getInstance().getNameCityByID(listRoute.get(0).getCityIDEnd());
		
		try {
			panel = new PanelListTrip(CityNameStart, CityNameEnd, date, CusID, KindOfBook, IC);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public BookingTicket2() 
	{
		this.GUI();
	}
}
