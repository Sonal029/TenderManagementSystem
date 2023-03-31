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
	                System.out.println("Tendor Id: "+(resultSet.getString(1)+", Tendor Description: "+resultSet.getString(2)+", Budget: "+resultSet.getInt(3)+", Tendor Date: "+ resultSet.getDate(4)+ ", Status: "+resultSet.getString(5)));  
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
		
				Connection conn = null;
				try
				{
					conn = Utils.getConnectionTodatabase();
					 String query = "Insert into bid values(?,?,?,?,?)";
					 PreparedStatement ps = conn.prepareStatement(query);
					 
					ps.setString(1, b.getTendorId()); 
					ps.setString(2, b.getVendorId());
					ps.setInt(3, b.getBidAmount());
					ps.setDate(4, Date.valueOf(b.getBidDate()));
					ps.setString(5, b.getStatus());
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
	public void viewBidHistory(String vendor_id) throws SomethingWentWrongException {
		Connection conn =null;
		List<Bid> bids = null;
		try {
			conn=Utils.getConnectionTodatabase();
			String query ="SELECT * FROM bid where  vendor_id= ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, vendor_id);
			ResultSet rs = ps.executeQuery();
			if(Utils.isResultSetEmpty(rs)) {
				throw new NoRecordFoundException("Data Not Available");
			}
			else
			{
				while(rs.next())
				{
					System.out.println("Tendor id: "+rs.getString(1)+", Vendor id: "+rs.getString(2)+", Bidding Amount: "+rs.getInt(3)+", Bidding Date: "+rs.getDate(4)+", Status: "+rs.getString(5));
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new SomethingWentWrongException("Some thing went Wrong");
		} catch (SQLException e) {
			
		} catch (NoRecordFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
    
