package Tender.DAO;

import Tender.DTO.tendor;
import Tender.Exception.SomethingWentWrongException;

public interface TenderDAO {

	public void createNewTender(tendor v) throws SomethingWentWrongException;

}
