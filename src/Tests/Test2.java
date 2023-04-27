package Tests;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import DAO.DAOBus;
import DAO.DAOCity;
import DAO.DAOCustomer;
import DAO.DAORoute;
import DAO.DAOTrip;
import Models.Bus;
import Models.City;
import Models.Customer;
import Models.myDate;
import view.Login.FormLogin;

public class Test2 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		LocalDate temp = LocalDate.of(2023, 04, 24);
		System.out.println(LocalDate.now().compareTo(temp));
	
	}
}
