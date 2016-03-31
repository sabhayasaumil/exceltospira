package com.exceltospira.port.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class excelTable
{
	@JsonProperty("key")
	private String key;
	
	@JsonProperty("extension")
	private String ext;
	
	
	@JsonProperty("table")
	private List<excelEntrees> exEntrees;
	
	public String getKey()
	{
		return key;
	}
	public void setKey(String key)
	{
		this.key = key;
	}
	
	public String getExt()
	{
		return ext;
	}
	public void setExt(String ext)
	{
		this.ext = ext;
	}
	
	public List<excelEntrees> getExEntrees()
	{
		return exEntrees;
	}
	public void setExEntrees(List<excelEntrees> exEntrees)
	{
		this.exEntrees = exEntrees;
	}
	
}
