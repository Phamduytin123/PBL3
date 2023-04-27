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
//	    JFrame frame = new JFrame("JCalendar Example");
//	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	    
//	    JPanel panel = new JPanel();
//	    panel.setLayout(new BorderLayout());
//	    
//	    JLabel label = new JLabel("Selected Date: ");
//	    panel.add(label, BorderLayout.NORTH);
//	    
//	    JCalendar calendar = new JCalendar();
//	    panel.add(calendar, BorderLayout.CENTER);
//	    
//	    calendar.addPropertyChangeListener(event -> {
//	      if ("calendar".equals(event.getPropertyName())) {
//	        Calendar selectedDate = (Calendar) event.getNewValue();
//	        label.setText("Selected Date: " + selectedDate.getTime());
//	      }
//	    });
//	    
//	    frame.getContentPane().add(panel);
//	    frame.pack();
//	    frame.setVisible(true);
	  }
}
