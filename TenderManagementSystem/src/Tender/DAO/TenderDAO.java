package Tender.DAO;

import Tender.DTO.Tendor;
import Tender.Exception.SomethingWentWrongException;

public interface TenderDAO {

	public void createNewTender(Tendor v) throws SomethingWentWrongException;

}
