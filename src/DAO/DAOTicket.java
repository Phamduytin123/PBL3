package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import BUS.JDBCUtil;
import Models.Bus;
import Models.Ticket;

public class DAOTicket implements DAOInterface<Ticket,Integer>{

	public static DAOTicket getInstance()
	{
		return new DAOTicket();
	}
	
	@Override
	public int insert(Ticket t) throws SQLException, ClassNotFoundException {
		
		Connection con = JDBCUtil.getConnection();
		
		String command = "INSERT INTO Ticket (BillID, SeatNumber, KindOfTicket, Price, TripID) VALUES (?,?,?,?,?)";
		PreparedStatement psm = con.prepareStatement(command);
		
		psm.setInt(1, t.getBillID());
		psm.setString(2, t.getSeatNumber());
		psm.setString(3, t.getKindOfTicket());
		psm.setString(4, t.getPrice()+"");
		psm.setInt(5, t.getTripID());
		
		int executedRow = psm.executeUpdate(); 
		
		psm.close();
		
		JDBCUtil.closeConnection(con);
		return executedRow;
	}

	@Override
	public int delete(Integer t) throws SQLException, ClassNotFoundException {
		
		Connection con = JDBCUtil.getConnection();
		
		String command = "DELETE FROM Ticket WHERE TicketID = ?";
		PreparedStatement psm = con.prepareStatement(command);
		
		psm.setInt(1, t);
		
		int executedRow = psm.executeUpdate(); 
		
		psm.close();
		
		JDBCUtil.closeConnection(con);
		return executedRow;
	}

	@Override
	public int update(Ticket t) throws SQLException, ClassNotFoundException {
		
		Connection con = JDBCUtil.getConnection();
		
		String command = "UPDATE Ticket SET BillID = ?, SeatNumber = ?, KindOfTicket = ?, Price = ?, TripID = ? WHERE TicketID = ?";
		PreparedStatement psm = con.prepareStatement(command);
			
		psm.setInt(6, t.getTicketID());
		psm.setInt(1, t.getBillID());
		psm.setString(2, t.getSeatNumber());
		psm.setString(3, t.getKindOfTicket());
		psm.setString(4, t.getPrice()+"");
		psm.setInt(5, t.getTripID());
		
		int executedRow = psm.executeUpdate(); 
		
		psm.close();
		
		JDBCUtil.closeConnection(con);
		return executedRow;
	}

	@Override
	public ArrayList<Ticket> selectAll() throws SQLException, ClassNotFoundException {
		
		Connection Conn = JDBCUtil.getConnection(); 
		List<Ticket> list = new ArrayList<>();
		
		//Bước 3 : Thực hiện câu lệnh truy vấn 
		Statement stmt = Conn.createStatement();
		String sqlCommand = "SELECT * FROM Ticket";
		ResultSet rs = stmt.executeQuery(sqlCommand); 
		
		//Bước 4 : Xem thong tin cua bang
		while(rs.next())
		{
			int TicketID = rs.getInt("TicketID");
			int BillID = rs.getInt("BillID");
			String SeatNumber = rs.getString("SeatNumber");
			String KindOfTicket = rs.getString("KindOfTicket");
			int Price = Integer.parseInt(rs.getString("Price"));
			int TripID = rs.getInt("TripID");
			
			Ticket temp = new Ticket(TicketID, BillID, SeatNumber, KindOfTicket, Price, TripID);
			list.add(temp);
		}
		
		rs.close();
		stmt.close();
		
		JDBCUtil.closeConnection(Conn);
		return (ArrayList<Ticket>) list;
	}

	@Override
	public Ticket selectByID(String t) throws SQLException, ClassNotFoundException {
		Connection Conn = JDBCUtil.getConnection(); 
		
		String SqlCommand = "SELECT * FROM Ticket WHERE TicketID = ?";
		PreparedStatement psm = Conn.prepareStatement(SqlCommand);
		
		psm.setInt(1, Integer.parseInt(t));
		
		ResultSet rs = psm.executeQuery();
		
		Ticket result = new Ticket(0, 0, "", "", 0, 0);
		
		if(rs.next())
		{
			int TicketID = rs.getInt("TicketID");
			int BillID = rs.getInt("BillID");
			String SeatNumber = rs.getString("SeatNumber");
			String KindOfTicket = rs.getString("KindOfTicket");
			int Price = Integer.parseInt(rs.getString("Price"));
			int TripID = rs.getInt("TripID");
			
			result = new Ticket(TicketID, BillID, SeatNumber, KindOfTicket, Price, TripID);
		}
		
		rs.close();
		psm.close();
		JDBCUtil.closeConnection(Conn);
		return result;
	}
	
	@Override
	public ArrayList<Ticket> selectByCondition(String condition) throws SQLException, ClassNotFoundException {
		Connection Conn = JDBCUtil.getConnection(); 
		
		ArrayList<Ticket> list = new ArrayList<>();
		
		Statement stmt = Conn.createStatement();
		String command = "SELECT * FROM Ticket WHERE " + condition;
		ResultSet rs = stmt.executeQuery(command);
		
		while(rs.next())
		{
			int TicketID = rs.getInt("TicketID");
			int BillID = rs.getInt("BillID");
			String SeatNumber = rs.getString("SeatNumber");
			String KindOfTicket = rs.getString("KindOfTicket");
			int Price = Integer.parseInt(rs.getString("Price"));
			int TripID = rs.getInt("TripID");
			
			Ticket temp = new Ticket(TicketID, BillID, SeatNumber, KindOfTicket, Price, TripID);
			list.add(temp);
		}

		rs.close();
		stmt.close();
		JDBCUtil.closeConnection(Conn);
		return list;
	}

	public ArrayList<Ticket> selectByBillID(int BillID1) throws SQLException, ClassNotFoundException {
		Connection Conn = JDBCUtil.getConnection(); 
		
		ArrayList<Ticket> list = new ArrayList<>();
		
		String command = "SELECT * FROM Ticket WHERE BillID = ?" ;
		PreparedStatement psm = Conn.prepareStatement(command);
		
		psm.setInt(1, BillID1);
		
		ResultSet rs = psm.executeQuery();
		
		while(rs.next())
		{
			int TicketID = rs.getInt("TicketID");
			int BillID = rs.getInt("BillID");
			String SeatNumber = rs.getString("SeatNumber");
			String KindOfTicket = rs.getString("KindOfTicket");
			int Price = Integer.parseInt(rs.getString("Price"));
			int TripID = rs.getInt("TripID");
			
			Ticket temp = new Ticket(TicketID, BillID, SeatNumber, KindOfTicket, Price, TripID);
			list.add(temp);
		}

		rs.close();
		psm.close();
		JDBCUtil.closeConnection(Conn);
		return list;
	}
	
	public ArrayList<Ticket> getBusySeat(int TripID1) throws SQLException
	{
		List<Ticket> list = new ArrayList<>();
		
		Connection con = JDBCUtil.getConnection();
		Statement st = con.createStatement();
		String command = "SELECT T.* FROM Ticket AS T \r\n"
				+ "JOIN TripInDay AS TID ON TID.TripID = T.TripID\r\n"
				+ "JOIN Bill AS B ON B.billID = T.BillID\r\n"
				+ "WHERE TID.TripID = " + TripID1 + "\r\n"
				+ "AND B.Status1 <> N'Đã từ chối'" ;
		
		ResultSet rs = st.executeQuery(command);
		while(rs.next())
		{

			int TicketID = rs.getInt("TicketID");
			int BillID = rs.getInt("BillID");
			String SeatNumber = rs.getString("SeatNumber");
			String KindOfTicket = rs.getString("KindOfTicket");
			int Price = Integer.parseInt(rs.getString("Price"));
			int TripID = rs.getInt("TripID");
			
			Ticket temp = new Ticket(TicketID, BillID, SeatNumber, KindOfTicket, Price, TripID);
			list.add(temp);
		}
		rs.close();
		st.close();
		JDBCUtil.closeConnection(con);
		return (ArrayList<Ticket>) list;
	}
	
}
