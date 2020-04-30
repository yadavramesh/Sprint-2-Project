package org.com.model;
import java.math.BigInteger;
//import java.math.BigInteger;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String userId;
	private String userName;
	private String userpassword;
	private BigInteger contactNo;
	private String emaidId;
	private String userRole;
	/**
	 * 
	 * @param userId
	 * @param userName
	 * @param userpassword
	 * @param contactNo
	 * @param userRole
	 * @param emaidId
	 * @param gender
	 * @param age
	 */
	


	public User() {

	}

	/**
	 * 
	 * @return
	 */
	
	public String getUserId() {
		return userId;
	}

	/**
	 * 
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * 
	 * @return
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 
	 * @return
	 */
	public String getUserpassword() {
		return userpassword;
	}

	/**
	 * 
	 * @param userpassword
	 */
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	/**
	 * 
	 * @return
	 */
	public BigInteger getContactNo() {
		return contactNo;
	}

	/**
	 * 
	 * @param contactNo
	 */
	public void setContactNo(BigInteger contactNo) {
		this.contactNo = contactNo;
	}

	/**
	 * 
	 * @return
	 */
	public String getEmaidId() {
		return emaidId;
	}

	/**
	 * 
	 * @param emaidId
	 */
	public void setEmaidId(String emaidId) {
		this.emaidId = emaidId;
	}
	/**
	 * 
	 * @return
	 */
	public String getUserRole() {
		return userRole;
	}

	/**
	 * 
	 * @param userRole
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	/**
	 * 
	 * @return
	 */
	

}
	
	

