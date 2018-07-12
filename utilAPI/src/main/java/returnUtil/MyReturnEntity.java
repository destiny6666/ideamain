package returnUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MyReturnEntity {

	private Integer returnStatus=200;
	private String returnReason="OK";
	private String remarks="No remarks";//中文乱码
	private Integer returnTotal=0;
	
//	private List returnMessage=new ArrayList();
	private Map<String, Object> returnInformation = new HashMap<String, Object>();
	
	public Map<String, Object> getReturnInformation() {
		return returnInformation;
	}

	public MyReturnEntity setReturnInformation(Map<String, Object> returnInformation) {
		this.returnInformation = returnInformation;
		return this;
	}

	public MyReturnEntity() {
		// TODO Auto-generated constructor stub
	}

	public MyReturnEntity(Map<String, Object> returnInformation) {
		this.setReturnInformation(returnInformation);
//		setReturnMessage(returnMessage);
	}
	
	public MyReturnEntity(Integer returnStatus, String returnReason, String remarks) {
		this.returnStatus = returnStatus;
		this.returnReason = returnReason;
		this.remarks = remarks;
	}
	
	public MyReturnEntity(Integer returnStatus, String returnReason, String remarks, List returnMessage) {
		this.returnStatus = returnStatus;
		this.returnReason = returnReason;
		this.remarks = remarks;
		this.setReturnInformation(returnInformation);
//		setReturnMessage(returnMessage);
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

//	public List getReturnMessage() {
//		return returnMessage;
//	}
//
//	public void setReturnMessage(List returnMessage) {
//		this.returnMessage = returnMessage;
//		
//		returnTotal=returnMessage==null?0:returnMessage.size();
//	}
//	
//	public MyReturnEntity set(List returnMessage){
//
//		if (returnMessage==null) return this.set(new ArrayList());
//		
//		this.returnMessage = returnMessage;
//		
//		returnTotal=Optional.ofNullable(returnMessage).map(s->s.size()).orElse(0);
//		
//		return this;
//	}
	public MyReturnEntity put(Map<String, Object> returnInformation) {
		return put(returnInformation,"");
	}
	
	public MyReturnEntity put(Map<String, Object> returnInformation, String remark) {
		
        MyReturnEntity entity=new MyReturnEntity();
        if(returnInformation!=null) {
            entity.setReturnInformation(returnInformation);
            entity.setReturnTotal(Optional.ofNullable(returnInformation).map(s->s.size()).orElse(0));
        }

        entity.setRemarks(remark);
		return entity;

	}
	
	
}
