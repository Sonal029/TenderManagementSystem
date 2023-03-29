package Tender.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Tender.DTO.vendor;
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
    
}
