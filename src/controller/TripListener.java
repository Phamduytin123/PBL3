package controller;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import view.FormBookTicket;
import view.PanelTrip;

public class TripListener implements ActionListener{

	PanelTrip PT;
	
	public TripListener(PanelTrip PT) {
		this.PT = PT;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object tmp = e.getSource();
		if(tmp == PT.btnSelect)
		{
			try {
				new FormBookTicket(PT.trip, PT.IC, PT.CusID, PT.KindOfBook);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
