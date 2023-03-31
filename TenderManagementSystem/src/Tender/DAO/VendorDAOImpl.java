package Tender.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Tender.DTO.Bid;
import Tender.DTO.tendor;
import Tender.DTO.tendorImpl;
import Tender.DTO.vendor;
import Tender.Exception.NoRecordFoundException;
import Tender.Exception.SomethingWentWrongException;
import Tender.UI.VendorUI;

public class VendorDAOImpl implements VendorDAO
{
	@Override
	public void vendorRegistration(vendor v) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try
		{
			conn = Utils.getConnectionTodatabase();
			 String query = "Insert into vendor values(?,?,?,?)";
			 PreparedStatement ps = conn.prepareStatement(query);
			 
			ps.setString(1, v.getId()); 
			ps.setString(2, v.getName());
			ps.setString(3, v.getUsername());
			ps.setString(4, v.getPassword());
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

	@Override
	public boolean vendorAuthentication(String user, String pass) {
		// TODO Auto-generated method stub
		Connection conn = null;
		boolean flag= false;
		try
		{
			conn = Utils.getConnectionTodatabase();
			String query = "Select password from vendor where username =?";
			PreparedStatement ps = conn.prepareStatement(query);
			 
			ps.setString(1, user); 
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				String password = rs.getString(1);
                if(password.equals(pass))
                {
                	flag= true;
                }
                else 
                {
                	flag= false;
                }
			}
			
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
		return flag;
	}

	@Override
	public List<tendor> viewAllCurrentTenders() throws SomethingWentWrongException {
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
					throw new NoRecordFoundException("No tendor found");
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
	public void placeBid(Bid b) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Connection conn = null;
				try
				{
					conn = Utils.getConnectionTodatabase();
					 String query = "Insert into bid values(?,?,?,?)";
					 PreparedStatement ps = conn.prepareStatement(query);
					 
					ps.setString(1, b.getTendorId()); 
					ps.setString(2, b.getVendorId());
					ps.setInt(3, b.getBidAmount());
					ps.setDate(4, Date.valueOf(b.getBidDate()));
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
    
