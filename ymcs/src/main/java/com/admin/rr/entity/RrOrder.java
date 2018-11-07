package com.admin.rr.entity;
// Generated Nov 4, 2018 2:06:54 PM by Hibernate Tools 5.2.3.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

/**
 * RrOrder generated by hbm2java
 */
@Entity
@DynamicUpdate(value = true)
@SelectBeforeUpdate(value = true)
@Table(name = "RR_ORDER", uniqueConstraints = @UniqueConstraint(columnNames = "ORDER_NO"))
public class RrOrder extends BaseEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long rrOrderId;
	private RrBrandMaster rrBrandMaster;
	private RrIssueMaster rrIssueMaster;
	private RrUserProfile rrUserProfile;
	private String orderNo;
	private String firstName;
	private String middleName;
	private String lastName;
	private String mobileNo;
	private String emailId;
	private String address;
	private String model;
	private Date dueTime;
	private String accessories;
	private String issueDescription;
	private String paidAmount;
	private String totalAmount;
	private String particulars;
	private String orderStatus;
	private String status;
	private Set<RrInvoice> rrInvoices = new HashSet<>(0);

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "RR_ORDER_ID", unique = true, nullable = false)
	public Long getRrOrderId() {
		return this.rrOrderId;
	}

	public void setRrOrderId(Long rrOrderId) {
		this.rrOrderId = rrOrderId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RR_BRAND_MASTER_ID", nullable = false)
	public RrBrandMaster getRrBrandMaster() {
		return this.rrBrandMaster;
	}

	public void setRrBrandMaster(RrBrandMaster rrBrandMaster) {
		this.rrBrandMaster = rrBrandMaster;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RR_ISSUE_MASTER_ID", nullable = false)
	public RrIssueMaster getRrIssueMaster() {
		return this.rrIssueMaster;
	}

	public void setRrIssueMaster(RrIssueMaster rrIssueMaster) {
		this.rrIssueMaster = rrIssueMaster;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RR_USER_PROFILE_ID", nullable = false)
	public RrUserProfile getRrUserProfile() {
		return this.rrUserProfile;
	}

	public void setRrUserProfile(RrUserProfile rrUserProfile) {
		this.rrUserProfile = rrUserProfile;
	}

	@Column(name = "ORDER_NO", unique = true, nullable = false)
	public String getOrderNo() {
		return this.orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	@Column(name = "FIRST_NAME", nullable = false)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "MIDDLE_NAME", length = 50)
	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Column(name = "LAST_NAME", length = 80)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "MOBILE_NO", nullable = false, length = 13)
	public String getMobileNo() {
		return this.mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Column(name = "EMAIL_ID")
	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Column(name = "ADDRESS")
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "MODEL", nullable = false)
	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DUE_TIME", length = 19)
	public Date getDueTime() {
		return this.dueTime;
	}

	public void setDueTime(Date dueTime) {
		this.dueTime = dueTime;
	}

	@Column(name = "ACCESSORIES")
	public String getAccessories() {
		return this.accessories;
	}

	public void setAccessories(String accessories) {
		this.accessories = accessories;
	}

	@Column(name = "ISSUE_DESCRIPTION")
	public String getIssueDescription() {
		return this.issueDescription;
	}

	public void setIssueDescription(String issueDescription) {
		this.issueDescription = issueDescription;
	}

	@Column(name = "PAID_AMOUNT")
	public String getPaidAmount() {
		return this.paidAmount;
	}

	public void setPaidAmount(String paidAmount) {
		this.paidAmount = paidAmount;
	}

	@Column(name = "TOTAL_AMOUNT", length = 20)
	public String getTotalAmount() {
		return this.totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Column(name = "PARTICULARS")
	public String getParticulars() {
		return this.particulars;
	}

	public void setParticulars(String particulars) {
		this.particulars = particulars;
	}

	@Column(name = "ORDER_STATUS", nullable = false, length = 10)
	public String getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Column(name = "STATUS", nullable = false, length = 7)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rrOrder")
	public Set<RrInvoice> getRrInvoices() {
		return this.rrInvoices;
	}

	public void setRrInvoices(Set<RrInvoice> rrInvoices) {
		this.rrInvoices = rrInvoices;
	}

}
