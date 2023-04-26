package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.PanelSitting;
import view.PanelTang1;
import view.PanelTang1Giuong;
import view.PanelTang2;
import view.PanelTang2Giuong;

public class PanelSittingListener implements ActionListener{
	PanelSitting PS;
	public PanelSittingListener(PanelSitting ps) {
		this.PS = ps;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object tmp = e.getSource();
		if(tmp == PS.btn_Tang1 && PS.bus.getKindOfBus().equals("2 tầng"))
		{
			PS.Change_Tang1();
		}
		else if(tmp == PS.btn_Tang2 && PS.bus.getKindOfBus().equals("2 tầng"))
		{
			PS.Change_Tang2();
		}
		else if(tmp == PS.btn_Tang1 && PS.bus.getKindOfBus().equals("Giường nằm"))
		{
			PS.Change_Tang1Giuong();
		}
		else if(tmp == PS.btn_Tang2 && PS.bus.getKindOfBus().equals("Giường nằm"))
		{
			PS.Change_Tang2Giuong();
		}
		if(e.getActionCommand().equals("Xác nhận"))
		{
			if(PS.fbt.BuocTruocDo == 4)
				PS.fbt.Buoc2Sang4();
			else
				PS.fbt.Buoc2Sang3(); 
		}
		else if(e.getActionCommand().equals("Quay lại"))
		{
			PS.fbt.Buoc2Lui1();
		}
		
	}
}
