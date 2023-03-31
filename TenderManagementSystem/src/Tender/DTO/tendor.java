package Tender.DTO;

import java.time.LocalDate;

public interface tendor 
{
	public String getTendor_id() ;
	public void setTendor_id(String tendor_id);
	public String getTendor_desc();
	public void setTendor_desc(String tendor_desc);
	public int getTendor_budget();
	public void setTendor_budget(int tendor_budget) ;
	public void setTendor_date(LocalDate tendor_date);
	public String getStatus();
	public void setStatus(String status);
	public LocalDate getTendor_date();
}
