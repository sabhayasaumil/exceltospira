package com.exceltospira.port.entity;

import org.springframework.web.multipart.MultipartFile;

public class Files
{
	MultipartFile file;

	public MultipartFile getFile()
	{
		return file;
	}

	public void setFile(MultipartFile file)
	{
		this.file = file;
	}

}
