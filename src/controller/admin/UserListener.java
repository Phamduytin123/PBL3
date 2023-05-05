package controller.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import view.admin.PanelUserAd;

public class UserListener implements ActionListener, ListSelectionListener{

	private PanelUserAd panelUserAd;
	public UserListener(PanelUserAd panelUserAd) {
		super();
		this.panelUserAd = panelUserAd;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		if (! e.getValueIsAdjusting()) {
			int indexRow = panelUserAd.getTable().getSelectedRow();
			panelUserAd.SetTextInfor(indexRow);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object tmp = e.getSource();
		String t = e.getActionCommand();
		if (t.equals("Thêm")) {
			panelUserAd.PressAdd();
		} else
		if (tmp == panelUserAd.getBtnAdd()) {
			if (t.equals("Lưu")) {
				panelUserAd.PressSaveAdd();
			}
		} else
		if (tmp == panelUserAd.getBtnCancel()) {
			panelUserAd.PressCancel();
		} else
		if (tmp == panelUserAd.getBtnDelete()) {
			panelUserAd.PressDelete();
		} else
		if (t.equals("Sửa")) {
			panelUserAd.PressUpdate();
		} else
		if (tmp == panelUserAd.getBtnUpdate()) {
			if (t.equals("Lưu")) {
				panelUserAd.PressSaveUpdate();
			}
		}
	}

}
