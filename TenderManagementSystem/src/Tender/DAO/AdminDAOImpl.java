package Tender.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Tender.DTO.Bid;
import Tender.DTO.tendor;
import Tender.DTO.tendorImpl;
import Tender.DTO.vendor;
import Tender.DTO.vendorImpl;
import Tender.Exception.NoRecordFoundException;
import Tender.Exception.SomethingWentWrongException;

public class AdminDAOImpl implements AdminDAO{

	@Override
	public List<vendor> getAllVendors() throws SomethingWentWrongException, NoRecordFoundException {
		Connection conn =null;
		List<vendor> vendors = null;
		try {
			conn=Utils.getConnectionTodatabase();
			String query ="Select * from vendor";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			if(Utils.isResultSetEmpty(rs)) {
				throw new NoRecordFoundException("Data Not Available");
			}
			else
			{
				while(rs.next())
				{
					System.out.println(rs.getString(1));
					System.out.println(rs.getString(2));
					System.out.println(rs.getString(3));
					System.out.println(rs.getString(4));
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new SomethingWentWrongException("Some thing went Wrong");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vendors;
	}
		
			
	@Override
	public List<tendor> viewAllTendors() throws SomethingWentWrongException {
		Connection conn =null;
		List<tendor> tendors = null;
		try {
				//connect to database
				conn = Utils.getConnectionTodatabase();
				//prepare the query
				String QUERY = "SELECT * FROM tendor where status = 'active'";
				
				//get the prepared statement object
				PreparedStatement ps = conn.prepareStatement(QUERY);
				
				//execute query
				ResultSet resultSet = ps.executeQuery();
				if(Utils.isResultSetEmpty(resultSet)) {
					throw new NoRecordFoundException("No vendor found");
				}
				while (resultSet.next()) 
				{
	                tendors.add(new tendorImpl(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3),resultSet.getString(4)));  
				}
				
		}
		catch(SQLException | ClassNotFoundException | NoRecordFoundException sqlEx) {
			//code to log the error in the file
			throw new SomethingWentWrongException("No data found");
		}
		finally 
		{
			try 
			{
				//close the exception
			  Utils.closeConnection(conn);				
			}
			catch(SQLException sqlEX) 
			{
				
			}
		}
		return tendors;
		
	}

	@Override
	public List<Bid> viewBids(String tenderId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}