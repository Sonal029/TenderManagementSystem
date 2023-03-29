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

public class AdminDAOImpl implements AdminDAO {

	@Override
	public List<vendor> getAllVendors() throws SomethingWentWrongException {
		
		// TODO Auto-generated method stub
		Connection conn =null;
		List<vendor> vendors = null;
		try {
				//connect to database
				conn = Utils.getConnectionTodatabase();
				//prepare the query
				String QUERY = "SELECT * FROM vendor";
				
				//get the prepared statement object
				PreparedStatement ps = conn.prepareStatement(QUERY);
				
				//execute query
				ResultSet resultSet = ps.executeQuery();
				if(Utils.isResultSetEmpty(resultSet)) {
					throw new NoRecordFoundException("No vendor found");
				}
				while (resultSet.next()) 
				{
	                vendors.add(new vendorImpl(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),resultSet.getString(4)));  
				}
				
		}
		catch(SQLException | ClassNotFoundException | NoRecordFoundException sqlEx) {
			//code to log the error in the file
			throw new SomethingWentWrongException();
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
				throw new SomethingWentWrongException();
			}
		}
		return vendors;
	}

	
	public List<Bid> viewBids(String tenderId) {
		
		List<Bid> bid = null;
            Connection connection=null;
			try {
				connection = Utils.getConnectionTodatabase();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            String sql = "SELECT * FROM bids b inner join tendor t on b.tendor_id = t.tendor_id where b.tendor_id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,tenderId);
            ResultSet result = statement.executeQuery();
            if(Utils.isResultSetEmpty(result)) 
            {
				throw new NoRecordFoundException("No bid found");
			}
			while (result.next()) 
			{
                bid.add(new BidImpl(result.getString(1), result.getString(2), result.getInt(3),result.getDate(4)));  
			}
	catch(SQLException | ClassNotFoundException | NoRecordFoundException sqlEx) {
		//code to log the error in the file
		throw new SomethingWentWrongException("There is something wrong");
	}
	finally 
	{
		try 
		{
			//close the exception
		  Utils.closeConnection(connection);				
		}
		catch(SQLException sqlEX) 
		{
			throw new SomethingWentWrongException();
		}
     }
			
	
}

		

