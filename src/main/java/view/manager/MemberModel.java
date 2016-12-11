package view.manager;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MemberModel {
//    private final StringProperty memberId;
//    private final StringProperty memberName;
	
	private final StringProperty id;
	private final StringProperty name;
//    private final StringProperty memberviptype;
//	private final StringProperty vipType;
//	private final StringProperty type;
	private final StringProperty memberType;
    private final StringProperty memberLevel;
    private final DoubleProperty memberCredit;
    
    public MemberModel(String memberId,String memberName,String memberviptype,
    		String memberLevel,double membreCredit) {
    	this.id=new SimpleStringProperty(memberId);
    	this.name=new SimpleStringProperty(memberName);
    	this.memberLevel=new SimpleStringProperty(memberLevel);
    	
    	if(memberviptype.equals("CompanyVip")){
            this.memberType=new SimpleStringProperty("企业会员");
    	}else{
            this.memberType=new SimpleStringProperty("普通会员");
    	}
    	
    	this.memberCredit=new SimpleDoubleProperty(membreCredit);
        
    }
    
    public void setMemberId(String memberid){
    	this.id.set(memberid);
    }
    
    public String getName(){
    	return name.get();
    }
    
    public String getMemberLevel(){
    	return memberLevel.get();
    }
    
    public double getMemberCredit(){
    	return memberCredit.get();
    }
    
    public String getMemberviptype(){
    	return memberType.get();
    }
    
    public String getId(){
    	return id.get();
    }
    
    public void setMemberName(String memberName){
    	this.name.set(memberName);
    }
    
    public void setMemberCredit(double memberCredit){
    	this.memberCredit.set(memberCredit);
    }
    
    public void setMemberLevel(String memberLevel){
    	this.memberLevel.set(memberLevel);
    }
    
    public void setMemberVipType(String memberViptype){
    	if(memberViptype.equals("CompanyVip")){
    		this.memberType.set("企业会员");
    	}else{
    		this.memberType.set("普通会员");
    	}
    }
}
