package Tender.DAO;

import java.sql.SQLException;
import java.util.List;

import Tender.DTO.Bid;
import Tender.DTO.Tendor;
import Tender.DTO.Vendor;
import Tender.Exception.NoRecordFoundException;
import Tender.Exception.SomethingWentWrongException;

public interface AdminDAO 
{
	public List<Vendor> getAllVendors() throws SomethingWentWrongException, NoRecordFoundException;

	public List<Tendor> viewAllTendors() throws NoRecordFoundException,SomethingWentWrongException;
    
	public List<Bid> viewBids(String tenderId) throws SomethingWentWrongException;
     
	public void assignTender(String tender_id) throws SomethingWentWrongException, NoRecordFoundException;
	
	
}
