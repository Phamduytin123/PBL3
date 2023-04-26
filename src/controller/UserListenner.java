package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DAO.DAOCustomer;
import view.PanelUser;

public class UserListenner implements ActionListener {
	
	PanelUser panelUser;
	DAO.DAOCustomer customer = DAO.DAOCustomer.getInstance();
	
	public void setName(String name) {
//		panelUser.jtxtName.setText(customer.selectByID("001").get);
	}
	
	
	
	
	public UserListenner(PanelUser panelUser) {
		this.panelUser = panelUser;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object tmp = e.getSource();
		if (tmp == panelUser.btnUpdate) {
			panelUser.txtDateOfBirths.setText("cc");
		}
	}

}
