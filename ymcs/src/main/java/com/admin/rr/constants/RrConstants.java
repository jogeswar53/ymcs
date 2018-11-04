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

	public static final Byte USER_STATUS_IN_ACTIVE = 0;
	public static final Byte ROLE_STATUS_IN_ACTIVE = 0;

	public static final Byte STATUS_IN_ACTIVE_VALUE = 0;
	public static final Byte STATUS_ACTIVE_VALUE = 1;

	public static final Integer PERMISSION_TYPE_VIEW = 0;
	public static final Integer PERMISSION_TYPE_ADD = 1;
	public static final Integer PERMISSION_TYPE_EDIT = 2;
	public static final Integer PERMISSION_TYPE_DELETE = 3;

	public static final Byte PERMISSION_ACTIONS_VIEW = 0;
	public static final Byte PERMISSION_ACTIONS_ADD = 1;
	public static final Byte PERMISSION_ACTIONS_EDIT = 2;
	public static final Byte PERMISSION_ACTIONS_DELETE = 3;
	public static final Byte PERMISSION_ACTIONS_EXPORT = 4;

	public static final String BANNER_SECTIONS_C = "Carousel Banners".intern();
	public static final String BANNER_SECTIONS_S = "Static Banners".intern();
	public static final String BANNER_SECTIONS_P = "Partner Dedicated Banners".intern();
	public static final String BANNER_SECTIONS_T = "Teaser Banners".intern();

	public static final String TRANSACTION_STATUS_REQUEST = "Requested".intern();
	public static final String TRANSACTION_STATUS_CONFIRM = "Confirmed".intern();
	public static final String TRANSACTION_STATUS_CANCEL = "Cancelled".intern();

	public static final String CONTENT_TYPE_HOME_0 = "Home Content".intern();
	public static final String CONTENT_TYPE_EMAIL_1 = "Email Content".intern();

	public static final String ITEM_TYPE_PRODUCT = "1";
	public static final String ITEM_TYPE_CATEGORY = "2";
	public static final String ITEM_TYPE_PARTNER = "3";
	public static final String ITEM_TYPE_OFFERS_AND_DEALS = "4";

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

	public static final Byte EMAIL_MEDIA_TYPE = 0;
	public static final Byte WHATSAPP_OR_SMS_MEDIA_TYPE = 1;
	public static final Byte FACEBOOK_MEDIA_TYPE = 2;
	public static final Byte GOOGLE_PLUS_MEDIA_TYPE = 3;
	public static final Byte TWITTER_MEDIA_TYPE = 4;
	public static final Byte LINKEDIN_MEDIA_TYPE = 5;
	public static final Byte WHATSAPP_MEDIA_TYPE = 6;

	public static final Byte FALSE_VALUE = 0;
	public static final Byte TRUE_VALUE = 1;

	public static final Byte VERIFICATION_MODE_EMAIL = 0;
	public static final Byte VERIFICATION_MODE_MOBILE = 1;

	public static final String EXCEL_FILE_EXTENSION =  "excel".intern();
	public static final String CSV_FILE_EXTENSION = "csv".intern();
	public static final String EXCEL_EXTENSION = ".xls".intern();
	public static final String CSV_EXTENSION = ".csv".intern();

	private RrConstants() {
	}
}