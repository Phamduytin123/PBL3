package controller.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import view.admin.PanelStatisticAll;

public class StatisticAllListener implements ActionListener{
	PanelStatisticAll gd;
	
	public StatisticAllListener(PanelStatisticAll gd) {
		this.gd = gd;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == gd.cbTop)
		{
			try {
				gd.cbTop_picked();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
