package com.admin.rr.constants;

public class RrConstants {

	public static final Integer STATUS = 1;

	public static final String STATUS_IN_ACTIVE = "In Active".intern();
	public static final String STATUS_ACTIVE = "Active".intern();
	public static final String STATUS_BLOCK = "Block".intern();

	public static final String MALE = "Male".intern();
	public static final String FEMALE = "Female".intern();
	public static final String OTHER = "Other".intern();

	public static final String SUPER_ADMIN = "Super Admin".intern();
	public static final String ADMIN = "Admin".intern();
	public static final String EMLOYEE = "Emloyee".intern();

	public static final Byte CHECKBOX_STATUS_CHECKED = 1;
	public static final Byte CHECKBOX_STATUS_UNCHECKED = 0;

	public static final String FAILURE = "failure".intern();
	public static final String SUCCESS = "success".intern();

	public static final String SUCCESS_MESSAGE = "message".intern();
	public static final String ERROR_MESSAGE = "errormessage".intern();
	public static final String ERROR_VALUE = "No Record Found".intern();
	public static final String ERROR_MESSAGE_VALUE = "Error occured, try again".intern();

	public static final String STATUS_CLASS_GREEN = "green".intern();
	public static final String STATUS_CLASS_RED = "red".intern();

	public static final Byte PERMISSION_ACTIONS_VIEW = 0;
	public static final Byte PERMISSION_ACTIONS_ADD = 1;
	public static final Byte PERMISSION_ACTIONS_EDIT = 2;
	public static final Byte PERMISSION_ACTIONS_DELETE = 3;
	public static final Byte PERMISSION_ACTIONS_EXPORT = 4;

	public static final String STRING_EMPTY = "".intern();
	public static final String SEMICOLON = ";".intern();
	public static final String STRING_NULL = null;
	public static final String EXIST = "exist".intern();
	public static final String ONLINE = "Online".intern();
	public static final String OFFLINE = "Offline".intern();
	public static final String DELETED = "Offline".intern();
	public static final String AND = " and ".intern();
	public static final String SINGLE_QUOTE = "\'".intern();

	public static final String DEFAULT_DATE_FORMAT = "dd/MM/yyyy".intern();
	public static final String EDIT_MEMBER_DATE_FORMAT = "E MMM dd yyyy 'at' hh:mm:ss".intern();
	public static final String CAMPAIGN_MGMT_DATE_FORMAT = "dd-MMM-yyyy".intern();

	public static final String MR = "Mr".intern();
	public static final String MRS = "Mrs".intern();
	public static final String MS = "Ms".intern();

	private RrConstants() {
	}
}