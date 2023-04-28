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
		Object[] temp = DAOTrip.getInstance().getInfoPanelTrip(406);
		System.out.println(temp[0] + "-" + temp[1] + "-" + temp[2] + "-" + temp[3] + "-" + temp[4]);
	}
}
