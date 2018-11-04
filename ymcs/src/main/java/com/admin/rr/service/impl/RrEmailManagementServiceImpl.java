package com.admin.rr.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//import com.admin.dao.AfCbsEmailManagementDao;
//import com.admin.entity.AfCbsEmailManagement;
import com.admin.rr.beans.RrEmailManagementBean;
import com.admin.rr.constants.RrConstants;
import com.admin.rr.service.RrEmailManagementService;

@Component
@Transactional(readOnly = true)
public class RrEmailManagementServiceImpl implements RrEmailManagementService {

	private Logger logger = LogManager.getLogger(RrEmailManagementServiceImpl.class.getName());

//	@Autowired
//	AfCbsCommonService commonService;

//	@Autowired
//	AfCbsEmailManagementDao emailManagementDAO;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void addEmail(RrEmailManagementBean emailManagementBean) {

//		String title;
//		String content;
//		String name;
//
//		AfCbsEmailManagement afEmailManagement = new AfCbsEmailManagement();
//
//		name = emailManagementBean.getName();
//		name = (null != name) ? name.trim() : RrConstants.STRING_EMPTY.intern();
//		afEmailManagement.setName(name);
//
//		title = emailManagementBean.getTitle();
//		title = (null != title) ? title.trim() : RrConstants.STRING_EMPTY.intern();
//		afEmailManagement.setTitle(title);
//
//		content = emailManagementBean.getContent();
//		content = (null != content) ? content.trim() : RrConstants.STRING_EMPTY.intern();
//		afEmailManagement.setContent(content);
//
//		afEmailManagement.setCreatedTime(new Date());
//		afEmailManagement.setEmailStatus(emailManagementBean.getEmailStatus());
//		afEmailManagement.setStatus(RrConstants.STATUS_ACTIVE_VALUE);
//
//		if (null != emailManagementBean.getUserId()) {
//			afEmailManagement.setCreatedBy(emailManagementBean.getUserId());
//		}
//		emailManagementDAO.addContent(afEmailManagement);
	}

	@Override
	public List<RrEmailManagementBean> getAllEmail() {

		List<RrEmailManagementBean> contentManagementBeans = null;
//		List<AfCbsEmailManagement> listContentManagement = new ArrayList<>();
//		String name = RrConstants.STRING_EMPTY.intern();
//		String content = RrConstants.STRING_EMPTY.intern();
//		String title = RrConstants.STRING_EMPTY.intern();
//
//		try {
//			listContentManagement = emailManagementDAO.getAllEmail();
//			contentManagementBeans = new ArrayList<>();
//
//			for (AfCbsEmailManagement contentManagement : listContentManagement) {
//				RrEmailManagementBean emailManagementBean = new RrEmailManagementBean();
//
//				name = contentManagement.getName();
//				name = (null != name) ? name.trim() : RrConstants.STRING_EMPTY.intern();
//				emailManagementBean.setName(name);
//
//				content = contentManagement.getContent();
//				content = (null != content) ? content.trim() : RrConstants.STRING_EMPTY.intern();
//				emailManagementBean.setContent(content);
//
//				title = contentManagement.getTitle();
//				title = (null != title) ? title.trim() : RrConstants.STRING_EMPTY.intern();
//				emailManagementBean.setTitle(title);
//
//				emailManagementBean.setEmId(contentManagement.getEmId());
//				emailManagementBean.setEmailStatus(contentManagement.getEmailStatus());
//
//				contentManagementBeans.add(emailManagementBean);
//			}
//		} catch (Exception e) {
//			logger.error("@@@@ Exception in EmailManagementServiceImpl questionManagement() :" + e);
//		}

		return contentManagementBeans;
	}

	public RrEmailManagementBean getEmailById(int emId) {

		RrEmailManagementBean emailManagementBean = null;
//		AfCbsEmailManagement afEmailManagement = new AfCbsEmailManagement();
//
//		try {
//			afEmailManagement = emailManagementDAO.getContentById(emId);
//		} catch (Exception e) {
//			logger.error("@@@@ Exception in EmailManagementServiceImpl at getEmailById(): ", e);
//		}
//		if (null != afEmailManagement) {
//			emailManagementBean = new RrEmailManagementBean();
//			emailManagementBean.setName(afEmailManagement.getName());
//			emailManagementBean.setEmId(afEmailManagement.getEmId());
//			emailManagementBean.setTitle(afEmailManagement.getTitle());
//			emailManagementBean.setContent(afEmailManagement.getContent().replace("$$URLSCHEMA$$", "http://"));
//			emailManagementBean.setEmailStatus(afEmailManagement.getEmailStatus());
//		}

		return emailManagementBean;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public String updateEmail(RrEmailManagementBean emailManagementBean) {

		String status = RrConstants.STRING_EMPTY.intern();
//		AfCbsEmailManagement afEmailManagement = null;
//
//		try {
//			afEmailManagement = emailManagementDAO.getContentById(emailManagementBean.getEmId());
//		} catch (Exception e) {
//			logger.error("@@@@ Exception in EmailManagementServiceImpl at updateEmail(): ", e);
//		}
//
//		if (null != afEmailManagement) {
//			if (null != emailManagementBean.getUserId())
//				afEmailManagement.setModifiedBy(emailManagementBean.getUserId());
//
//			afEmailManagement.setModifiedTime(new Date());
//			afEmailManagement.setName(emailManagementBean.getName());
//			afEmailManagement.setContent(emailManagementBean.getContent());
//			afEmailManagement.setTitle(emailManagementBean.getTitle());
//			afEmailManagement.setEmailStatus(emailManagementBean.getEmailStatus());
//
//			status = emailManagementDAO.updateContent(afEmailManagement);
//		}

		return status;
	}

	@Override
	public String emailTypeExist(String emailType) {
		return null;
//		return emailManagementDAO.emailTypeExist(emailType);
	}

}
