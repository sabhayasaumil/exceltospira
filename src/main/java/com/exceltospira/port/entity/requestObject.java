package com.exceltospira.port.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = false)
public class requestObject
{
	@JsonProperty("ArtifactTypeId")
	int ArtifactTypeId;
	
	@JsonProperty("ConcurrencyDate")
	String ConcurrencyDate;
	
	@JsonProperty("ProjectId")
	String ProjectId;
	
	@JsonProperty("Active")
	Boolean Active;
	
	@JsonProperty("AuthorId")
	String AuthorId;
	
	@JsonProperty("AuthorName")
	String AuthorName;
	
	@JsonProperty("AutomationAttachmentId")
	String AutomationAttachmentId;
	
	@JsonProperty("AutomationEngineId")
	String AutomationEngineId;
	
	@JsonProperty("CreationDate")
	String CreationDate;
	
	@JsonProperty("Description")
	String Description;
	
	@JsonProperty("EstimatedDuration")
	String EstimatedDuration;
	
	@JsonProperty("ExecutionDate")
	String ExecutionDate;
	
	@JsonProperty("ExecutionStatusId")
	int ExecutionStatusId;
	
	@JsonProperty("Folder")
	Boolean Folder;
	
	@JsonProperty("IndentLevel")
	String IndentLevel;
	
	@JsonProperty("LastUpdateDate")
	String LastUpdateDate;
	
	@JsonProperty("Name")
	String Name;
	
	@JsonProperty("OwnerId")
	String OwnerId;
	
	@JsonProperty("OwnerName")
	String OwnerName;
	
	@JsonProperty("ProjectName")
	String ProjectName;
	
	@JsonProperty("TestCaseId")
	Integer TestCaseId;
	
	@JsonProperty("TestCasePriorityId")
	String TestCasePriorityId;
	
	@JsonProperty("TestCasePriorityName")
	String TestCasePriorityName;
	
	@JsonProperty("TestSteps")
	String[] TestSteps;
	
	@JsonProperty("CustomProperties")
	String[] CustomProperties;

	public String[] getCustomProperties()
	{
		return CustomProperties;
	}



	public void setCustomProperties(String[] customProperties)
	{
		CustomProperties = customProperties;
	}



	public requestObject()
	{
		ConcurrencyDate = "/Date("+System.currentTimeMillis()+")/";
		LastUpdateDate = CreationDate = ConcurrencyDate;
		ArtifactTypeId = Constants.ARTIFACT_ID_TEST_RUN;
		ExecutionStatusId = Constants.SPIRA_STATUS_NOT_RUN;
		Folder = false;
		Active = false;
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



	public String getProjectId()
	{
		return ProjectId;
	}



	public void setProjectId(String projectId)
	{
		ProjectId = projectId;
	}



	public Boolean getActive()
	{
		return Active;
	}



	public void setActive(Boolean active)
	{
		Active = active;
	}



	public String getAuthorId()
	{
		return AuthorId;
	}



	public void setAuthorId(String authorId)
	{
		AuthorId = authorId;
	}



	public String getAuthorName()
	{
		return AuthorName;
	}



	public void setAuthorName(String authorName)
	{
		AuthorName = authorName;
	}



	public String getAutomationAttachmentId()
	{
		return AutomationAttachmentId;
	}



	public void setAutomationAttachmentId(String automationAttachmentId)
	{
		AutomationAttachmentId = automationAttachmentId;
	}



	public String getAutomationEngineId()
	{
		return AutomationEngineId;
	}



	public void setAutomationEngineId(String automationEngineId)
	{
		AutomationEngineId = automationEngineId;
	}



	public String getCreationDate()
	{
		return CreationDate;
	}



	public void setCreationDate(String creationDate)
	{
		CreationDate = creationDate;
	}



	public String getDescription()
	{
		return Description;
	}



	public void setDescription(String description)
	{
		Description = description;
	}



	public String getEstimatedDuration()
	{
		return EstimatedDuration;
	}



	public void setEstimatedDuration(String estimatedDuration)
	{
		EstimatedDuration = estimatedDuration;
	}



	public String getExecutionDate()
	{
		return ExecutionDate;
	}



	public void setExecutionDate(String executionDate)
	{
		ExecutionDate = executionDate;
	}



	public int getExecutionStatusId()
	{
		return ExecutionStatusId;
	}



	public void setExecutionStatusId(int executionStatusId)
	{
		ExecutionStatusId = executionStatusId;
	}



	public Boolean getFolder()
	{
		return Folder;
	}



	public void setFolder(Boolean folder)
	{
		Folder = folder;
	}



	public String getIndentLevel()
	{
		return IndentLevel;
	}



	public void setIndentLevel(String indentLevel)
	{
		IndentLevel = indentLevel;
	}



	public String getLastUpdateDate()
	{
		return LastUpdateDate;
	}



	public void setLastUpdateDate(String lastUpdateDate)
	{
		LastUpdateDate = lastUpdateDate;
	}



	public String getName()
	{
		return Name;
	}



	public void setName(String name)
	{
		Name = name;
	}



	public String getOwnerId()
	{
		return OwnerId;
	}



	public void setOwnerId(String ownerId)
	{
		OwnerId = ownerId;
	}



	public String getOwnerName()
	{
		return OwnerName;
	}



	public void setOwnerName(String ownerName)
	{
		OwnerName = ownerName;
	}



	public String getProjectName()
	{
		return ProjectName;
	}



	public void setProjectName(String projectName)
	{
		ProjectName = projectName;
	}



	public Integer getTestCaseId()
	{
		return TestCaseId;
	}



	public void setTestCaseId(int testCaseId)
	{
		TestCaseId = testCaseId;
	}



	public String getTestCasePriorityId()
	{
		return TestCasePriorityId;
	}



	public void setTestCasePriorityId(String testCasePriorityId)
	{
		TestCasePriorityId = testCasePriorityId;
	}



	public String getTestCasePriorityName()
	{
		return TestCasePriorityName;
	}



	public void setTestCasePriorityName(String testCasePriorityName)
	{
		TestCasePriorityName = testCasePriorityName;
	}



	public String[] getTestSteps()
	{
		return TestSteps;
	}



	public void setTestSteps(String[] string)
	{
		TestSteps = string;
	}



	public void setFromExcelEntrees(excelEntrees entrees)
	{
		if(!entrees.getTcSteps().trim().isEmpty())
			this.setTestSteps(entrees.getTcSteps().split(Constants.SPIRA_TEST_CASE_STEPS_SPLITTER));
		
		this.setName(entrees.getTcName());		
		
		this.setDescription(entrees.getTcDescription());
		
		String status = entrees.getTcStatus().toLowerCase();
		
		int statusId = Constants.SPIRA_STATUS_NOT_RUN;
		if(status.equals("pass"))
			statusId = Constants.SPIRA_STATUS_PASS;
		else if(status.equals("fail"))
			statusId = Constants.SPIRA_STATUS_FAIL;
		
		this.setExecutionStatusId(statusId);
	}
	

	public void setUpdates(excelEntrees entrees)
	{
		if(!entrees.getTcName().trim().isEmpty())
			this.setName(entrees.getTcName());
		if(!entrees.getTcDescription().trim().isEmpty())
			this.setDescription(entrees.getTcDescription());
		if(!entrees.getTcSteps().isEmpty())
			this.setTestSteps(entrees.getTcSteps().split(Constants.SPIRA_TEST_CASE_STEPS_SPLITTER));
		if(!entrees.getTcStatus().isEmpty())
		{
			String status = entrees.getTcStatus().toLowerCase();
			
			int statusId = Constants.SPIRA_STATUS_NOT_RUN;
			if(status.equals("pass"))
				statusId = Constants.SPIRA_STATUS_PASS;
			else if(status.equals("fail"))
				statusId = Constants.SPIRA_STATUS_FAIL;
			
			this.setExecutionStatusId(statusId);
		}
		
			
	}
	
}
