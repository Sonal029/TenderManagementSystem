package Tender.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Tender.DTO.tendor;
import Tender.Exception.SomethingWentWrongException;

public class TenderDAOImpl implements TenderDAO
{

	@Override
	public void createNewTender(tendor t) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		Connection conn =null;
		try
		{
		    conn= Utils.getConnectionTodatabase();
			String query = "Insert into tendor values(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			 
			ps.setString(1, t.getTendor_id()); 
			ps.setString(2, t.getTendor_desc());
			ps.setInt(3, t.getTendor_budget());
			ps.setDate(4, Date.valueOf(t.getTendor_date()));
			ps.setString(5, t.getStatus());
			ps.executeUpdate();
		
		}
		
		catch(SQLException | ClassNotFoundException ex)
		{
			throw new SomethingWentWrongException("Something is wrong");
		}
		finally
		{
			try {
				Utils.closeConnection(conn);
			}catch(SQLException ex) {
				
			}
		}
	}
				
}
    
