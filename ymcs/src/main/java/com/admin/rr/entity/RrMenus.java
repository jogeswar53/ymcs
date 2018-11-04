package com.admin.rr.entity;
// Generated Nov 4, 2018 2:06:54 PM by Hibernate Tools 5.2.3.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

/**
 * RrMenus generated by hbm2java
 */
@Entity
@DynamicUpdate(value = true)
@SelectBeforeUpdate(value = true)
@Table(name = "RR_MENUS")
public class RrMenus extends BaseEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer rrMenusId;
	private String menuLevel;
	private String title;
	private String description;
	private String url;
	private String iconUrl;
	private boolean activeStatus;
	private boolean deleteStatus;
	private Set<RrPermissionMaster> rrPermissionMasters = new HashSet<>(0);

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "RR_MENUS_ID", unique = true, nullable = false)
	public Integer getRrMenusId() {
		return this.rrMenusId;
	}

	public void setRrMenusId(Integer rrMenusId) {
		this.rrMenusId = rrMenusId;
	}

	@Column(name = "MENU_LEVEL", nullable = false)
	public String getMenuLevel() {
		return this.menuLevel;
	}

	public void setMenuLevel(String menuLevel) {
		this.menuLevel = menuLevel;
	}

	@Column(name = "TITLE", nullable = false, length = 50)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "DESCRIPTION", nullable = false)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "URL")
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "ICON_URL")
	public String getIconUrl() {
		return this.iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	@Column(name = "ACTIVE_STATUS", nullable = false)
	public boolean isActiveStatus() {
		return this.activeStatus;
	}

	public void setActiveStatus(boolean activeStatus) {
		this.activeStatus = activeStatus;
	}

	@Column(name = "DELETE_STATUS", nullable = false)
	public boolean isDeleteStatus() {
		return this.deleteStatus;
	}

	public void setDeleteStatus(boolean deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rrMenus")
	public Set<RrPermissionMaster> getRrPermissionMasters() {
		return this.rrPermissionMasters;
	}

	public void setRrPermissionMasters(Set<RrPermissionMaster> rrPermissionMasters) {
		this.rrPermissionMasters = rrPermissionMasters;
	}

}
