package com.exceltospira.port.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SpiraObject
{
	@JsonProperty("ProjectId")
	private String projectId;

	@JsonProperty("Folder")
	private int folder;

	@JsonProperty("TestSteps")
	private String testSteps;

	@JsonProperty("TestCaseId")
	private String testCaseId;

	@JsonProperty("Description")
	private String description;
	
	@JsonProperty("StartDate")
	private String startDate;

	@JsonProperty("Name")
	private String name;


	public int getFolder()
	{
		return folder;
	}

	public void setFolder(int folder)
	{
		this.folder = folder;
	}

	public String getTestSteps()
	{
		return testSteps;
	}

	public void setTestSteps(String testSteps)
	{
		this.testSteps = testSteps;
	}

	public String getTestCaseId()
	{
		return testCaseId;
	}

	public void setTestCaseId(String testCaseId)
	{
		this.testCaseId = testCaseId;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}



	public SpiraObject()
	{

		this.name = "-";

		this.projectId = Constants.PROJECTID;
		
		this.startDate = "/Date("+System.currentTimeMillis()+")/";

	}
}
