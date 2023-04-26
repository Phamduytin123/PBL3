package Tests;

import java.sql.Date;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import DAO.DAOCustomer;
import Models.Customer;
import DAO.DAOTrip;


public class Test5 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		LocalDate date = LocalDate.of(2023, 04, 14);
//		Date sqlDate = Date.valueOf(date);
//        LocalDate localDate = sqlDate.toLocalDate();
//        System.out.println(localDate);
//        
  //      System.out.println(DAOCustomer.getInstance().selectByID(new Customer("Cus01", null, null, null, null, null, null, null, null)));
		DAOTrip dt = new DAOTrip();
		dt.InsertTrip();
//		Customer temp2 = DAOCustomer.getInstance().selectByID(new Customer("Cus01", null, null, null, null, null, null, null, null));
//		Date temp3 = temp2.getDateOfBirth();
//		System.out.println(temp3.toString());
	}
}
