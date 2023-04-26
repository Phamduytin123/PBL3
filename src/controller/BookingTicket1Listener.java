package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Algorithm.floydWarshall;
import DAO.DAOCity;
import DAO.DAORoute;
import Models.Route;
import view.BookingTicket1;

public class BookingTicket1Listener implements ActionListener{
	private BookingTicket1 BT1;
	
	
	public BookingTicket1Listener(BookingTicket1 BT1) {
		this.BT1 = BT1;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object tmp = e.getSource();
		
		if(tmp == BT1.btn_ChieuDi)
		{
			String diemDi = BT1.choice_DiemDi.getSelectedItem().toString();
			String diemDen = BT1.choice_DiemDen.getSelectedItem().toString();
			
			try {
				BT1.SetData(BT1.listRoute.get(0), diemDi, diemDen);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(tmp == BT1.btn_ChieuVe)
		{
			String diemDi = BT1.choice_DiemDi.getSelectedItem().toString();
			String diemDen = BT1.choice_DiemDen.getSelectedItem().toString();
			
			try {
				BT1.SetData(BT1.listRoute.get(1), diemDen, diemDi);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		else if(tmp == BT1.btnSearch)
		{
			if(BT1.rdbtnRoundTrip.isSelected())
			{
				BT1.KindOfBook = "Khứ hồi";
				BT1.btn_ChieuDi.setVisible(true);
				BT1.btn_ChieuVe.setVisible(true);
			}
			
			String diemDi = BT1.choice_DiemDi.getSelectedItem().toString();
			String diemDen = BT1.choice_DiemDen.getSelectedItem().toString();
			
			if(diemDi.equals(diemDen))
			{
				JOptionPane.showMessageDialog(null, "Điểm đi không thể trùng điểm đến");
				return;
			}
			
			String LuaChon = BT1.choice_TieuChi.getSelectedItem().toString();
			
			if(LuaChon.equals("Ngắn nhất"))
			{
				BT1.Fast(BT1.rdbtnRoundTrip.isSelected());
			}
			else if(LuaChon.equals("Rẻ nhất"))
			{
				BT1.Cheap(BT1.rdbtnRoundTrip.isSelected());
			}
			else if(LuaChon.equals("Ngồi xe ít nhất"))
			{
				BT1.TimeLess(BT1.rdbtnRoundTrip.isSelected());
			}
			
			try {
				BT1.SetData(BT1.listRoute.get(0),diemDi, diemDen);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		else if(BT1.rdbtnRoundTrip.isSelected())
		{
			BT1.KindOfBook = "Khứ hồi";
			BT1.txtNgayVe.setEditable(true);
		}
		else if(BT1.rdbtnOneTrip.isSelected())
		{
			BT1.KindOfBook = "Một chiều";
			BT1.btn_ChieuDi.setVisible(false);
			BT1.btn_ChieuVe.setVisible(false);
			BT1.txtNgayVe.setEditable(false);
		}
		
	}

}
