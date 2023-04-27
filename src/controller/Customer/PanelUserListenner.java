package controller.Customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DAO.DAOCustomer;
import view.Customer.PanelUser;

public class PanelUserListenner implements ActionListener {
	
	PanelUser panelUser;
	DAO.DAOCustomer customer = DAO.DAOCustomer.getInstance();
	
	public void setName(String name) {
//		panelUser.jtxtName.setText(customer.selectByID("001").get);
	}
	

	
	public PanelUserListenner(PanelUser panelUser) {
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
