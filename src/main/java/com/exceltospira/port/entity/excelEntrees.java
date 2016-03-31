package com.exceltospira.port.entity;

import org.apache.poi.ss.usermodel.Row;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class excelEntrees
{
	@JsonProperty("folder")
	private int folder;
	
	@JsonProperty("folderStructure")
	private String folderStructure;
	
	@JsonProperty("mode")
	private String mode;
	
	@JsonProperty("tcID")
	private int tcID;

	@JsonProperty("tcName")
	private String tcName;
	
	@JsonProperty("tcDescription")
	private String tcDescription;
	
	@JsonProperty("tcSteps")
	private String tcSteps;
	
	@JsonProperty("tcExpectedResult")
	private String tcExpectedResult;
	
	@JsonProperty("tcStatus")
	private String tcStatus;
	
	@JsonProperty("error")
	private String error;

	
	public int getFolder()
	{
		return folder;
	}

	public void setFolder(int folder)
	{
		this.folder = folder;
	}
	
	public String getFolderStructure()
	{
		return folderStructure;
	}

	public void setFolderStructure(String folderStructure)
	{
		this.folderStructure = folderStructure;
	}

	public String getMode()
	{
		return mode;
	}

	public void setMode(String mode)
	{
		this.mode = mode;
	}

	public int getTcID()
	{
		return tcID;
	}

	public void setTcID(int tcID)
	{
		this.tcID = tcID;
	}

	public String getTcName()
	{
		return tcName;
	}

	public void setTcName(String tcName)
	{
		this.tcName = tcName;
	}

	public String getTcDescription()
	{
		return tcDescription;
	}

	public void setTcDescription(String tcDescription)
	{
		this.tcDescription = tcDescription;
	}

	public String getTcSteps()
	{
		return tcSteps;
	}

	public void setTcSteps(String tcSteps)
	{
		this.tcSteps = tcSteps;
	}

	public String getTcExpectedResult()
	{
		return tcExpectedResult;
	}

	public void setTcExpectedResult(String tcExpectedResult)
	{
		this.tcExpectedResult = tcExpectedResult;
	}

	public String getTcStatus()
	{
		return tcStatus;
	}

	public void setTcStatus(String tcStatus)
	{
		this.tcStatus = tcStatus;
	}
	
	public void setFromRow(Row row)
	{
		
		//Double folder =  row.getCell(0).getNumericCellValue();
		//this.setFolderStructure(row.getCell(0).getStringCellValue());
		this.setMode(row.getCell(1).getStringCellValue());
		this.setTcDescription(row.getCell(4).getStringCellValue());
		this.setTcExpectedResult(row.getCell(6).getStringCellValue());
		Double tcId = row.getCell(2).getNumericCellValue();
		this.setTcID(tcId.intValue());
		this.setTcStatus(row.getCell(7).getStringCellValue());
		this.setTcSteps(row.getCell(5).getStringCellValue());
		this.setTcName(row.getCell(3).getStringCellValue());
	}

	public String getError()
	{
		return error;
	}

	public void setError(String error)
	{
		this.error = error;
	}
	

}
