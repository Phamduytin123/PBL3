package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.BookingTicket2;

public class BookingTicket2Listener implements ActionListener, MouseListener {
	private BookingTicket2 bookingTicket2;
	
	public BookingTicket2Listener (BookingTicket2 bookingTicket2) {
		this.bookingTicket2 = bookingTicket2;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
	
		if(e.getComponent() == bookingTicket2.lblSearch)
		{
			System.out.println("Search");
		}
		else if(e.getComponent() == bookingTicket2.lblBack)
		{
			System.out.println("Back");
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
