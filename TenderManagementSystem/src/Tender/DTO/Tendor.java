package Tender.DTO;

import java.time.LocalDate;

public class Tendor{

	private String tendor_id;
	private String tendor_desc;
	private int tendor_budget;
	private LocalDate tendor_date;
	private String status;
	public Tendor(String tendor_id, String tendor_desc, int tendor_budget, LocalDate tendor_date, String status) {
		super();
		this.tendor_id = tendor_id;
		this.tendor_desc = tendor_desc;
		this.tendor_budget = tendor_budget;
		this.tendor_date = tendor_date;
		this.status = status;
	}
	public String getTendor_id() {
		return tendor_id;
	}
	public void setTendor_id(String tendor_id) {
		this.tendor_id = tendor_id;
	}
	public String getTendor_desc() {
		return tendor_desc;
	}
	public void setTendor_desc(String tendor_desc) {
		this.tendor_desc = tendor_desc;
	}
	public int getTendor_budget() {
		return tendor_budget;
	}
	public void setTendor_budget(int tendor_budget) {
		this.tendor_budget = tendor_budget;
	}
	public LocalDate getTendor_date() {
		return tendor_date;
	}
	public void setTendor_date(LocalDate tendor_date) {
		this.tendor_date = tendor_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
