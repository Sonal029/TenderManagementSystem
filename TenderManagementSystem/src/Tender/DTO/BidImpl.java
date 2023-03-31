package Tender.DTO;

import java.time.LocalDate;

public class BidImpl implements Bid
{
   private String tendorId;
   private String vendorId;
   private int bidAmount;
   private LocalDate bidDate;
public BidImpl(String tendorId, String vendorId, int bidAmount, LocalDate bidDate) {
	super();
	this.tendorId = tendorId;
	this.vendorId = vendorId;
	this.bidAmount = bidAmount;
	this.bidDate = bidDate;
}

public String getTendorId() {
	return tendorId;
}
public void setTendorId(String tendorId) {
	this.tendorId = tendorId;
}
public String getVendorId() {
	return vendorId;
}
public void setVendorId(String vendorId) {
	this.vendorId = vendorId;
}
public int getBidAmount() {
	return bidAmount;
}
public void setBidAmount(int bidAmount) {
	this.bidAmount = bidAmount;
}
public LocalDate getBidDate() {
	return bidDate;
}
public void setBidDate(LocalDate bidDate) {
	this.bidDate = bidDate;
}
   
   
}
