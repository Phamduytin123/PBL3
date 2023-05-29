package Tests;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.DateFormatter;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.CombinedDomainCategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.AreaRenderer;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import Algorithm.floydWarshall2;
import BUS.JDBCUtil;
import DAO.DAOBill;
import DAO.DAOBus;
import DAO.DAOCity;
import DAO.DAOCustomer;
import DAO.DAOInfoCustomer;
import DAO.DAORoute;
import DAO.DAOTrip;
import Models.Bill;
import Models.Bus;
import Models.City;
import Models.Customer;
import Models.InfoCustomer;
import Models.Route;
import Models.Trip;

public class Test1 {
	public static void main(String[] args) {
		// Tạo dữ liệu cho biểu đồ
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(100, "Series 1", "Category 1");
        dataset.addValue(200, "Series 1", "Category 2");
        dataset.addValue(300, "Series 1", "Category 3");
        dataset.addValue(150, "Series 2", "Category 1");
        dataset.addValue(250, "Series 2", "Category 2");
        dataset.addValue(350, "Series 2", "Category 3");

        // Tạo biểu đồ cột
        CategoryPlot barPlot = new CategoryPlot();
        BarRenderer barRenderer = new BarRenderer();
        barPlot.setDataset(dataset);
        barPlot.setRenderer(barRenderer);
        barPlot.setRangeAxis(new NumberAxis("Value")); // Thiết lập trục giá trị

        // Tạo biểu đồ miền
        CategoryPlot areaPlot = new CategoryPlot();
        BarRenderer areaRenderer = new BarRenderer();
        areaPlot.setDataset(dataset);
        areaPlot.setRenderer(areaRenderer);
        areaPlot.setRangeAxis(new NumberAxis("Value")); // Thiết lập trục giá trị

        // Tạo CombinedDomainCategoryPlot và thêm cả hai plot vào
        CombinedDomainCategoryPlot combinedPlot = new CombinedDomainCategoryPlot();
        combinedPlot.add(barPlot);
        combinedPlot.add(areaPlot);

        // Tạo JFreeChart từ CombinedDomainCategoryPlot
        JFreeChart chart = new JFreeChart("Combined Chart", JFreeChart.DEFAULT_TITLE_FONT, combinedPlot, true);

        // Hiển thị biểu đồ trong cửa sổ
        ChartFrame frame = new ChartFrame("Chart", chart);
        frame.pack();
        frame.setVisible(true);
	}
}
