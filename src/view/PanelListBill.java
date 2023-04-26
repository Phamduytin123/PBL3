package view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

public class PanelListBill extends JPanel {

	/**
	 * Create the panel.
	 */
	private int numBill = 0;
	public List<JPanel> listPanel = new  ArrayList<>();
	public JPanel panel = new JPanel();

	public void GUI()
	{
		this.setBackground(new Color(255, 255, 255));
		this.setBounds(0, 127, 529, 371);
		this.setLayout(null);
		
		panel.setBorder(new LineBorder(new Color(130, 135, 144), 1, true));
		panel.setBounds(167, 127, 529, 371);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			
		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 0, 519, 360);
		add(scrollPane);
	}

	public void Init()
	{
		for (int i = 0; i<numBill; i++) {
			listPanel.add(new PanelBill());
		}
		
		for (int i = 0; i<numBill; i++) {
			listPanel.get(i).setPreferredSize(new Dimension(20,130));
			panel.add(listPanel.get(i));
		}
	}
	
	public PanelListBill(int num ) {
		this.numBill = num;
		this.GUI();
		this.Init();
	}
}
