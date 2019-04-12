package edu.nwu.sakaistudentlink.services;

public class BecomeUserObject implements java.io.Serializable {

	private static final long serialVersionUID = -8713247712938943870L;
	
	private String userDisplayName;
	private Boolean isAdminUser;	

	public BecomeUserObject() {		
	}
	
	public BecomeUserObject(String userDisplayName, Boolean isAdminUser) {
		super();
		this.userDisplayName = userDisplayName;
		this.isAdminUser = isAdminUser;
	}
	
	public String getUserDisplayName() {
		return userDisplayName;
	}
	
	public void setUserDisplayName(String userDisplayName) {
		this.userDisplayName = userDisplayName;
	}
	
	public Boolean getIsAdminUser() {
		return isAdminUser;
	}
	
	public void setIsAdminUser(Boolean isAdminUser) {
		this.isAdminUser = isAdminUser;
	}
}
