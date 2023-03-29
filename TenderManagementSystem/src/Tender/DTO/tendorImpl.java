package Tender.DTO;

public class tendorImpl implements tendor{

	private String tendor_id;
	private String tendor_desc;
	private int tendor_budget;
	private String status;
	public tendorImpl(String tendor_id, String tendor_desc, int tendor_budget, String status) 
	{
		super();
		this.tendor_id = tendor_id;
		this.tendor_desc = tendor_desc;
		this.tendor_budget = tendor_budget;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
