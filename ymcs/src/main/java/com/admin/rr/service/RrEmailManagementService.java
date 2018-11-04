package com.admin.rr.service;

import java.util.List;

import com.admin.rr.beans.RrEmailManagementBean;

public interface RrEmailManagementService {

	public void addEmail(RrEmailManagementBean emailManagementBean);

	public String updateEmail(RrEmailManagementBean emailManagementBean);

	public List<RrEmailManagementBean> getAllEmail();

	public RrEmailManagementBean getEmailById(int emId);

	public String emailTypeExist(String emailType);

}
