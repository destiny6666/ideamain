package returnUtil;

public class MyReturnErrorEntity {

	public Integer returnStatus=1;
	public String returnReason="ERROR";
	private String remarks="No remarks";//中文乱码
	private Integer returnTotal=0;
	
//	private List returnMessage=new ArrayList();
	
	public MyReturnErrorEntity() {
		// TODO Auto-generated constructor stub
	}


	public Integer getReturnStatus() {
		return returnStatus;
	}

	public void setReturnStatus(Integer returnStatus) {
		this.returnStatus = returnStatus;
	}

	public String getReturnReason() {
		return returnReason;
	}

	public void setReturnReason(String returnReason) {
		this.returnReason = returnReason;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getReturnTotal() {
		return returnTotal;
	}

	public void setReturnTotal(Integer returnTotal) {
		this.returnTotal = returnTotal;
	}
	
	public MyReturnErrorEntity set(String text) {
	    MyReturnErrorEntity entity=new MyReturnErrorEntity();
	    entity.returnReason=text;
		return entity;
	}
	
	public MyReturnErrorEntity set(Integer returnStatus, String text) {
	       MyReturnErrorEntity entity=new MyReturnErrorEntity();
	       entity.returnStatus = returnStatus;
	       entity.returnReason = text;
        return entity;
	}

}
