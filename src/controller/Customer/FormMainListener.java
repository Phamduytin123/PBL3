package controller.Customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import view.Customer.BookingTicket1;
import view.Customer.BookingTicket2;
import view.Customer.FormMainPage;
import view.Customer.PanelUser;
import view.Login.FormLogin;

public class FormMainListener implements ActionListener, MouseListener{
	private FormMainPage formMain;
		
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
		} else
		if (tmp == formMain.btnBookTicket) {
			formMain.changeToBooking();
		} else
		if (tmp == formMain.btnBill) {
			formMain.changeToBill();
		} else
		if (tmp == formMain.bookingTicket1Panel.btnViewTicket) {
			String DateGo = formMain.bookingTicket1Panel.txtNgayDi.getText();
			String DateBack = formMain.bookingTicket1Panel.txtNgayVe.getText();
			String KindOfBook = formMain.bookingTicket1Panel.KindOfBook;
			
			if(formMain.bookingTicket1Panel.listRoute.get(0).size() == 0)
			{
				JOptionPane.showMessageDialog(null, "Vui lòng tìm kiếm chuyến đi phù hợp trước");
				return;
			}
			
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
			
			formMain.bookingTicket1Panel.listDate = new ArrayList<>();	
				
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			formMain.bookingTicket1Panel.listDate.add(LocalDate.parse(DateGo, formatter));	
			
			LocalDate DateGo1 = formMain.bookingTicket1Panel.listDate.get(0);
			
			if(LocalDate.now().compareTo(DateGo1) > 0)
			{
				JOptionPane.showMessageDialog(null, "Không thể nhập ngày đi nhỏ hơn ngày hiện tại");
				System.out.println(DateGo1.toString() + " - " + LocalDate.now());
				return;
			}
			
			if(KindOfBook.equals("Khứ hồi"))
			{
				formMain.bookingTicket1Panel.listDate.add(LocalDate.parse(DateBack, formatter));		
				List<LocalDate> listDate = formMain.bookingTicket1Panel.listDate;
				
				if(listDate.get(1).compareTo(listDate.get(0)) < 0)
				{
					JOptionPane.showMessageDialog(null, "Ngày về không thể nhỏ hơn ngày đi");
					return;
				}
			}
			
			
			formMain.bookingTicket1Panel.CusID = formMain.cus.getCustomerID();
			try {
				formMain.changeToListTicket();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(tmp == formMain.btnLogOut)
		{
			formMain.dispose();
			new FormLogin();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	
		if(e.getComponent() == formMain.bookingTicket2Panel.lblBack )
		{
			formMain.changeToBooking();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
