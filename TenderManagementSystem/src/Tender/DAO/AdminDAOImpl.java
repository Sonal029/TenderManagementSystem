package Tender.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Tender.DTO.Bid;
import Tender.DTO.Tendor;
import Tender.DTO.Vendor;
import Tender.Exception.NoRecordFoundException;
import Tender.Exception.SomethingWentWrongException;

public class AdminDAOImpl implements AdminDAO{

	@Override
	public List<Vendor> getAllVendors() throws SomethingWentWrongException, NoRecordFoundException {
		Connection conn =null;
		List<Vendor> vendors = null;
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
					System.out.println("Vendor Id: "+(rs.getString(1)+", Vendor Description: "+rs.getString(2)+", Username: "+rs.getString(3)+", Password: "+rs.getString(4)));  
					
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new SomethingWentWrongException("Some thing went Wrong");
		} catch (SQLException e) {
			
		}
		finally {
			try {
				Utils.closeConnection(conn);
			}catch(SQLException ex) {
				
			}
		}
		return vendors;
	}
		
	@Override
	public List<Tendor> viewAllTendors() throws SomethingWentWrongException {
		Connection conn =null;
		List<Tendor> tendors = null;
		try {
			conn=Utils.getConnectionTodatabase();
			String query ="SELECT * FROM tendor where status = 'active'";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			if(Utils.isResultSetEmpty(rs)) {
				throw new NoRecordFoundException("Data Not Available");
			}
			else
			{
				while(rs.next())
				{
					System.out.println("Tendor Id: "+(rs.getString(1)+", Tendor Description: "+rs.getString(2)+", Budget: "+rs.getInt(3)+", Tender Date: "+rs.getDate(4)+ ", Status: "+rs.getString(5)));  
					 
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
		finally {
			try {
				Utils.closeConnection(conn);
			}catch(SQLException ex) {
				
			}
		}
		return tendors;
		
	}

	@Override
	public List<Bid> viewBids(String tenderId) throws SomethingWentWrongException {
		Connection conn =null;
		List<Bid> bids = null;
		try {
			conn=Utils.getConnectionTodatabase();
			String query ="SELECT * FROM bid where  tendor_id= ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, tenderId);
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
		return bids;
	}

	@Override
	public void assignTender(String tender_id) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		Connection conn = null;
		
		try {
			conn = Utils.getConnectionTodatabase();
			
			String Q1="SELECT MIN(bid_amount) FROM bid  WHERE tendor_id = ?";
			String Q2= "UPDATE bid SET isDelete = 1  WHERE tendor_id = ? AND bid_amount != ?";
			String query1 = "Select vendor_id from bid WHERE tendor_id = ? AND isDelete = 0 ";
            String query2 ="UPDATE bid SET status = 'rejected' where isDelete = 1";
			
            
            
            PreparedStatement ps = conn.prepareStatement(Q1);
			ps.setString(1, tender_id);
			ResultSet rs = ps.executeQuery();
			if(Utils.isResultSetEmpty(rs)) {
				throw new NoRecordFoundException("Data Not Available");
			}
			rs.next();
			int amount = rs.getInt(1);
			
			
			PreparedStatement ps1 = conn.prepareStatement(Q2);
			ps1.setString(1, tender_id);
			ps1.setInt(2, amount);
			ps1.executeUpdate();
//			System.out.println("Data Updated");
			
			
			PreparedStatement ps3 = conn.prepareStatement(query2);
			ps3.executeUpdate();
			System.out.println("Data Updated");
			
			
			PreparedStatement ps2 = conn.prepareStatement(query1);
			ps2.setString(1, tender_id);
			ResultSet rs1 = ps2.executeQuery();
			if(Utils.isResultSetEmpty(rs1)) 
			{
				throw new NoRecordFoundException("Data Not Available");
			}
			else
			{
				rs1.next();
				System.out.println("The tender has been alloted to  : "+ rs1.getString(1));
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("There is something wrong");
		}
		finally {
			try {
				Utils.closeConnection(conn);
			}catch(SQLException ex) {
				
			}
		}
		
	}
	
	
}