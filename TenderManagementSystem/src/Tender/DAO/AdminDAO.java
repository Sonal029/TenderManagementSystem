package Tender.DAO;

import java.util.List;

import Tender.DTO.vendor;
import Tender.Exception.SomethingWentWrongException;

public interface AdminDAO 
{
	public List<vendor> getAllVendors() throws SomethingWentWrongException;

}
