package com.exceltospira.port.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class updateObject
{
	@JsonProperty("ArtifactTypeId")
	private int ArtifactTypeId;

	@JsonProperty("ConcurrencyDate")
	private String ConcurrencyDate;

	@JsonProperty("Description")
	private String Description;

	@JsonProperty("ExecutionStatusId")
	private int ExecutionStatusId;
	
	@JsonProperty("StartDate")
	private String StartDate;
	
	@JsonProperty("EndDate")
	private String EndDate;
	
	@JsonProperty("TestCaseId")
	private int TestCaseId;
	
	@JsonProperty("TestRunId")
	private int TestRunId;
	
	@JsonProperty("TestRunTypeId")
	private int TestRunTypeId;

	@JsonProperty("TestRunFormatId")
	private int TestRunFormatId;
	
	@JsonProperty("RunnerName")
	private String RunnerName;
	
	
	public updateObject()
	{
		ConcurrencyDate = "/Date("+System.currentTimeMillis()+")/";
		StartDate = ConcurrencyDate;
		EndDate = StartDate;
		ArtifactTypeId = Constants.ARTIFACT_ID_TEST_RUN;
		TestRunFormatId = 0;
		TestRunTypeId = 0;
		TestCaseId = 0;
		ExecutionStatusId = 0;
		RunnerName = "TCLoader";
	}


	public int getArtifactTypeId()
	{
		return ArtifactTypeId;
	}


	public void setArtifactTypeId(int artifactTypeId)
	{
		ArtifactTypeId = artifactTypeId;
	}


	public String getConcurrencyDate()
	{
		return ConcurrencyDate;
	}


	public void setConcurrencyDate(String concurrencyDate)
	{
		ConcurrencyDate = concurrencyDate;
	}


	public String getDescription()
	{
		return Description;
	}


	public void setDescription(String description)
	{
		Description = description;
	}


	public int getExecutionStatusId()
	{
		return ExecutionStatusId;
	}


	public void setExecutionStatusId(int executionStatusId)
	{
		ExecutionStatusId = executionStatusId;
	}


	public String getStartDate()
	{
		return StartDate;
	}


	public void setStartDate(String startDate)
	{
		StartDate = startDate;
	}


	public String getEndDate()
	{
		return EndDate;
	}


	public void setEndDate(String endDate)
	{
		EndDate = endDate;
	}


	public int getTestCaseId()
	{
		return TestCaseId;
	}


	public void setTestCaseId(int testCaseId)
	{
		TestCaseId = testCaseId;
	}


	public int getTestRunId()
	{
		return TestRunId;
	}


	public void setTestRunId(int testRunId)
	{
		TestRunId = testRunId;
	}


	public int getTestRunTypeId()
	{
		return TestRunTypeId;
	}


	public void setTestRunTypeId(int testRunTypeId)
	{
		TestRunTypeId = testRunTypeId;
	}


	public int getTestRunFormatId()
	{
		return TestRunFormatId;
	}


	public void setTestRunFormatId(int testRunFormatId)
	{
		TestRunFormatId = testRunFormatId;
	}


	public String getRunnerName()
	{
		return RunnerName;
	}


	public void setRunnerName(String runnerName)
	{
		RunnerName = runnerName;
	}


	

}
