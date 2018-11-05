package com.admin.rr.dao.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.admin.rr.constants.RrConstants;
import com.admin.rr.dao.RrUserProfileConfDao;
import com.admin.rr.entity.RrUserProfile;

/**
 * @author jogeswar
 *
 */
@Repository
public class RrUserProfileConfDaoImpl implements RrUserProfileConfDao {

	private static final Logger logger = LogManager.getLogger(RrUserProfileConfDaoImpl.class.getName());

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Long saveOrUpdateUserProfile(RrUserProfile userProfile) {

		try {
			sessionFactory.getCurrentSession().saveOrUpdate(userProfile);
		} catch (Exception e) {
			logger.error("@@@ Exception in RrUserProfileConfDaoImpl at saveOrUpdateUserProfile(): ", e);
		}

		return userProfile.getRrUserProfileId();
	}

	@Override
	public RrUserProfile getUserProfileById(Long userProfileId) {

		RrUserProfile userProfileDetails = null;

		try {
			userProfileDetails = (RrUserProfile) sessionFactory.getCurrentSession().get(RrUserProfile.class,
					userProfileId);
		} catch (Exception e) {
			logger.error("@@@ Exception in RrUserProfileConfDaoImpl at getUserProfileById(): ", e);
		}

		return userProfileDetails;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RrUserProfile> getAllUserProfiles() {

		List<RrUserProfile> userProfileList = null;

		try {
			userProfileList = sessionFactory.getCurrentSession()
					.createQuery("select cm from RrUserProfile cm where cm.rrUserProfileId<>1 and cm.status in ('Online', 'Offline')").list();
		} catch (Exception e) {
			logger.error("@@@ Exception in RrUserProfileConfDaoImpl at getAllUserProfiles(): ", e);
		}

		return userProfileList;
	}

	@Override
	public String deleteUserProfileById(Long userProfileId) {

		RrUserProfile userProfile = null;
		String status = RrConstants.FAILURE;

		try {
			Session session = sessionFactory.getCurrentSession();

			userProfile = getUserProfileById(userProfileId);

			if (null != userProfile) {
				userProfile.setStatus("Deleted");
				session.saveOrUpdate(userProfile);
				status = RrConstants.SUCCESS;
			}
		} catch (Exception e) {
			logger.error("@@@ Exception in RrUserProfileConfDaoImpl at deleteUserProfileById(): ", e);
		}

		return status;
	}

	@Override
	public String checkDuplicateUserName(String userName) {
		try {
			// Default implementation is ignored.
		} catch (Exception e) {
			logger.error("@@@ Exception in RrUserProfileConfDaoImpl at checkDuplicateUserName(): ", e);
		}
		return null;
	}

}
