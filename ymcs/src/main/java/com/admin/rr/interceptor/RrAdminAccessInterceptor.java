package com.admin.rr.interceptor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.admin.rr.beans.RrAdminUserBean;
import com.admin.rr.dao.RrCommonDao;
import com.admin.rr.entity.RrMenus;
import com.admin.rr.utils.RrCommonUtils;

public class RrAdminAccessInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LogManager.getLogger(RrAdminAccessInterceptor.class.getName());

	@Autowired
	RrCommonDao testCommonDao;

	@Value("${application.application.URL}")
	String applicationUrl;

	public String getBaseUrl(HttpServletRequest request) {
		return String.format("%s://%s:%d%s/", request.getScheme(), request.getServerName(),
				request.getServerPort(), request.getContextPath());
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String baseUrl = getBaseUrl(request);
		
		String requestUri = request.getRequestURI();
		String redirectUrl = request.getContextPath();

		// for not required to check the user is exist or not
		if (requestUri.endsWith("login") || requestUri.endsWith("adminForgotPassword")
				|| requestUri.endsWith("getAllPrtWebservice")) {

			return true;
		}

		try {
			HttpSession session = request.getSession();
			RrAdminUserBean adminUserBean = (RrAdminUserBean) session.getAttribute("activeUser");

			if ((null != adminUserBean) && (null != adminUserBean.getUserId())) {
				List<RrMenus> menuList = testCommonDao.getMenuListByUserRole(adminUserBean.getUserRole());
				List<Integer> childCatNos = new ArrayList<>();
				RrMenus menus;
				boolean isChildYes = false;

				// URL = admin/dashboard?pid=0&mid=3
				Integer pId = Integer.parseInt(RrCommonUtils.nullSafe(request.getParameter("pid"), "0"));
				Integer mId = Integer.parseInt(RrCommonUtils.nullSafe(request.getParameter("mid"), "0"));

				String activeClass;

				StringBuilder strBuffer = new StringBuilder("<ul class='sidebar-menu' data-widget='tree'>");

				if ((null != menuList) && (!menuList.isEmpty())) {
					for (int i = 0; i < menuList.size(); i++) {
						menus = menuList.get(i);
						if (menus.getMenuLevel().trim().length() == 3) {
							if (((i + 1) < menuList.size())
									&& (menuList.get(i + 1).getMenuLevel().trim().length() > 3)) {
								isChildYes = true;
								activeClass = (pId == menus.getRrMenusId()) ? "active".intern() : "".intern();

								strBuffer.append("<li class='").append(activeClass)
										.append(" treeview'><a href='javascript:void(0);'>").append("<i class='fa ")
										.append(menus.getIconUrl()).append("'></i>").append("<span>")
										.append(menus.getTitle())
										.append("</span><span class='pull-right-container'>")
										.append("<i class='fa fa-angle-left pull-right'></i></span></a><ul class='treeview-menu'>");
							} else {
								isChildYes = false;
								activeClass = (mId == menus.getRrMenusId()) ? "active".intern() : "".intern();

								strBuffer.append("<li class='").append(activeClass).append("'>").append("<a href='")
										.append(baseUrl).append(menus.getUrl()).append("'><i class='fa ")
										.append(menus.getIconUrl()).append("'></i><span>")
										.append(menus.getTitle());
								strBuffer.append("</span> <span class='pull-right-container'></span></a></li>");
							}

							new RrCommonUtils().hasChild(menuList, (i + 1), menus.getMenuLevel(), (3 * 3 + 2), 3,
									childCatNos, strBuffer, baseUrl, mId);

							if (isChildYes) {
								isChildYes = false;
								strBuffer.append("</ul></li>");
							}
						}
					}
					strBuffer.append("</ul>");
					request.setAttribute("menuList", strBuffer.toString().intern());
				}
			} else {
				response.sendRedirect(redirectUrl);
			} // if user is not exist
		} catch (Exception e) {
			logger.error("@@@@ Exception in RrAdminAccessInterceptor at preHandle() :", e);
		}

		return true;
	}

}