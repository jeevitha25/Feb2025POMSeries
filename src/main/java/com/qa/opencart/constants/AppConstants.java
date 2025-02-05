package com.qa.opencart.constants;

import java.util.List;

public class AppConstants {

	
	public static final String loginPageTitle= "Account Login";
	public static final String AccountsPageTitle= "My Account";
	public static final String LoginPageUrl ="route=account/login";
	public static final int Accounts_page_headers_count = 4;
	
	
	public static final String user_register_successMsg= "Your Account Has Been Created!";
	
	
	public static final List<String> ExpectedAccountsheadersList= List.of("My Account", "My Orders", "My Affiliate Account", "Newsletter");
	public static final int Default_short_time_out = 5;
	public static final int Default_medium_time_out = 10;
	public static final int Default_long_time_out = 15;
	
	public static final String REG_SHEET_NAME = "register";
	public static final String SEARCH_SHEET_NAME = "search";

}
