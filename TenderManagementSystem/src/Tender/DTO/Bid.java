package Tender.DTO;

import java.time.LocalDate;

public interface Bid {

	public String getTendorId();
	public void setTendorId(String tendorId);
	public String getVendorId() ;
	public void setVendorId(String vendorId);
	public int getBidAmount();
	public void setBidAmount(int bidAmount);
	public LocalDate getBidDate();
	public void setBidDate(LocalDate bidDate);
	public String getStatus();
	public void setStatus(String status);
}
