package com.admin.rr.constants;

public class RrHBQueries {

	/***
	 * 
	 * rradminportal query
	 * 
	 */

	/***********************************************************************************************************/
	/********************************
	 * Menu related queries
	 ********************************************/
	/***********************************************************************************************************/

	public static final String AF_ADMIN_MENU = "select aam from AfCbsAdminMenu aam where aam.status=1";

	public static final String AF_ADMIN_MENU_RELATION = "select aamr from AfCbsAdminMenuRelation aamr where aamr.status=1";

	public static final String AF_ADMIN_MENUS = "select new com.admin.beans.AfCbsAdminMenusBean(me.menuId,me.title,me.url,mr.parentMenuId) from AfCbsAdminMenu me, AfCbsAdminMenuRelation mr where me.menuId=mr.menuId and me.status=1 order by mr.parentMenuId, mr.menuId";

	/***********************************************************************************************************/
	/********************************
	 * User Management related queries
	 ********************************************/
	/***********************************************************************************************************/

	// public static final String AF_GET_ACTIVE_USER_BY_EMAIL = "select * from
	// afcbsdb.TEST_USER_PROFILE user where user.user_id=:userName and
	// upassword=md5(:uPassword)";
	// public static final String AF_GET_ACTIVE_USER_BY_EMAIL = "select user
	// from TestUserProfile user where user.userId=:userName and
	// upassword=md5(:uPassword)";
	// public static final String AF_GET_ACTIVE_USER_BY_EMAIL = "select user
	// from AfCbsAdminUser user where user.userName=:userName";

	public static final String Af_GET_ACTIVE_USER_BY_EMAIL_AND_PASSWORD = "select user from AfCbsAdminUser user where user.userName=:userName and user.password=:password and user.userStatus=1";

	public static final String AF_ADMIN_USER_BY_NAME = "select user from AfCbsAdminUser user where user.userName=:userName";

	public static final String AF_ROLE_PERMISSIONS_QUERY = "select afpv.permissionName from AfCbsAdminRolePermissions afrp, AfCbsPermissionValues afpv where afrp.afCbsPermissionValues.permissionId=afpv.permissionId and afrp.afCbsAdminRoles.roleId=:userRole and afrp.permissionStatus=1";

	public static final String AF_ADMIN_USER = "select aau from AfCbsAdminUser aau where aau.status=1";

	public static final String AF_ADMIN_ROLES = "select aar from AfCbsAdminRoles aar where aar.status=1";

	public static final String AF_ADMIN_ROLE_BY_NAME = "select aar from AfCbsAdminRoles aar where aar.roleName=:roleName";

	public static final String AF_PERMISSION_VALUES_QUERY = "select pv from AfCbsPermissionValues pv where pv.status=1";

	public static final String AF_ENUM_VALUES = "select aev from AfCbsEnumValues aev where aev.typeName=:typeName and aev.activeStatus=1";

	/***********************************************************************************************************/
	/********************************
	 * Banner Management related queries
	 ********************************************/
	/***********************************************************************************************************/

	public static final String AF_BANNER = "select ab from AfCbsBanner ab where ab.status=1 order by ab.bannerSections, ab.bannerPosition";

	public static final String AF_PARTNERS = "select ap from AfCbsPartner ap where ap.partnerStatus=1 and ap.status=1";
	public static final String AF_PARTNERS_COUNT = "select count(*) from AfCbsPartner ap where ap.partnerStatus=1 and ap.status=1";

	public static final String GET_ALL_PARTNERS = "select ap from AfCbsPartner ap where ap.status=1 order by ap.prtNo";

	public static final String AF_PARTNERS_BY_DEFAULT = "select ap from AfCbsPartner ap where ap.defaultPartner=1 and ap.status=1";

	public static final String AF_PARTNERS_BY_RETAILER_SEQUENCE = "select partners from AfCbsPartner partners where partners.retailerSequence=:retailerSequence";

	public static final String AF_PARTNERS_BY_PARTNER_ID = "select partners from AfCbsPartner partners where partners.partnerId=:partnerId";

	public static final String AF_PARTNERS_BY_PARTNER_NAME = "select partners from AfCbsPartner partners where partners.partnerName=:partnerName";

	public static final String AF_CATEGORY = "select aac from AfCbsCategory aac where aac.status=1 order by aac.categoryId";

	public static final String AF_CATEGORY_BY_CATEGORY_No = "select aac from AfCbsCategory aac where aac.catNo=:catNo";

	public static final String AF_CATEGORY_LIST_BASED_PART_NO = "select aacl from AfCbsCategory aacl where aacl.status=1";

	public static final String AF_CATEGORIES_BY_CATEGORY_ID = "select category from AfCbsCategory category where category.categoryId=:categoryId";

	public static final String AF_CATEGORY_WHERE_PARTNER_CATEGORY_IS_NOT_EMPTY = "from AfCbsPartnerCategory partnercategory where partnercategory.status=1 ";

	public static final String AF_PARTNER_CATEGORY = "from AfCbsPartnerCategory partnercategory where partnercategory.status=1";

	public static final String AF_PARTNERCOMMISSION_BY_PRT_NO = "select apc from AfCbsPartnerCommission apc where apc.afCbsPartner.prtNo=:partNo and apc.status=1";

	// public static final String AF_PARTNERCOMMISSION = "select apc from
	// AfPartnerCommission apc where apc.status=1 and apc.afPartner.status=1
	// order by apc.prtCommNo desc";
	public static final String AF_PARTNERCOMMISSION = "from AfCbsPartnerCommission apc where apc.status=1 and apc.afCbsPartner.status=1";

	public static final String AF_PARTNER_CATEGORIES = "from AfCbsPartnerCategory partnercategory where partnercategory.prtCatNo=:prtCatNo";

	public static final String AF_PARTNER_CATEGORY_BY_DISPLAY_ORDER = "select afpc from AfCbsPartnerCategory afpc where afpc.partnerCategoryPosition=:categoryDisplayOrder and afpc.partnerCategoryStatus=1 and afpc.status=1";

	public static final String AF_PARTNER_CATEGORY_BY_PRTNO = "select afpc from AfCbsPartnerCategory afpc where afpc.afCbsPartner.prtNo=:prtNo and afpc.status=1";

	public static final String AF_RECOMMENDED_PRODUCT = "select afrp from AfCbsRecommendedProduct afrp where afrp.status=1 order by afrp.rpPosition";

	public static final String AF_RECOMMENDED_PRODUCT_CHECK = "select afrp from AfCbsRecommendedProduct afrp where  afrp.afCbsProduct.masterProductId=:prtPrdNo and afrp.status=1";

	public static final String AF_RECOMMENDED_PRODUCT_POSITION_CHECK = "select afrp from AfCbsRecommendedProduct afrp where afrp.rpPosition=:prtPrdPos and afrp.status=1";

	public static final String AF_PARTNER_PRODUCT_CHECK = "select afpc from AfCbsPartnerCommission afpc where afpc.afCbsPartner.prtNo=:prtNo and afpc.afCbsPartnerProduct.prtPrdNo=:prtPrdNo and afpc.afCbsPartnerCategory.prtCatNo=:prtCatNo and afpc.status=1";

	public static final String AF_RECOMMENDED_CATEGORY = "select afrc from AfCbsRecommendedCategory afrc where afrc.status=1 order by afrc.rcPosition";

	public static final String AF_RECOMMENDED_CATEGORY_CHECK = "select afrc from AfCbsRecommendedCategory afrc where afrc.afCbsPartner.prtNo=:prtNo and afrc.afCbsPartnerCategory.prtCatNo=:prtCatNo and afrc.status=1";

	public static final String AF_RECOMMENDED_CATEGORY_POSITION_CHECK = "select afrc from AfCbsRecommendedCategory afrc where afrc.rcPosition=:recommendedCategoryPosition and afrc.status=1";

	public static final String AF_PARTNER_PRODUCT = "select afpp from AfCbsPartnerProduct afpp where afpp.afCbsPartnerCategory.prtCatNo=:prtCatNo and afpp.status=1";

	public static final String AF_COMMISION_EXISTENCE_STARTDATE = "select count(*) from AfCbsPartnerCommission afpc where afpc.afCbsPartner.prtNo=:partNo and afpc.afCbsPartnerCategory.prtCatNo=:partCatNo and afpc.afCbsPartnerProduct.prtPrdNo=:partPdctNo and afpc.activationDate >:fromDate";

	public static final String AF_COMMISION_EXISTENCE_STARTDATE_WITHOUT_PRODUCT = "select count(*) from AfCbsPartnerCommission afpc where afpc.afCbsPartner.prtNo=:partNo and afpc.afCbsPartnerCategory.prtCatNo=:partCatNo and afpc.afCbsPartnerProduct.prtPrdNo IS null and afpc.activationDate>:fromDate";

	// public static final String
	// AF_COMMISION_EXISTENCE_STARTDATE_WITH_PRT_NO="select count(*) from
	// AfPartnerCommission afpc where afpc.afPartner.prtNo=:partNo and
	// afpc.afPartnerCategory.prtCatNo=:partCatNo and
	// afpc.afPartnerProduct.prtPrdNo=:partPrdNo and
	// afpc.productBrand=:brandName and afpc.activationDate>:fromDate";
	public static final String AF_COMMISION_EXISTENCE_STARTDATE_WITH_PRT_NO = "select count(*) from AfCbsPartnerCommission afpc where afpc.afCbsPartner.prtNo=:partNo and afpc.activationDate>:fromDate and afpc.afCbsPartnerCategory.prtCatNo is null and afpc.afCbsPartnerProduct.prtPrdNo is null and afpc.productBrand is null and afpc.categoryPath is null";

	public static final String AF_COMMISION_EXISTENCE_STARTDATE_WITH_PRT_CAT_NO = "select count(*) from AfCbsPartnerCommission afpc where afpc.afCbsPartner.prtNo=:partNo and afpc.afCbsPartnerCategory.prtCatNo=:partCatNo and afpc.activationDate>:fromDate and afpc.afCbsPartnerProduct.prtPrdNo is null and afpc.productBrand is null and afpc.categoryPath is null";

	public static final String AF_COMMISION_EXISTENCE_STARTDATE_WITH_PRODUCT = "select count(*) from AfCbsPartnerCommission afpc where afpc.afCbsPartner.prtNo=:partNo and afpc.afCbsPartnerCategory.prtCatNo=:partCatNo and afpc.afCbsPartnerProduct.prtPrdNo=:partPrdNo and afpc.activationDate>:fromDate and afpc.productBrand is null and afpc.categoryPath is null";

	public static final String AF_COMMISION_EXISTENCE_STARTDATE_WITH_BRAND = "select count(*) from AfCbsPartnerCommission afpc where afpc.afCbsPartner.prtNo=:partNo and afpc.afCbsPartnerCategory.prtCatNo=:partCatNo and afpc.productBrand=:brandName and afpc.activationDate>:fromDate and afpc.afPartnerProduct.prtPrdNo is null and afpc.categoryPath is null";

	public static final String AF_COMMISION_EXISTENCE_STARTDATE_WITH_BRAND_CAT_PATH = "select count(*) from AfCbsPartnerCommission afpc where afpc.afCbsPartner.prtNo=:partNo and afpc.afCbsPartnerCategory.prtCatNo=:partCatNo and afpc.productBrand=:brandName and afpc.activationDate>:fromDate and afpc.afCbsPartnerProduct.prtPrdNo is null and afpc.categoryPath=:catPath";

	public static final String AF_COMMISION_EXISTENCE_STARTDATE_WITH_PRT_CAT_AND_CAT_PATH = "select count(*) from AfCbsPartnerCommission afpc where afpc.afCbsPartner.prtNo=:partNo and afpc.afCbsPartnerCategory.prtCatNo=:partCatNo and afpc.activationDate>:fromDate and afpc.afCbsPartnerProduct.prtPrdNo is null and afpc.categoryPath=:catPath and afpc.productBrand is null";

	public static final String AF_COMMISION_EXISTENCE_STARTDATE_WITH_PRT_AND_CAT_PATH = "select count(*) from AfCbsPartnerCommission afpc where afpc.afCbsPartner.prtNo=:partNo and afpc.afCbsPartnerCategory.prtCatNo is null and afpc.activationDate>:fromDate and afpc.afCbsPartnerProduct.prtPrdNo is null and afpc.categoryPath=:catPath and afpc.productBrand is null";

	// EDIT START DATE FOR COMMISION
	/*
	 * public static final String
	 * AF_COMMISION_EXISTENCE_EDIT_STARTDATE_WITH_PRT_NO="select count(*) from AfPartnerCommission afpc where afpc.prtCommNo!=:partComNo and afpc.afPartner.prtNo=:partNo and afpc.deactivationDate>=:fromDate and afpc.afPartnerCategory.prtCatNo is null and afpc.afPartnerProduct.prtPrdNo is null and afpc.productBrand is null"
	 * ; public static final String
	 * AF_COMMISION_EXISTENCE_EDIT_STARTDATE_WITH_PRT_CAT_NO="select count(*) from AfPartnerCommission afpc where afpc.prtCommNo!=:partComNo and afpc.afPartner.prtNo=:partNo and afpc.afPartnerCategory.prtCatNo=:partCatNo and afpc.deactivationDate>=:fromDate and afpc.afPartnerProduct.prtPrdNo is null and afpc.productBrand is null"
	 * ; public static final String
	 * AF_COMMISION_EXISTENCE_EDIT_STARTDATE_WITH_PRODUCT="select count(*) from AfPartnerCommission afpc where afpc.prtCommNo!=:partComNo and afpc.afPartner.prtNo=:partNo and afpc.afPartnerCategory.prtCatNo=:partCatNo and afpc.afPartnerProduct.prtPrdNo=:partPrdNo and afpc.deactivationDate>=:fromDate and afpc.productBrand is null"
	 * ; public static final String
	 * AF_COMMISION_EXISTENCE_EDIT_STARTDATE_WITH_BRAND="select count(*) from AfPartnerCommission afpc where afpc.prtCommNo!=:partComNo and afpc.afPartner.prtNo=:partNo and afpc.afPartnerCategory.prtCatNo=:partCatNo and afpc.productBrand=:brandName and afpc.deactivationDate>=:fromDate and afpc.afPartnerProduct.prtPrdNo is null"
	 * ;
	 */

	public static final String AF_COMMISION_EXISTENCE_EDIT_STARTDATE_WITH_PRT_NO = "select MAX(afpc.deactivationDate) from AfCbsPartnerCommission afpc where afpc.prtCommNo!=:partComNo and afpc.afCbsPartner.prtNo=:partNo and afpc.afCbsPartnerCategory.prtCatNo is null and afpc.afCbsPartnerProduct.prtPrdNo is null and afpc.productBrand is null and afpc.categoryPath is null and afpc.deactivationDate<:startDateHidden";

	public static final String AF_COMMISION_EXISTENCE_EDIT_STARTDATE_WITH_PRT_CAT_NO = "select MAX(afpc.deactivationDate) from AfCbsPartnerCommission afpc where afpc.prtCommNo!=:partComNo and afpc.afCbsPartner.prtNo=:partNo and afpc.afCbsPartnerCategory.prtCatNo=:partCatNo and afpc.afCbsPartnerProduct.prtPrdNo is null and afpc.productBrand is null and afpc.categoryPath is null and afpc.deactivationDate<:startDateHidden";

	public static final String AF_COMMISION_EXISTENCE_EDIT_STARTDATE_WITH_PRODUCT = "select MAX(afpc.deactivationDate) from AfCbsPartnerCommission afpc where afpc.prtCommNo!=:partComNo and afpc.afCbsPartner.prtNo=:partNo and afpc.afCbsPartnerCategory.prtCatNo=:partCatNo and afpc.afCbsPartnerProduct.prtPrdNo=:partPrdNo and afpc.productBrand is null and afpc.categoryPath is null and afpc.deactivationDate<:startDateHidden";

	public static final String AF_COMMISION_EXISTENCE_EDIT_STARTDATE_WITH_BRAND = "select MAX(afpc.deactivationDate) from AfCbsPartnerCommission afpc where afpc.prtCommNo!=:partComNo and afpc.afCbsPartner.prtNo=:partNo and afpc.afCbsPartnerCategory.prtCatNo=:partCatNo and afpc.productBrand=:brandName and afpc.afCbsPartnerProduct.prtPrdNo is null and afpc.categoryPath is null and afpc.deactivationDate<:startDateHidden";

	public static final String AF_COMMISION_EXISTENCE_EDIT_STARTDATE_WITH_BRAND_AND_CAT_PATH = "select MAX(afpc.deactivationDate) from AfCbsPartnerCommission afpc where afpc.prtCommNo!=:partComNo and afpc.afCbsPartner.prtNo=:partNo and afpc.afCbsPartnerCategory.prtCatNo=:partCatNo and afpc.productBrand=:brandName and afpc.afCbsPartnerProduct.prtPrdNo is null and afpc.categoryPath=:catPath and afpc.deactivationDate<:startDateHidden";

	public static final String AF_COMMISION_EXISTENCE_EDIT_STARTDATE_WITH_PRT_CAT_AND_CAT_PATH = "select MAX(afpc.deactivationDate) from AfCbsPartnerCommission afpc where afpc.prtCommNo!=:partComNo and afpc.afCbsPartner.prtNo=:partNo and afpc.afCbsPartnerCategory.prtCatNo=:partCatNo and afpc.productBrand is null and afpc.afCbsPartnerProduct.prtPrdNo is null and afpc.categoryPath=:catPath and afpc.deactivationDate<:startDateHidden";

	public static final String AF_COMMISION_EXISTENCE_EDIT_STARTDATE_WITH_PRT_AND_CAT_PATH = "select MAX(afpc.deactivationDate) from AfCbsPartnerCommission afpc where afpc.prtCommNo!=:partComNo and afpc.afCbsPartner.prtNo=:partNo and afpc.afCbsPartnerCategory.prtCatNo is null and afpc.productBrand is null and afpc.afCbsPartnerProduct.prtPrdNo is null and afpc.categoryPath=:catPath and afpc.deactivationDate<:startDateHidden";

	public static final String AF_COMMISION_EXISTENCE_STARTDATE_ENDDATE = "select count(*) from AfCbsPartnerCommission afpc where afpc.afCbsPartner.prtNo=:partNo and afpc.afCbsPartnerCategory.prtCatNo=:partCatNo and afpc.afCbsPartnerProduct.prtPrdNo=:partPdctNo and afpc.deactivationDate>:newtodate";

	public static final String AF_COMMISION_EXISTENCE_STARTDATE_ENDDATE_WITHOUT_PRODUCT = "select count(*) from AfCbsPartnerCommission afpc where afpc.afCbsPartner.prtNo=:partNo and afpc.afCbsPartnerCategory.prtCatNo=:partCatNo and afpc.afCbsPartnerProduct.prtPrdNo IS null and afpc.deactivationDate > :newtodate";

	public static final String AF_COMMISION_EXISTENCE = "select max(afpc.prtCommNo) from AfCbsPartnerCommission afpc where afpc.afPartner.prtNo=:partNo and afpc.afCbsPartnerCategory.prtCatNo=:partCatNo and afpc.afCbsPartnerProduct.prtPrdNo=:partPdctNo";

	public static final String AF_COMMISION_EXISTENCE_WITHOUT_PRODUCT = "select max(afpc.prtCommNo) from AfCbsPartnerCommission afpc where afpc.afCbsPartner.prtNo=:partNo and afpc.afCbsPartnerCategory.prtCatNo=:partCatNo and afpc.afCbsPartnerProduct.prtPrdNo IS null";

	public static final String AF_GET_TRANSACTION_ID = "from AfCbsTransaction aft where aft.status=1";

	public static final String AF_TRANSACTION_DETAILS = "select aftd.partnerId as partnerId,aftd.transactionDate as transactionDate,aftd.partnerItemId as partnerItemId, aftd.milesPostingDate as milesPostingDate,aftd.partnerProductId as partnerProductId,aftd.productStatus as productStatus, aftd.price as price, aftd.jpmilesToCredit as jpmilesToCredit, aftd.expectedDateOfCredit as expectedDateOfCredit  from AfCbsTransactionDetails aftd,AfCbsTransaction aft where aftd.afCbsTransaction.transactionId=aft.transactionId and aftd.afCbsTransaction.transactionId=:transactionId and aftd.status=1";

	public static final String AF_PARTNER_PRODUCT_NAME = "from AfCbsPartnerProduct afpproduct where afpproduct.productId=:productId";

	public static final String AF_OFFERS_DEALS = "select afpo from AfCbsPartnerOffer afpo where afpo.status=1 order by afpo.prtOffrNo desc";

	public static final String AF_OFFERS_DEALS_COUNT = "select count(*) from AfCbsPartnerOffer afpo where afpo.status=1";

	// public static final String AF_CHECK_OFFER_NAME = "select afod from
	// AfOffersDeals afod where afod.afPartner.prtNo=:prtNo and
	// afod.afPartnerOffer.prtOffrNo=:offerId and afod.status=1";

	public static final String AF_CHECK_OFFER_SORT_ORDER = "select afpo from AfCbsPartnerOffer afpo where afpo.offerPosition=:offersDealsSortOrder and afpo.status=1";

	// public static final String AF_SEARCHED_OFFER_BY_CATEGORY = "select afod
	// from AfOffersDeals afod where afod.afPartner.prtNo=:prtNo and
	// afod.afPartnerCategory.prtCatNo=:partCatNo and afod.status=1";

	public static final String AF_OFFER_NAMES_BY_CATEGORY = "select afop from AfCbsPartnerOffer afop where afop.afCbsPartnerCategory.prtCatNo=:prtCatNo and afop.afCbsPartner.prtNo=:prtNo and afop.status=1";

	public static final String AF_PARTNER_OFFER_DETAILS = "select afpo from AfCbsPartnerOffer afpo where afpo.afCbsPartner.prtNo=:prtNo and afpo.status=1";

	public static final String AF_PARTNER_OFFER_BY_PRTOFFRNO = "select afpo from AfCbsPartnerOffer afpo where afpo.prtOffrNo=:prtOffrNo and afpo.afCbsPartner.prtNo=:prtNo and afpo.status=1";

	public static final String AF_PARTNER_OFFER_BY_PRTCATNO = "select afpo from AfCbsPartnerOffer afpo where afpo.afCbsPartnerCategory.prtCatNo=:prtCatNo and afpo.afCbsPartner.prtNo=:prtNo and afpo.status=1";

	public static final String AF_PARTNER_OFFER_BY_PRT_NO_AND_CAT_NO = "select afpo from AfCbsPartnerOffer afpo where afpo.afCbsCategory.catNo=:catNo and afpo.afCbsPartner.prtNo=:prtNo and afpo.status=1";

	public static final String AF_PARTNER_CATEGORY_NO_BY_NAME = "select afpc from AfCbsPartnerCategory afpc where afpc.afCbsPartner.prtNo=:prtNo  and afpc.partnerCategoryName=:catName and afpc.status=1";

	public static final String AF_PARTNER_OFFER_BY_PRTNO = "select afpo from AfCbsPartnerOffer afpo where afpo.afCbsPartner.prtNo=:prtNo and afpo.status=1 order by -afpo.offerPosition desc";

	public static final String AF_PARTNER_OFFER_BY_NAME = "select afpo from AfCbsPartnerOffer afpo where afpo.status=1";

	// With offer name
	public static final String AF_PARTNER_OFFER_BY_PRTNO_OFFRNAME = "select afpo from AfCbsPartnerOffer afpo where afpo.afCbsPartner.prtNo=:prtNo and afpo.offerName=:searchByValue and afpo.status=1 order by -afpo.offerPosition desc";

	public static final String AF_PARTNER_OFFER_BY_OFFRNAME = "select afpo from AfCbsPartnerOffer afpo where afpo.offerName=:searchByValue and afpo.status=1 order by -afpo.offerPosition desc";

	// With Desc
	public static final String AF_PARTNER_OFFER_BY_PRTNO_DESC = "select afpo from AfCbsPartnerOffer afpo where afpo.afCbsPartner.prtNo=:prtNo and afpo.description=:searchByValue and afpo.status=1 order by -afpo.offerPosition desc";

	public static final String AF_PARTNER_OFFER_BY_DESC = "select afpo from AfCbsPartnerOffer afpo where afpo.description=:searchByValue and afpo.status=1 order by -afpo.offerPosition desc";

	// With Category name
	public static final String AF_PARTNER_OFFER_BY_PRTNO_CATNAME = "select afpo from AfCbsPartnerOffer afpo where afpo.afCbsPartner.prtNo=:prtNo and afpo.afCbsCategory.catNo=:catNo and afpo.status=1 order by -afpo.offerPosition desc";

	public static final String AF_PARTNER_OFFER_BY_CATNAME = "select afpo from AfCbsPartnerOffer afpo where afpo.afCbsCategory.catNo=:catNo and afpo.status=1 order by -afpo.offerPosition desc";

	/*
	 * public static final String AF_PARTNER_OFFER_BY_OFFRNO =
	 * "select afpo from AfPartnerOffer afpo where afpo.prtOffrNo=:prtOffrNo and afpo.status=1"
	 * ; public static final String AF_PARTNER_OFFER_BY_NAME =
	 * "select afpo from AfPartnerOffer afpo where afpo.offerStatus=1 and afpo.status=1"
	 * ;
	 */

	public static final String Af_GET_ROLE_PERMISSIONS_BY_ID = "select afarp from AfCbsAdminRolePermissions iparp where afarp.afCbsAdminRoles=:roleId";

	/*
	 * public static final String
	 * AF_RECOMMENDED_PRODUCT_BY_NO="select afrp from AfRecommendedProduct afrp where afrp.afPartner.prtNo=:prtNo and afrp.status=1"
	 * ;
	 */
	public static final String AF_RECOMMENDED_CATEGORY_BY_NO = "select afrc from AfCbsRecommendedCategory afrc where afrc.afCbsPartner.prtNo=:prtNo and afrc.status=1";

	public static final String GET_PRT_CAT_NO_PRICE_RANGE_FILTER = "select afpr from AfCbsPriceRangeFilter afpr where afpr.prtCatNo=:prt_cat_no and afpr.status=1";

	/************ Reports start *******************/
	/*
	 * public static final String GET_BUSINESS_REPORT =
	 * "select new com.af.admin.beans.BuisnessReportsBean(tr.jpNumber,td.transactionId,td.transactionDate,pr.partnerName,pc.partnerCategoryName,pp.productName,td.price,td.ratePerMile,td.commissionRate,td.memberShare,td.jpmilesPurchase,td.expectedDateOfCredit,td.jpmilesCancel,td.jpmilesToCredit,td.productStatus)"
	 * +"from AfTransactionDetails td,AfTransaction tr,AfPartnerProduct pp,AfPartnerCategory pc,AfPartner pr where td.afTransaction.txnNo = tr.txnNo and td.partnerProductId = pp.productId and pp.afPartnerCategory = pc.prtCatNo and pc.afPartner = pr.prtNo and pr.partnerName=:partnerName and date(td.transactionDate) between :fromDate and :toDate"
	 * ;
	 * 
	 * public static final String GET_BUSINESS_REPORT_WITH_JPNUMBER =
	 * "select new com.af.admin.beans.BuisnessReportsBean(tr.jpNumber,td.transactionId,td.transactionDate,pr.partnerName,pc.partnerCategoryName,pp.productName,td.price,td.ratePerMile,td.commissionRate,td.memberShare,td.jpmilesPurchase,td.expectedDateOfCredit,td.jpmilesCancel,td.jpmilesToCredit,td.productStatus)"
	 * +"from AfTransactionDetails td,AfTransaction tr,AfPartnerProduct pp,AfPartnerCategory pc,AfPartner pr where td.afTransaction.txnNo = tr.txnNo and td.partnerProductId = pp.productId and pp.afPartnerCategory = pc.prtCatNo and pc.afPartner = pr.prtNo and pr.partnerName=:partnerName and date(td.transactionDate) between :fromDate and :toDate and tr.jpNumber=:jpNumber"
	 * ;
	 */

	/*
	 * public static final String GET_SHOP_JP_REPORT_INFO =
	 * "select new com.af.admin.beans.BuisnessReportsBean(tr.jpNumber,td.transactionId,td.transactionDate,pr.partnerName,pc.partnerCategoryName,pp.productName,td.price,td.ratePerMile,td.commissionRate,td.memberShare,td.jpmilesPurchase,td.expectedDateOfCredit,td.jpmilesCancel,td.jpmilesToCredit,td.productStatus)"
	 * +
	 * " from AfTransactionDetails td,AfTransaction tr,AfPartnerProduct pp,AfPartnerCategory pc,AfPartner pr where "
	 * ; public static final String GET_SHOP_JP_REPORT_INFO_JOIN =
	 * " and td.afTransaction.txnNo = tr.txnNo and td.partnerProductId = pp.productId and"
	 * + " pp.afPartnerCategory = pc.prtCatNo and pc.afPartner = pr.prtNo";
	 */

	public static final String GET_BUSINESS_REPORT = "select tr.UNIQUE_ID,(case when tr.PRT_PRD_NO is not null then (select PRODUCT_NAME from AF_CBS_PARTNER_PRODUCT where PRT_PRD_NO=tr.PRT_PRD_NO) else 'NA' end) as product_name,(case when tr.PRT_PRD_NO is not null then (select category_name from AF_CBS_CATEGORY where CAT_NO in (select CAT_NO FROM AF_CBS_PARTNER_CATEGORY WHERE PRT_CAT_NO IN (SELECT PRT_CAT_NO FROM AF_CBS_PARTNER_PRODUCT WHERE PRT_PRD_NO=tr.PRT_PRD_NO))) ELSE 'NA' END) as category_name,td.TRANSACTION_ID,td.CREATED_TIME,(select PARTNER_NAME from AF_CBS_PARTNER where PARTNER_ID=td.PARTNER_ID) as PARTNER_NAME,td.PRICE,td.RATE_PER_CASH_BACK,td.COMMISSION_RATE,td.MEMBER_SHARE,td.CASH_BACK_PURCHASE,td.EXPECTED_DATE_OF_CREDIT,td.CASH_BACK_CANCEL,td.CASH_BACK_TO_CREDIT,td.PRODUCT_STATUS,td.PARTNER_PRODUCT_ID from AF_CBS_TRANSACTION_DETAILS td,AF_CBS_TRANSACTION tr where td.TXN_NO = tr.TXN_NO and ";
	/*
	 * public static final String GET_BUSINESS_REPORT_WITH_JPNUMBER =
	 * "select new com.af.admin.beans.BuisnessReportsBean(tr.jpNumber,td.transactionId,td.transactionDate,td.partnerId,td.partnerId,td.partnerId,td.price,td.ratePerMile,td.commissionRate,td.memberShare,td.jpmilesPurchase,td.expectedDateOfCredit,td.jpmilesCancel,td.jpmilesToCredit,td.productStatus,td.partnerProductId)"
	 * +"from AfTransactionDetails td,AfTransaction tr where td.afTransaction.txnNo = tr.txnNo and td.partnerId=:partnerName and date(td.transactionDate) between :fromDate and :toDate and tr.jpNumber=:jpNumber"
	 * ;
	 */

	public static final String GET_NEW_PRODUCTS_REPORT_BRANDS_BY_PRODUCTS = "select afpp.productBrand from AfCbsPartnerProduct afpp, AfCbsPartner afp where afpp.status=1 and afpp.productStatus=1 and (date(afpp.createdTime) between :toDate and :fromDate or date(afpp.modifiedTime) between :toDate and :fromDate) and afpp.afCbsPartner.prtNo=afp.prtNo";

	public static final String GET_NEW_PRODUCTS_REPORT_PARTNERS_BY_PRODUCTS = "select distinct afp.partnerName, afp.prtNo from AfCbsPartnerProduct afpp, AfCbsPartner afp where afpp.status = 1 and afpp.productStatus = 1 and afpp.afCbsPartner.prtNo = afp.prtNo";

	public static final String GET_NEW_PRODUCTS_REPORT = "select afpp from AfCbsPartnerProduct afpp where afpp.status=1 and afpp.productStatus=1 and afpp.productBrand=:productBrand and afpp.afCbsPartner.prtNo=:prtNo and (date(afpp.createdTime) between :toDate and :fromDate or date(afpp.modifiedTime) between :toDate and :fromDate)";

	public static final String GET_MAPPED_PRODUCTS_REPORT = "select distinct afp from AfCbsProduct afp, AfCbsPartnerProduct afpp where afp.productStatus=1 and afp.status=1 and afp.partnerCount > 1";

	public static final String GET_MAPPED_PRODUCTS_REPORT_JOIN = " and afp.masterProductId = afpp.afCbsProduct.masterProductId";

	/************ Reports end *******************/

	// Phase 2 Query starts..................
	// public static final String AF_LOGO_PARTNER_DISPLAY_ORDER_CHECK="select
	// afp from AfPartner afp where afp.partnerPosition=:prtPos and
	// afp.logoPartner=1 and afp.status=1";
	public static final String AF_LOGO_PARTNER_DISPLAY_ORDER_CHECK = "select afp from AfCbsPartner afp where afp.partnerPosition=:prtPos and afp.status=1";

	public static final String AF_OFFLINE_PARTNER_DISPLAY_ORDER_CHECK = "select afp from AfCbsPartner afp where afp.partnerPosition=:prtPos and afp.status=1 and afp.offLinePartner=1";

	public static final String AF_LOGO_PARTNER_TILE_POS_CHECK = "select afp from AfCbsPartner afp where afp.logoPartnerPosition=:prtPos and afp.logoPartner=1 and afp.status=1";

	public static final String AF_OFFLINE_PARTNER_TILE_POS_CHECK = "select afp from AfCbsPartner afp where afp.logoPartnerPosition=:prtPos and afp.offLinePartner=1 and afp.status=1";

	public static final String AF_HOST_PARTNERS = "select ap from AfCbsPartner ap where ap.status=1 and ap.hostPartner=1 order by ap.prtNo desc";

	public static final String AF_HOST_PARTNERS_COUNT = "select count(*) from AfCbsPartner ap where ap.status=1 and ap.hostPartner=1";

	public static final String AF_LOGO_PARTNERS = "select ap from AfCbsPartner ap where ap.status=1 and ap.logoPartner=1 order by ap.prtNo desc";
	public static final String AF_LOGO_PARTNERS_COUNT = "select count(*) from AfCbsPartner ap where ap.status=1 and ap.logoPartner=1";

	public static final String AF_OFFLINE_PARTNERS = "select ap from AfCbsPartner ap where ap.status=1 and ap.offLinePartner=1 order by ap.prtNo desc";
	public static final String AF_OFFLINE_PARTNERS_COUNT = "select count(*) from AfCbsPartner ap where ap.status=1 and ap.offLinePartner=1";

	public static final String AF_DEFAULT_PARTNERS = "select ap from AfCbsPartner ap where ap.status=1 and ap.defaultPartner=1 order by ap.prtNo desc";
	public static final String AF_DEFAULT_PARTNERS_COUNT = "select count(*) from AfCbsPartner ap where ap.status=1 and ap.defaultPartner=1";

	public static final String AF_CATEGORY_MAX_CAT_NO = "select max(afcc.catNo) from AfCbsCategory afcc";

	public static final String AF_PRICE_RANGE_FILTER_BY_CAT_NO = "select afpr from AfCbsPriceRangeFilter afpr where afpr.catNo=:condition and afpr.status=1";

	public static final String GET_AF_PRICE_RANGE_FILTER_BY_CAT_NO = "select afpr from AfCbsPriceRangeFilter afpr where afpr.catNo=:condition and afpr.status=1";

	// public static final String GET_CATEGORY_ROW_COUNT_BY_CAT_ID = "select
	// count(*) from AfCategory where length(categoryId)=3 order by categoryId";
	// public static final String GET_SUB_CATEGORY_ROW_COUNT_BY_CAT_ID = "select
	// count(*) from AfCategory where categoryId like :condition order by
	// categoryId";

	public static final String GET_MAX_CATEGORY_ID = "select max(categoryId) from AfCbsCategory where length(categoryId)=3";

	public static final String GET_MAX_SUB_CATEGORY_ID = "select max(substring(categoryId, -3)) from AfCbsCategory where categoryId like :condition";

	public static final String GET_CATEGORY_COUNT_BY_CAT_NAME = "select count(*) from AfCbsCategory where lower(categoryName)=:condition and status=1";

	public static final String GET_CATEGORY_BY_CAT_ID = "select afcc from AfCbsCategory afcc where afcc.categoryId like :condition order by afcc.categoryId";

	public static final String AF_PARTNERS_BY_DEFAULT_AND_HOST = "select ap from AfCbsPartner ap where (ap.defaultPartner=1 or ap.hostPartner=1) and ap.status=1";

	public static final String AF_CATEGORY_DISPLAY_ORDER_CHECK = "select count(*) from AfCbsCategory where gqcDisplayOrder=:displayOrder and status=1";

	public static final String AF_PARTNER_KEYWORDS_FILE_NAME = "select afk from AfCbsPartnerKeyword afk where afk.status=1 and afk.afCbsPartner.prtNo=:logoPrtNo";

	public static final String AF_PARTNER_DELETE_KEYWORD = "delete AfCbsPartnerKeyword afk where afk.afCbsPartner.prtNo=:prtNo";

	// public static final String AF_LOGO_PARTNER_SAVE_CONFIG=" update AfPartner
	// afp set afp.logoPartnerTilePosition=:tileNo,
	// afp.logoPartnerDispLimit=:totalLogoPartner where afp.logoPartner=1 and
	// afp.status=1";
	public static final String AF_LOGO_PARTNER_SAVE_CONFIG = " update AfCbsPartner afp set afp.logoPartnerTilePosition=:tileNo where afp.logoPartner=1 and afp.status=1";

	public static final String AF_RECOMMENDED_CATEGORY_BY_CATNO = "select afrc from AfCbsRecommendedCategory afrc where afrc.afCbsCategory.catNo=:rcCatno and afrc.status=1";

	public static final String AF_OFFERS_DEALS_BY_PRT_NO = "select afpo from AfCbsPartnerOffer afpo where afpo.status=1 and afpo.afCbsPartner.prtNo=:prtNo";

	public static final String AF_GET_CONTENT_MANAGMENT = "select ac from AfCbsEmailManagement ac where ac.status=1";

	public static final String AF_GET_CONTENT_BY_TYPE = "select ac from AfCbsEmailManagement ac where ac.contentType=:contentType and ac.status=1";

	public static final String GET_PARTNER_CATEGORY_BY_NO = "select afpc from AfCbsPartnerCategory afpc where afpc.afCbsPartner.prtNo=:prtNo and afpc.status=1";

	public static final String GET_CAT_NO_COUNT_FROM_AF_PARTNER_OFFER = "select count(*) from AfCbsPartnerOffer where afCbsCategory.catNo=:catNo and status=1";

	public static final String GET_CAT_NO_COUNT_FROM_AF_PARTNER_KEYWORD = "select count(*) from AfCbsPartnerKeyword where afCbsCategory.catNo=:catNo and status=1";

	public static final String GET_CAT_NO_COUNT_FROM_AF_RECOMMENDED_CATEGORY = "select count(*) from AfCbsRecommendedCategory where afCbsCategory.catNo=:catNo and status=1";

	public static final String GET_CAT_NO_COUNT_FROM_AF_PARTNER_CATEGORY = "select count(*) from AfCbsPartnerCategory where afCbsCategory.catNo=:catNo and status=1";

	public static final String GET_AF_CATEGORY_BY_CATEGORY_ID = "select afc from AfCbsCategory afc where categoryId=:categoryID and status=1";

	public static final String AF_COMMISION_EXISTENCE_WITH_PRT_NO = "select max(afpc.prtCommNo) from AfCbsPartnerCommission afpc where afpc.afCbsPartner.prtNo=:partNo and afpc.afCbsPartnerCategory.prtCatNo is null and afpc.afCbsPartnerProduct.prtPrdNo is null and afpc.productBrand is null and afpc.categoryPath is null";

	public static final String AF_COMMISION_EXISTENCE_WITH_PRT_NO_AND_PRT_CAT_NO = "select max(afpc.prtCommNo) from AfCbsPartnerCommission afpc where afpc.afCbsPartner.prtNo=:partNo and afpc.afCbsPartnerCategory.prtCatNo=:prtCatNo and afpc.afCbsPartnerProduct.prtPrdNo is null and afpc.productBrand is null and afpc.categoryPath is null";

	public static final String AF_COMMISION_EXISTENCE_WITH_PRT_NO_AND_PRT_CAT_NO_AND_CAT_PATH = "select max(afpc.prtCommNo) from AfCbsPartnerCommission afpc where afpc.afCbsPartner.prtNo=:partNo and afpc.afCbsPartnerCategory.prtCatNo=:prtCatNo and afpc.afCbsPartnerProduct.prtPrdNo is null and afpc.productBrand is null and afpc.categoryPath=:catpath";

	public static final String AF_COMMISION_EXISTENCE_WITH_PRT_NO_AND_PRT_CAT_NO_AND_PRT_PRD_NO = "select max(afpc.prtCommNo) from AfCbsPartnerCommission afpc where afpc.afCbsPartner.prtNo=:partNo and afpc.afCbsPartnerCategory.prtCatNo=:prtCatNo and afpc.afCbsPartnerProduct.prtPrdNo=:prtPrdNo and afpc.productBrand is null and afpc.categoryPath is null";

	public static final String AF_COMMISION_EXISTENCE_WITH_PRT_NO_AND_PRT_CAT_NO_AND_BRAND_NAME = "select max(afpc.prtCommNo) from AfCbsPartnerCommission afpc where afpc.afCbsPartner.prtNo=:partNo and afpc.afCbsPartnerCategory.prtCatNo=:prtCatNo and afpc.afCbsPartnerProduct.prtPrdNo is null and afpc.productBrand=:productBrand and afpc.categoryPath is null";

	public static final String AF_COMMISION_EXISTENCE_WITH_PRT_NO_AND_PRT_CAT_NO_AND_CATPATH = "select max(afpc.prtCommNo) from AfCbsPartnerCommission afpc where afpc.afCbsPartner.prtNo=:partNo and afpc.afCbsPartnerCategory.prtCatNo=:prtCatNo and afpc.afCbsPartnerProduct.prtPrdNo is null and afpc.productBrand is null  and afpc.categoryPath is null and afpc.categoryPath=:catpath";

	public static final String AF_COMMISION_EXISTENCE_WITH_PRT_NO_AND_PRT_CAT_NO_AND_BRAND_NAME_AND_CAT_PATH = "select max(afpc.prtCommNo) from AfCbsPartnerCommission afpc where afpc.afCbsPartner.prtNo=:partNo and afpc.afCbsPartnerCategory.prtCatNo=:prtCatNo and afpc.afCbsPartnerProduct.prtPrdNo is null and afpc.productBrand=:productBrand and afpc.categoryPath=:catpath";

	public static final String AF_COMMISION_EXISTENCE_ENDDATE_WITH_PRT_NO = "select count(*) from AfCbsPartnerCommission afpc where afpc.afCbsPartner.prtNo=:partNo and afpc.deactivationDate>:newtodate and afpc.afCbsPartnerCategory.prtCatNo is null and afpc.afCbsPartnerProduct.prtPrdNo is null and afpc.productBrand is null and afpc.categoryPath is null";

	public static final String AF_COMMISION_EXISTENCE_ENDDATE_WITH_PRT_CAT_NO = "select count(*) from AfCbsPartnerCommission afpc where afpc.afCbsPartner.prtNo=:partNo and afpc.afCbsPartnerCategory.prtCatNo=:partCatNo and afpc.deactivationDate>:newtodate and afpc.afCbsPartnerProduct.prtPrdNo is null and afpc.productBrand is null and afpc.categoryPath is null";

	public static final String AF_COMMISION_EXISTENCE_ENDDATE_WITH_PRODUCT = "select count(*) from AfCbsPartnerCommission afpc where afpc.afCbsPartner.prtNo=:partNo and afpc.afCbsPartnerCategory.prtCatNo=:partCatNo and afpc.afCbsPartnerProduct.prtPrdNo=:partPrdNo and afpc.deactivationDate>:newtodate and afpc.productBrand is null and afpc.categoryPath is null";

	public static final String AF_COMMISION_EXISTENCE_ENDDATE_WITH_BRAND = "select count(*) from AfCbsPartnerCommission afpc where afpc.afCbsPartner.prtNo=:partNo and afpc.afCbsPartnerCategory.prtCatNo=:partCatNo and afpc.productBrand=:brandName and afpc.deactivationDate>:newtodate and afpc.afCbsPartnerProduct.prtPrdNo is null and afpc.categoryPath is null";

	public static final String AF_COMMISION_EXISTENCE_ENDDATE_WITH_BRAND_AND_CAT_PATH = "select count(*) from AfCbsPartnerCommission afpc where afpc.afCbsPartner.prtNo=:partNo and afpc.afCbsPartnerCategory.prtCatNo=:partCatNo and afpc.productBrand=:brandName and afpc.deactivationDate>:newtodate and afpc.afCbsPartnerProduct.prtPrdNo is null and afpc.categoryPath=:catPath";

	public static final String AF_COMMISION_EXISTENCE_ENDDATE_WITH_PRT_CAT_AND_CAT_PATH = "select count(*) from AfCbsPartnerCommission afpc where afpc.afCbsPartner.prtNo=:partNo and afpc.afCbsPartnerCategory.prtCatNo=:partCatNo and afpc.productBrand is null and afpc.deactivationDate>:newtodate and afpc.afCbsPartnerProduct.prtPrdNo is null and afpc.categoryPath=:catPath";

	public static final String AF_COMMISION_EXISTENCE_ENDDATE_WITH_PRT_AND_CAT_PATH = "select count(*) from AfCbsPartnerCommission afpc where afpc.afCbsPartner.prtNo=:partNo and afpc.afCbsPartnerCategory.prtCatNo is null and afpc.productBrand is null and afpc.deactivationDate>:newtodate and afpc.afCbsPartnerProduct.prtPrdNo is null and afpc.categoryPath=:catPath";

	/*
	 * //EDIT END DATE FOR COMMISION public static final String
	 * AF_COMMISION_EXISTENCE_EDIT_ENDDATE_WITH_PRT_NO="select MAX(afpc.activationDate) from AfPartnerCommission afpc where afpc.prtCommNo!=:partComNo and afpc.afPartner.prtNo=:partNo and afpc.afPartnerCategory.prtCatNo is null and afpc.afPartnerProduct.prtPrdNo is null and afpc.productBrand is null and afpc.activationDate<:endDate"
	 * ; public static final String
	 * AF_COMMISION_EXISTENCE_EDIT_ENDDATE_WITH_PRT_CAT_NO="select MAX(afpc.activationDate) from AfPartnerCommission afpc where afpc.prtCommNo!=:partComNo and afpc.afPartner.prtNo=:partNo and afpc.afPartnerCategory.prtCatNo=:partCatNo and afpc.afPartnerProduct.prtPrdNo is null and afpc.productBrand is null"
	 * ; public static final String
	 * AF_COMMISION_EXISTENCE_EDIT_ENDDATE_WITH_PRODUCT="select MAX(afpc.activationDate) from AfPartnerCommission afpc where afpc.prtCommNo!=:partComNo and afpc.afPartner.prtNo=:partNo and afpc.afPartnerCategory.prtCatNo=:partCatNo and afpc.afPartnerProduct.prtPrdNo=:partPrdNo  and afpc.productBrand is null"
	 * ; public static final String
	 * AF_COMMISION_EXISTENCE_EDIT_ENDDATE_WITH_BRAND="select MAX(afpc.activationDate) from AfPartnerCommission afpc where afpc.prtCommNo!=:partComNo and afpc.afPartner.prtNo=:partNo and afpc.afPartnerCategory.prtCatNo=:partCatNo and afpc.productBrand=:brandName and afpc.afPartnerProduct.prtPrdNo is null"
	 * ;
	 */
	// EDIT END DATE FOR COMMISION
	public static final String AF_COMMISION_EXISTENCE_EDIT_ENDDATE_WITH_PRT_NO = "select MIN(afpc.activationDate) from AfCbsPartnerCommission afpc where afpc.prtCommNo!=:partComNo and afpc.afCbsPartner.prtNo=:partNo and afpc.afCbsPartnerCategory.prtCatNo is null and afpc.afCbsPartnerProduct.prtPrdNo is null and afpc.productBrand is null and afpc.categoryPath is null and afpc.activationDate>:endDateHidden";

	public static final String AF_COMMISION_EXISTENCE_EDIT_ENDDATE_WITH_PRT_CAT_NO = "select MIN(afpc.activationDate) from AfCbsPartnerCommission afpc where afpc.prtCommNo!=:partComNo and afpc.afCbsPartner.prtNo=:partNo and afpc.afCbsPartnerCategory.prtCatNo=:partCatNo and afpc.afCbsPartnerProduct.prtPrdNo is null and afpc.productBrand is null and afpc.categoryPath is null and afpc.activationDate>:endDateHidden";

	public static final String AF_COMMISION_EXISTENCE_EDIT_ENDDATE_WITH_PRODUCT = "select MIN(afpc.activationDate) from AfCbsPartnerCommission afpc where afpc.prtCommNo!=:partComNo and afpc.afCbsPartner.prtNo=:partNo and afpc.afCbsPartnerCategory.prtCatNo=:partCatNo and afpc.afCbsPartnerProduct.prtPrdNo=:partPrdNo  and afpc.productBrand is null and afpc.categoryPath is null and afpc.activationDate>:endDateHidden";

	public static final String AF_COMMISION_EXISTENCE_EDIT_ENDDATE_WITH_BRAND = "select MIN(afpc.activationDate) from AfCbsPartnerCommission afpc where afpc.prtCommNo!=:partComNo and afpc.afCbsPartner.prtNo=:partNo and afpc.afCbsPartnerCategory.prtCatNo=:partCatNo and afpc.productBrand=:brandName and afpc.afCbsPartnerProduct.prtPrdNo is null and afpc.categoryPath is null and afpc.activationDate>:endDateHidden";

	public static final String AF_COMMISION_EXISTENCE_EDIT_ENDDATE_WITH_BRAND_AND_CATPATH = "select MIN(afpc.activationDate) from AfCbsPartnerCommission afpc where afpc.prtCommNo!=:partComNo and afpc.afCbsPartner.prtNo=:partNo and afpc.afCbsPartnerCategory.prtCatNo=:partCatNo and afpc.productBrand=:brandName and afpc.afCbsPartnerProduct.prtPrdNo is null and afpc.categoryPath=:catPath and afpc.activationDate>:endDateHidden";

	public static final String AF_COMMISION_EXISTENCE_EDIT_ENDDATE_WITH_PRT_CAT_AND_CATPATH = "select MIN(afpc.activationDate) from AfCbsPartnerCommission afpc where afpc.prtCommNo!=:partComNo and afpc.afCbsPartner.prtNo=:partNo and afpc.afCbsPartnerCategory.prtCatNo=:partCatNo and afpc.productBrand is null and afpc.afCbsPartnerProduct.prtPrdNo is null and afpc.categoryPath=:catPath and afpc.activationDate>:endDateHidden";

	public static final String AF_COMMISION_EXISTENCE_EDIT_ENDDATE_WITH_PRT_AND_CATPATH = "select MIN(afpc.activationDate) from AfCbsPartnerCommission afpc where afpc.prtCommNo!=:partComNo and afpc.afCbsPartner.prtNo=:partNo and afpc.afCbsPartnerCategory.prtCatNo is null and afpc.productBrand is null and afpc.afCbsPartnerProduct.prtPrdNo is null and afpc.categoryPath=:catPath and afpc.activationDate>:endDateHidden";

	public static final String GET_LOGO_PARTNERS_TILE_NUMBER_SEARCH_RESULT = "select distinct afp.logoPartnerTilePosition from AfCbsPartner afp where afp.logoPartner=1 and afp.status=1";

	public static final String AF_PRODUCT_BY_CAT_NO = "select afp from AfCbsProduct afp where afp.afCategory.catNo=:catNo and afp.masterProductId in (select afpp.afCbsProduct.masterProductId from AfCbsPartnerProduct afpp where afpp.productStatus=1 and afpp.status=1 ) and  afp.productStatus=1 and afp.status=1";

	public static final String GET_ALL_SUB_CATEGORIES_BY_CAT_ID = "select afc from AfCbsCategory afc where afc.categoryId like :condition and afc.status=1 order by afc.categoryId";

	public static final String AF_COMMISION_EXISTENCE_EDIT_ENDDATE_WITH_PRT_NO_ = "select afpc.activationDate from AfCbsPartnerCommission afpc where afpc.prtCommNo!=:partComNo and afpc.afCbsPartner.prtNo=:partNo and afpc.afCbsPartnerCategory.prtCatNo is null and afpc.afCbsPartnerProduct.prtPrdNo is null and afpc.productBrand is null and afpc.activationDate>:endDate";

	public static final String IS_CAT_NO_MAPPED_TO_OTHER_TABLES = "select EXISTS (select CAT_NO from AF_CBS_RECOMMENDED_CATEGORY where CAT_NO = ? and status=1) OR EXISTS (select CAT_NO from AF_CBS_PARTNER_CATEGORY where CAT_NO = ? and status=1) OR EXISTS (select CAT_NO from AF_CBS_PARTNER_OFFER where CAT_NO = ? and status=1) OR EXISTS (select CAT_NO from AF_CBS_PARTNER_KEYWORD where CAT_NO = ? and status=1)";

	// public static final String IS_CAT_NO_MAPPED_TO_OTHER_TABLES = "select
	// exists (select apo.afCategory.catNo from AfPartnerOffer apo where
	// apo.afCategory.catNo=:catNo and apo.status=1) or exists (select
	// apk.afCategory.catNo from AfPartnerKeyword apk where
	// apk.afCategory.catNo=:catNo and apk.status=1) or exists (select
	// arc.afCategory.catNo from AfRecommendedCategory arc where
	// arc.afCategory.catNo=:catNo and arc.status=1) or exists (select
	// apca.afCategory.catNo from AfPartnerCategory apca where
	// apca.afCategory.catNo=:catNo and apca.status=1)";

	public static final String AF_BANNER_BY_BANNER_ID = "select banner from AfCbsBanner banner where banner.bannerId=:bannerId";

	public static final String GET_CATEGORY_BY_CAT_NAME = "select afc from AfCbsCategory afc where afc.categoryName=:categoryName";
	public static final String GET_PARTNER_BY_PRT_NAME = "select afp from AfCbsPartner afp where afp.partnerName=:partnerName";

	public static final String GET_BEST_SELLING_CATEGORIES = "select afc.categoryName from AfCbsCategory afc where afc.bestSellingCategory=1";

	public static final String AF_JPMile_SAVE_CONFIG = "Update AfCbsEnumValues set value=:jpMile where typeName=:typeName";

	// Get SEO Data
	public static final String GET_SEO_DATA = "select afs from AfCbsSeo afs where afs.seoPageId is not null and status=1";
	public static final String GET_SEO_DATA_BY_PAGE_ID = "select afs from AfCbsSeo afs where afs.seoPageId=:pageId and status=1";

	public static final String GET_AF_PARTNER_OFFER_BY_COND = "select afpo from AfCbsPartnerOffer afpo where afpo.status=1 ";

	public static final String AF_PARTNERS_BY_ACTIVITY_ID = "select partners from AfCbsPartner partners where partners.activityId=:activityId";

	public static final String AF_OFFERS_DEALS_Sl_NO = "select max(prtOffrNo) from AfCbsPartnerOffer where status=1";

	public static final String AF_SECTIONS_ALL = "select section from AfCbsSections section where section.sectionType=:sectionType and section.status=1";

	public static final String AF_SECTIONS_BY_SECTION = "select section from AfCbsSections section where section.sectId=:sectId and section.status=1";

	public static final String AF_SECTIONS = "select as from AfCbsSections as where as.sectionType=1 and as.sectionStatus=1 and as.status=1";

	public static final String AF_SECTIONS_BY_SECTION_TITLE = "select section from AfCbsSections section where section.sectionTitle=:sectionTitle and section.status=1";

	public static final String AF_SECTION_DISPLAY_ORDER_CHECK = "select afs from AfCbsSections afs where afs.sectionDispOrder=:sectionDispOrder and afs.status=1";

	public static final String AF_SECTION_ITEM = "select si from AfCbsSectionItems si where si.afSections.sectId=:sectId and si.status=1";

	public static final String AF_SECTION_ITEM_BY_ITEM_ID = "select si from AfCbsSectionItems si where si.itemId=:sectionItemId and si.status=1";

	public static final String AF_ENUM_VALUES_BY_ID = "select aev from AfCbsEnumValues aev where aev.typeName=:typeName and aev.intCode=:intCode";

	public static final String AF_SECTION_ITEMS_DISPLAY_ORDER = "select afsi from AfCbsSectionItems afsi where afsi.displayOrder=:displayOrder and afsi.afCbsSections.sectId=:sectionId and afsi.status=1";

	public static final String AF_SECTION_ITEMS_DUPLICATE_RECORD_PRDT = "select afsi from AfCbsSectionItems afsi where afsi.afCbsSections.sectId=:sectionId and afsi.itemType=:itemType and afsi.afCbsPartner.prtNo=:prtNo and afsi.afCbsProduct.masterProductId=:prtPrdctNo and afsi.afCbsCategory.catNo is null and afsi.afCbsPartnerOffer.prtOffrNo is null and afsi.status=1";

	public static final String AF_SECTION_ITEMS_DUPLICATE_RECORD_CAT = "select afsi from AfCbsSectionItems afsi where afsi.afCbsSections.sectId=:sectionId and afsi.itemType=:itemType and afsi.afCbsCategory.catNo=:catNo and afsi.afCbsPartner.prtNo is null and afsi.afCbsProduct.masterProductId is null and afsi.afCbsPartnerOffer.prtOffrNo is null and afsi.status=1";

	public static final String AF_SECTION_ITEMS_DUPLICATE_RECORD_PRT = "select afsi from AfCbsSectionItems afsi where afsi.afCbsSections.sectId=:sectionId and afsi.itemType=:itemType and afsi.afCbsPartner.prtNo=:prtNo and afsi.afCbsCategory.catNo is null and afsi.afCbsProduct.masterProductId is null and afsi.afCbsPartnerOffer.prtOffrNo is null and afsi.status=1";

	public static final String AF_SECTION_ITEMS_DUPLICATE_RECORD_OFFERS_DEALS = "select afsi from AfCbsSectionItems afsi where afsi.afCbsSections.sectId=:sectionId and afsi.itemType=:itemType and afsi.afCbsPartner.prtNo=:prtNo and afsi.afCbsCategory.catNo=:catNo and afsi.afCbsPartnerOffer.prtOffrNo=:prtOfferNo and afsi.afCbsProduct.masterProductId is null and afsi.status=1";

	public static final String GET_ALL_PARTNERS_FOR_WEBSERVICE = "select ap from AfCbsPartner ap order by ap.prtNo";

	public static final String AF_PRT_COMMISSION_WS = "select afpc from AfCbsPartnerCommission afpc where afpc.afCbsPartner.prtNo is not null and afpc.afCbsPartnerCategory.prtCatNo is null and afpc.afCbsPartnerProduct.prtPrdNo is null and afpc.productBrand is null and afpc.categoryPath is null";

	/***** Referral queries start ****/

	public static final String AF_CAMPAIGN_LIST = "select mc from AfCbsMgmCampaign mc where mc.status=1";

	/***** Referral queries end ****/

	public static final String AF_CBS_GET_ALL_AF_USER_PROFILE = "select afcbsup from AfCbsUserProfile afcbsup where afcbsup.deleteStatus=0 and afcbsup.createdTime between :fromDate and :toDate";

	public static final String AF_CBS_GET_AF_USER_PROFILE_BY_UNIQUE_ID = "select afcbsup from AfCbsUserProfile afcbsup where afcbsup.deleteStatus=0 and afcbsup.uniqueId=:uniqueId";

	public static final String AF_CBS_GET_ALL_AF_USER_PROFILE_COUNT = "select count(afcbsup) from AfCbsUserProfile afcbsup where afcbsup.deleteStatus=0";

	public static final String AF_CBS_GET_ALL_SOURCES = "select afcbsso from AfCbsSourceChannel afcbsso";

	public static final String AF_CBS_GET_USER_PROFILE_DETAILS = "select afcbsup from AfCbsUserProfile afcbsup where ";

	public static final String GET_UNIQUEID_COUNT = "select count(*) from AfCbsUserProfile where uniqueId=:uniqueId";

	public static final String AF_CBS_GET_EMAIL_ID = "select afid from AfCbsUserProfile afid where afid.emailId=:emailId";

	public static final String AF_CBS_GET_MOBILE_NO = "select afid from AfCbsUserProfile afid where afid.mobileNumber=:mobileNumber";

	public static final String AF_CBS_GET_COUNTRY = "select afc from AfCbsCountry afc where afc.status=1 and afc.deleteStatus=0";

	// public static final String AF_PARTNERS_DELETE_STSTUS = "update
	// AfCbsCategoryPartnerMapping afp set afp.deleteStatus=1 where
	// afp.afCbsPartner.prtNo=:prtNo";
	public static final String AF_CBS_GET_COUNTRY_MAPPING = "select afc from AfCbsCountryPartnerMapping afc where afc.afCbsPartner.prtNo=:prtNo";

	public static final String AF_CBS_GET_CATEGORY_MAPPING = "select afc from AfCbsCategoryPartnerMapping afc where afc.afCbsPartner.prtNo=:prtNo";

	public static final String AF_CBS_GET_USER_PROFILE_COUNT = "select count(afup) as count from AfCbsUserProfile afup where afup.deleteStatus=0 and afup.userStatus in (2, 3, 4) and afup.createdTime between :fromDate and :toDate";

	public static final String AF_CBS_GET_USER_REFERAL = "select new com.admin.entity.AfCbsUserProfile(afup.afCbsSubSourceChannel.afCbsSubSourceChannelId,count(afup.afCbsSubSourceChannel.afCbsSubSourceChannelId) ) from AfCbsUserProfile afup where afup.deleteStatus=0 and afup.userStatus in (2, 3, 4) and afup.createdTime between :fromDate and :toDate group by afup.afCbsSubSourceChannel.afCbsSubSourceChannelId";

	public static final String AF_CBS_GET_CURRENCY_LIST = "select acl from AfCbsCurrency acl";

	public static final String AF_CBS_GET_CURRENCY_ICON = "select aci.currencySymbol from AfCbsCurrency aci where aci.afCbsCurrencyId=:currencyName";

	public static final String AF_CBS_GET_EXCHANGE_RATE = "select acr from AfCbsCurrencyRate acr";

	public static final String AF_CBS_GET_CURRENCY_RATE_LIST = "select afccr.afCbsCurrency from AfCbsCurrencyRate afccr";

	public static final String AF_CBS_GET_CURRENCY_NAME = "select afid from AfCbsCurrency afid where afid.currencyName=:currencyName";

	public static final String AF_CBS_GET_ALL_SUB_SOURCES = "select afcbsso from AfCbsSubSourceChannel afcbsso";

	public static final String AF_CBS_GET_MAPPED_SOURCE_CHANNEL_LIST = "select distinct afcc.afCbsSourceChannel from AfCbsChannelSubChannelMapping afcc";

	public static final String AF_CBS_GET_SOURCE_CHANNEL_LIST = "select aftsc from AfCbsSourceChannel aftsc";

	public static final String AF_CBS_GET_TAG_SOURCE_CHANNEL = "select aci.afCbsSubSourceChannel from AfCbsChannelSubChannelMapping aci where aci.afCbsSourceChannel.afCbsSourceChannelId=:afCbsSourceChannelId and aci.deleteStatus=0";

	public static final String AF_CBS_GET_SOURCE_CHANNEL_MAPPING = "select afc from AfCbsChannelSubChannelMapping afc where afc.afCbsSourceChannel.afCbsSourceChannelId=:sourceChannelId";

	public static final String AF_CBS_GET_SOURCE_CHANNEL_NAME_BY_CHANNEL_ID = "select afcbsso.sourceChannelName from AfCbsSourceChannel afcbsso where afcbsso.afCbsSourceChannelId=:afCbsSourceChannelId";

	public static final String AF_CBS_GET_USER_STATUS = "select new com.admin.entity.AfCbsUserProfile(afup.userStatus,count(afup.userStatus)) from AfCbsUserProfile afup where afup.deleteStatus=0 and afup.userStatus in (2, 3, 4) and afup.createdTime between :fromDate and :toDate group by afup.userStatus";

	public static final String AF_CBS_GET_ACTIVITY_NAME = "select afmid from AfCbsActivityMaster afmid where afmid.activityName=:activityName";

	public static final String AF_CBS_GET_ACTIVITY_ID = "select afmn from AfCbsActivityMaster afmn where afmn.activityId=:activityId";

	public static final String AF_CBS_GET_ACTIVITY_LIST = "select acm from AfCbsActivityMaster acm";

	public static final String AF_CBS_GET_ACTIVITY_CODE_LIST = "select afcd from AfCbsActivityMaster afcd where afcd.activityStatus=1";

	public static final String AF_TOP_OFFER_DISP_ORDER_CHECK = "select count(*) from AfCbsCategory where topOffersDisplayOrder=:displayOrder and status=1";

	public static final String AF_CBS_GET_ALL_TIER = "select actm from AfCbsTierMaster actm";

	public static final String AF_CBS_GET_LEDGER = "select acbl from AfCbsCashBackLedger acbl  where acbl.afCbsUserProfileId=:afCbsUserProfileId and acbl.status=1";

	public static final String AF_CBS_GET_LEDGER_DETAILS = "select acbl from AfCbsCashBackLedger acbl  where acbl.afCbsUserProfile.afCbsUserProfileId=:afCbsUserProfileId and acbl.createdTime between :fromDate and :toDate and acbl.ledgerStatus=0";

	// public static final String AF_CBS_GET_USER_REFERAL = "select new
	// com.admin.entity.AfCbsUserProfile(afup.afCbsSubSourceChannel.afCbsSubSourceChannelId,count(afup.afCbsSubSourceChannel.afCbsSubSourceChannelId)
	// ) from AfCbsUserProfile afup where afup.createdTime between :fromDate and
	// :toDate and afup.deleteStatus=0 group by
	// afup.afCbsSubSourceChannel.afCbsSubSourceChannelId";

	// public static final String AF_CBS_GET_USER_PROFILE_COUNT = "select
	// count(afup) as count from AfCbsUserProfile afup where afup.createdTime
	// between :fromDate and :toDate and afup.deleteStatus=0";

	// public static final String AF_CBS_GET_USER_STATUS = "select new
	// com.admin.entity.AfCbsUserProfile(afup.userStatus,count(afup.userStatus))
	// from AfCbsUserProfile afup where afup.createdTime between :fromDate and
	// :toDate and afup.deleteStatus=0 group by afup.userStatus";

	// public static final String AF_CBS_GET_CATEGORY_OFFER_MAPPING = "select
	// afco from AfCbsCategoryOfferMapping afco where
	// afco.afCbsPartnerOffer.prtOffrNo=:prtNo";

	// public static final String AF_HOST_PARTNERS_COUNT = "select count(*) from
	// AfCbsPartner ap where ap.status=1 and ap.hostPartner=1";
	//
	// public static final String AF_LOGO_PARTNERS_COUNT = "select count(*) from
	// AfCbsPartner ap where ap.status=1 and ap.logoPartner=1";
	//
	// public static final String AF_OFFLINE_PARTNERS_COUNT = "select count(*)
	// from AfCbsPartner ap where ap.status=1 and ap.offLinePartner=1";
	//
	// public static final String AF_DEFAULT_PARTNERS_COUNT = "select count(*)
	// from AfCbsPartner ap where ap.status=1";
	//
	// public static final String AF_PARTNERS_COUNT = "select count(*) from
	// AfCbsPartner ap where ap.partnerStatus=1 and ap.status=1";

	public static final String AF_PARTNER_OFFER_BY_PRTNO_COUNT = "select count(*) from AfCbsPartnerOffer afpo where afpo.afCbsPartner.prtNo=:prtNo and afpo.status=1";

	public static final String AF_PARTNER_OFFER_BY_PRTNO_OFFRNAME_COUNT = "select count(*) from AfCbsPartnerOffer afpo where afpo.afCbsPartner.prtNo=:prtNo and afpo.offerName=:searchByValue and afpo.status=1";

	public static final String AF_PARTNER_OFFER_BY_OFFRNAME_COUNT = "select count(*) from AfCbsPartnerOffer afpo where afpo.offerName=:searchByValue and afpo.status=1";

	// With Desc
	public static final String AF_PARTNER_OFFER_BY_PRTNO_DESC_COUNT = "select count(*) from AfCbsPartnerOffer afpo where afpo.afCbsPartner.prtNo=:prtNo and afpo.description=:searchByValue and afpo.status=1";

	public static final String AF_PARTNER_OFFER_BY_DESC_COUNT = "select count(*) from AfCbsPartnerOffer afpo where afpo.description=:searchByValue and afpo.status=1";

	// With Category name
	public static final String AF_PARTNER_OFFER_BY_PRTNO_CATNAME_COUNT = "select count(*) from AfCbsPartnerOffer afpo where afpo.afCbsPartner.prtNo=:prtNo and afpo.afCbsCategory.catNo=:catNo and afpo.status=1";

	public static final String AF_PARTNER_OFFER_BY_CATNAME_COUNT = "select count(*) from AfCbsPartnerOffer afpo where afpo.afCbsCategory.catNo=:catNo and afpo.status=1";

	public static final String AF_PARTNERCOMMISSION_COUNT = "select count(*) from AfCbsPartnerCommission apc where apc.status=1 and apc.afCbsPartner.status=1";

	public static final String GET_ALL_PARTNERS_ORDER_BY_PRTNO = "select ap from AfCbsPartner ap where ap.status=1 and ap.partnerStatus=1 and ap.offLinePartner!=1 order by ap.partnerName";

	/**
	 * Start of menu query
	 */
	public static final String GET_MAX_MENU_LEVEL = "select max(menuLevel) from RrMenus where length(menuLevel)=3";

	public static final String GET_MAX_SUB_MENU_LEVEL = "select max(substring(menuLevel, -3)) from RrMenus where menuLevel like :condition";

	/**
	 * End of menu query
	 */

	/**
	 * Start of login query
	 */
	public static final String AF_GET_ACTIVE_USER_BY_EMAIL = "select user from RrUserProfile user"
			+ " where user.userName=:userName and user.userPwd=md5(:uPassword)";

	/**
	 * End of login query
	 */

	/**
	 * Start of syllabus query
	 */
	public static final String GET_ALL_SYLLABUS = "select sm from RrSyllabusMaster sm where sm.deleteStatus=0";

	public static final String GET_ALL_SYLLABUS_BY_CLASS = "select sm from RrSyllabusMaster sm where sm.deleteStatus=0 and sm.rrClassMaster.rrClassMasterId=:classId";

	/**
	 * End of syllabus query
	 */

	private RrHBQueries() {
	}

}
