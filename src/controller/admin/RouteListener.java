
package controller.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import view.admin.PanelRouteAd;

public class RouteListener implements ActionListener, ListSelectionListener{

	private PanelRouteAd pnRouteAd;
	public RouteListener(PanelRouteAd pnRouteAd) {
		super();
		this.pnRouteAd = pnRouteAd;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object tmp = e.getSource();
		String t = e.getActionCommand();
		if (tmp == pnRouteAd.getBtnAdd()) {
			pnRouteAd.PressAdd();
			if (t.equals("Lưu")) {
				System.out.println("1");
				pnRouteAd.getBtnAdd().setText("Thêm");
				pnRouteAd.getBtnDelete().setEnabled(true);
				pnRouteAd.getBtnUpdate().setEnabled(true);
			}
		} else
		if (tmp == pnRouteAd.getBtnCancel()) {
			pnRouteAd.PressCancel();
		}
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		if (! e.getValueIsAdjusting()) {
			int indexRow = pnRouteAd.getTable().getSelectedRow();
			pnRouteAd.SetTextInFor(indexRow);
		}
	}

}