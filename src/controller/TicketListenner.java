package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.PanelTrip;

public class TicketListenner implements ActionListener{
	PanelTrip panelTrip;
	
	public TicketListenner(PanelTrip panelTrip) {
		this.panelTrip = panelTrip;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object t = e.getSource();
			
		if (t == panelTrip.btnSelect) {
			
		}
	}

}
