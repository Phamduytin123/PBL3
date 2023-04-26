package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import view.BookingTicket1;
import view.BookingTicket2;
import view.FormMainPage;
import view.PanelUser;

public class FormMainListener implements ActionListener{
	private FormMainPage formMain;
	private UserListenner userListener = new UserListenner((PanelUser)FormMainPage.userPanel);
	private BookingTicket1Listener bookingTicket1Listenner = new BookingTicket1Listener((BookingTicket1)FormMainPage.bookingTicket1Panel);
	private BookingTicket2Listener bookingTicket2Listenner = new BookingTicket2Listener((BookingTicket2)FormMainPage.bookingTicket2Panel);
	
	
	
	public FormMainListener(FormMainPage formMain) {
		// TODO Auto-generated constructor stub
		this.formMain = formMain;
	}
			
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object tmp = e.getSource();
		if (tmp == formMain.btnAcc) {
			formMain.changeToAcc();
			userListener.setName("abcd");
		} else
		if (tmp == formMain.btnBookTicket) {
			formMain.changeToBooking();
		} else
		if (tmp == formMain.btnBill) {
			formMain.changeToBill();
		} else
		if (tmp == ((BookingTicket1)FormMainPage.bookingTicket1Panel).btnViewTicket) {
			String DateGo = ((BookingTicket1)FormMainPage.bookingTicket1Panel).txtNgayDi.getText();
			String DateBack = ((BookingTicket1)FormMainPage.bookingTicket1Panel).txtNgayVe.getText();
			String KindOfBook = ((BookingTicket1)FormMainPage.bookingTicket1Panel).KindOfBook;
			
			if(DateGo.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ ngày");
				return;
			}
			if(KindOfBook.equals("Khứ hồi") && DateBack.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ ngày");
				return;
			}
			
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			((BookingTicket1)FormMainPage.bookingTicket1Panel).listDate.add(LocalDate.parse(DateGo, formatter));	
			if(KindOfBook.equals("Khứ hồi"))
			{
				((BookingTicket1)FormMainPage.bookingTicket1Panel).listDate.add(LocalDate.parse(DateBack, formatter));		
			}
			
			
			((BookingTicket1)FormMainPage.bookingTicket1Panel).CusID = formMain.cus.getCustomerID();
			try {
				formMain.changeToListTicket();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
//	public void changeToListTicket() {
//		if (formMain == null) {
//			formMain = FormMainPage.FORM_MAIN_PAGE;
//		}
//		formMain.changeToListTicket();
//	}
}
