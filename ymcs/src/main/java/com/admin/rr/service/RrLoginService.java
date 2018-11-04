package com.admin.rr.service;

import com.admin.rr.beans.RrAdminUserBean;

/**
 * @author jogeswar
 *
 */
public interface RrLoginService {

	public RrAdminUserBean authenticateUser(RrAdminUserBean adminUserBean);

}
