package view.Test;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.data.general.DefaultPieDataset;

import view.Customer.PanelFindTrip;
import view.Customer.PanelFindTripTop;
import java.awt.GridLayout;

public class Test extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Test() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Category 1", 30);
		dataset.setValue("Category 2", 20);
		dataset.setValue("Category 3", 50);
		
		JFreeChart chart = ChartFactory.createPieChart("Pie Chart", dataset, false, true, false);
		
		// Thiết lập font chữ cho biểu đồ
        StandardChartTheme chartTheme = (StandardChartTheme) StandardChartTheme.createJFreeTheme();
        chartTheme.setExtraLargeFont(new Font("Times New Roman", Font.BOLD, 18));
        chartTheme.setLargeFont(new Font("Times New Roman", Font.BOLD, 14));
        chartTheme.setRegularFont(new Font("Times New Roman", Font.PLAIN, 12));
        chartTheme.setSmallFont(new Font("Times New Roman", Font.PLAIN, 10));

        // Áp dụng theme đã thiết lập cho biểu đồ
        chartTheme.apply(chart);
		
		ChartPanel frame = new ChartPanel(chart);
		frame.setVisible(true);
		contentPane.setLayout(new GridLayout(1,1));
		
		contentPane.add(frame);
	}
}
