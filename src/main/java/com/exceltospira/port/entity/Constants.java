package com.exceltospira.port.entity;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;

public class Constants
{
	public static final String USERNAME = "";							//username
	public static final String KEY_STRING = "";							//api-key in a parenthesis, format = "{'api-key'}"
	public static final String URL = "";								// base URL of spira for a praticular project.
	public static final String PROJECTID = "24";
	public static final String CONTENT_TYPE = "application/json";
	public static final String ACCEPT_TYPE = "application/json";
	public static final int SPIRA_STATUS_FAIL = 1;
	public static final int SPIRA_STATUS_PASS = 2;
	public static final int SPIRA_STATUS_NOT_RUN = 3;
	public static final int SPIRA_STATUS_WIP = 4;
	public static final int SPIRA_STATUS_BLOCKED = 5;
	public static final int SPIRA_STATUS_CAUTION = 6;
	public static final int ARTIFACT_ID_TEST_RUN = 5;
	public static final String SPIRA_TEST_CASE_STEPS_SPLITTER = ":";	//Character used to split a text field from excel into array.

}
