package Tender.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Tender.DTO.tendor;

public class TenderDAOImpl implements TenderDAO
{

	@Override
	public void createNewTender(tendor t) {
		// TODO Auto-generated method stub
		Connection conn =null;
		try
		{
			Utils.getConnectionTodatabase();
			String query = "Insert into tendor values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			 
			ps.setString(1, t.getTendor_id()); 
			ps.setString(2, t.getTendor_desc());
			ps.setInt(3, t.getTendor_budget());
			ps.setString(4, t.getStatus());
			ps.executeUpdate();
		}
		
		catch(SQLException | ClassNotFoundException ex)
		{
			System.out.println(ex);
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
    
