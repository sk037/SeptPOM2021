package com.qa.opencart.utils;

import java.util.ArrayList;
import java.util.List;

public class Constant {
	
	public final static String LOGINPAGE_TITLE = "Account Login";
	public final static String ACCPAGE_TITLE = "My Account";
	public final static int DEFAULT_TIME_OUT = 5;
	public final static String URL_FRACTION = "http://opencart.antropy.co.uk/index.php?route=account/login";
	public final static String FIRSTNAME = "Satish1";
	public final static String LASTNAME = "Kumar1";
	public final static String EMAIL = "nijek32574@sofrge.com";
	public final static String TELEPHONE = "77877777777";
	public final static String PASSWORD ="qwerty";
	public final static String CONFIRMPASSWORD = "qwerty";
	public final static String ACC_CREATIONMSG = "Your Account Has Been Created!";
	//public final static String PRODUCTNAME="Mac";
	public final static String ACC_HEADER="Your Store";
	public final static String SEARCHED_PAGE="Search Criteria";
	public final static String PROD_TITLE="MacBook Air";
	//public final static String SHEET_NAME="OpenCartAppTestDataSheet";
	public static String SHEET_NAME="OpenCartAppTestDataSheet";
	public static String PRODUCT_SHEET_NAME="OpenCartAppTestProductSheet";
	
    public final static List<String> getPageContentConstant() {
	List<String> array=new ArrayList<String>();
	array.add("My Account");
	array.add("My Orders");
	//array.add("My Affiliate Account");
	array.add("Newsletter");
	return array;
	
    }
    
    public final static List<String> getSectionContentConstant() {
    	List<String> array2=new ArrayList<String>();
    	array2.add("Edit your account information");
    	array2.add("Change your password");
    	array2.add("Modify your address book entries");
    	array2.add("Modify your wish list");
    	return array2;
			
}
}
