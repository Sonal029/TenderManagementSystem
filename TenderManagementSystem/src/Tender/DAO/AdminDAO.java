package Tender.DAO;

import java.sql.SQLException;
import java.util.List;

import Tender.DTO.Bid;
import Tender.DTO.tendor;
import Tender.DTO.vendor;
import Tender.Exception.NoRecordFoundException;
import Tender.Exception.SomethingWentWrongException;

public interface AdminDAO 
{
	public List<vendor> getAllVendors() throws SomethingWentWrongException, NoRecordFoundException;

	public List<tendor> viewAllTendors() throws NoRecordFoundException,SomethingWentWrongException;
    
	public List<Bid> viewBids(String tenderId) throws SomethingWentWrongException;
     
	public void assignTender(String tender_id) throws SomethingWentWrongException, NoRecordFoundException;
	
	
}
