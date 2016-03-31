package com.exceltospira.port.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class caseObject
{
	
	@JsonProperty("ArtifactTypeId")
	String artifactTypeId;
	
	@JsonProperty("ConcurrencyDate")
	String concurrencyDate;

	@JsonProperty("ProjectId")
	String projectId;
	
	@JsonProperty("Active")
	String active;
	
	@JsonProperty("AuthorId")
	String authorId;
	
	@JsonProperty("AuthorName")
	String authorName;
	
	@JsonProperty("AutomationAttachmentId")
	String automationAttachmentId;
	
	@JsonProperty("AutomationEngineId")
	String automationEngineId;
	
	@JsonProperty("CreationDate")
	String creationDate;
	
	@JsonProperty("Description")
	String description;
	
	@JsonProperty("EstimatedDuration")
	String estimatedDuration;
	
	@JsonProperty("ExecutionDate")
	String executionDate;
	
	@JsonProperty("ExecutionStatusId")
	String executionStatusId;
	
	@JsonProperty("Folder")
	String folder;
	
	@JsonProperty("IndentLevel")
	String indentLevel;
	
	@JsonProperty("LastUpdateDate")
	String lastUpdateDate;
	
	@JsonProperty("Name")
	String name;
	
	@JsonProperty("OwnerId")
	String ownerId;
	
	@JsonProperty("OwnerName")
	String ownerName;
	
	@JsonProperty("ProjectName")
	String projectName;
	
	@JsonProperty("TestCaseId")
	String testCaseId;
	
	@JsonProperty("TestCasePriorityId")
	String testCasePriorityId;
	
	@JsonProperty("TestCasePriorityName")
	String testCasePriorityName;
	
	@JsonProperty("TestSteps")
	String testSteps;

	public String getArtifactTypeId()
	{
		return artifactTypeId;
	}

	public void setArtifactTypeId(String artifactTypeId)
	{
		this.artifactTypeId = artifactTypeId;
	}

	public String getConcurrencyDate()
	{
		return concurrencyDate;
	}

	public void setConcurrencyDate(String concurrencyDate)
	{
		this.concurrencyDate = concurrencyDate;
	}



	public String getProjectId()
	{
		return projectId;
	}

	public void setProjectId(String projectId)
	{
		this.projectId = projectId;
	}

	public String getActive()
	{
		return active;
	}

	public void setActive(String active)
	{
		this.active = active;
	}

	public String getAuthorId()
	{
		return authorId;
	}

	public void setAuthorId(String authorId)
	{
		this.authorId = authorId;
	}

	public String getAuthorName()
	{
		return authorName;
	}

	public void setAuthorName(String authorName)
	{
		this.authorName = authorName;
	}

	public String getAutomationAttachmentId()
	{
		return automationAttachmentId;
	}

	public void setAutomationAttachmentId(String automationAttachmentId)
	{
		this.automationAttachmentId = automationAttachmentId;
	}

	public String getAutomationEngineId()
	{
		return automationEngineId;
	}

	public void setAutomationEngineId(String automationEngineId)
	{
		this.automationEngineId = automationEngineId;
	}

	public String getCreationDate()
	{
		return creationDate;
	}

	public void setCreationDate(String creationDate)
	{
		this.creationDate = creationDate;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getEstimatedDuration()
	{
		return estimatedDuration;
	}

	public void setEstimatedDuration(String estimatedDuration)
	{
		this.estimatedDuration = estimatedDuration;
	}

	public String getExecutionDate()
	{
		return executionDate;
	}

	public void setExecutionDate(String executionDate)
	{
		this.executionDate = executionDate;
	}

	public String getExecutionStatusId()
	{
		return executionStatusId;
	}

	public void setExecutionStatusId(String executionStatusId)
	{
		this.executionStatusId = executionStatusId;
	}

	public String getFolder()
	{
		return folder;
	}

	public void setFolder(String folder)
	{
		this.folder = folder;
	}

	public String getIndentLevel()
	{
		return indentLevel;
	}

	public void setIndentLevel(String indentLevel)
	{
		this.indentLevel = indentLevel;
	}

	public String getLastUpdateDate()
	{
		return lastUpdateDate;
	}

	public void setLastUpdateDate(String lastUpdateDate)
	{
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getOwnerId()
	{
		return ownerId;
	}

	public void setOwnerId(String ownerId)
	{
		this.ownerId = ownerId;
	}

	public String getOwnerName()
	{
		return ownerName;
	}

	public void setOwnerName(String ownerName)
	{
		this.ownerName = ownerName;
	}

	public String getProjectName()
	{
		return projectName;
	}

	public void setProjectName(String projectName)
	{
		this.projectName = projectName;
	}

	public String getTestCaseId()
	{
		return testCaseId;
	}

	public void setTestCaseId(String testCaseId)
	{
		this.testCaseId = testCaseId;
	}

	public String getTestCasePriorityId()
	{
		return testCasePriorityId;
	}

	public void setTestCasePriorityId(String testCasePriorityId)
	{
		this.testCasePriorityId = testCasePriorityId;
	}

	public String getTestCasePriorityName()
	{
		return testCasePriorityName;
	}

	public void setTestCasePriorityName(String testCasePriorityName)
	{
		this.testCasePriorityName = testCasePriorityName;
	}

	public String getTestSteps()
	{
		return testSteps;
	}

	public void setTestSteps(String testSteps)
	{
		this.testSteps = testSteps;
	}
}
