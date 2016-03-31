package com.exceltospira.port.adminService;

//http://www.mkyong.com/spring-mvc/spring-mvc-export-data-to-excel-file-via-abstractexcelview/
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.UUID;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.exceltospira.port.entity.Constants;
import com.exceltospira.port.entity.ResponseObject;
import com.exceltospira.port.entity.SpiraObject;
import com.exceltospira.port.entity.caseObject;
import com.exceltospira.port.entity.excelEntrees;
import com.exceltospira.port.entity.excelTable;
import com.exceltospira.port.entity.requestObject;
import com.exceltospira.port.entity.updateObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class adminstrativeService
{

	@Autowired
	RestTemplate restTemplate;
	
		
	public String keyGenerator()
	{
		return UUID.randomUUID().toString();
	}

	public excelTable returnTable(String key, String ext)
	{
		String tableName = "content/" + key + "." + ext;
		excelTable exTab = new excelTable();
		exTab.setKey(key);
		exTab.setExt(ext);
		exTab.setExEntrees(extractData(tableName));
		return exTab;
	}

	public List<excelEntrees> extractData(String tableName)
	{

		List<excelEntrees> ex = new ArrayList<excelEntrees>();
		excelEntrees entrees = null;
		int folderStructure = 0;

		try
		{
			FileInputStream inputStream = new FileInputStream(new File(tableName));

			Workbook workbook = null;

			if (tableName.endsWith("xls"))
			{

				workbook = new HSSFWorkbook(inputStream);

			}
			else
			{
				workbook = new XSSFWorkbook(inputStream);

			}

			Sheet firstSheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = firstSheet.iterator();

			//List<requestObject> response = extractAll();
			Double folderId;
			iterator.next();

			while (iterator.hasNext())
			{
				Row nextRow = iterator.next();

				entrees = new excelEntrees();

				String mode = nextRow.getCell(1).getStringCellValue();
				if (mode.trim().isEmpty())
					break;
				
				/*
				String Folder = nextRow.getCell(0).getStringCellValue().trim();
				if(Folder.isEmpty())
				{
					folderId = 0;
				}
				else	
					folderId = this.createFolderHeirachy(response,Folder);*/
				
				try
				{
					folderId = nextRow.getCell(0).getNumericCellValue();
				}
				catch(Exception E)
				{
					folderId = 0.0;
				}
				if(mode.toLowerCase().trim().equals("add") && folderId.intValue() == 0)
					entrees.setError("Please Provide Integer Value for Folder ID");
				
				entrees.setFromRow(nextRow);
				entrees.setFolder(folderId.intValue());
				ex.add(entrees);
			}

			workbook.close();
			inputStream.close();

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return ex;

	}

	public int createFolderHeirachy(List<requestObject> response,String path)//String folders)
	{
		int currentIndentLength = 0;
		int maxIndentLenght = 15;
		String[] folder = path.split("/");
		int i = 0,length;
		int max = folder.length;
		for(requestObject ob : response)
		{
		
			length = ob.getIndentLevel().length();
			if(length > currentIndentLength && length < maxIndentLenght && ob.getName().equals(folder[i]))
			{
				i++;
				if(i == max)
					return ob.getTestCaseId();
				currentIndentLength = length;
				maxIndentLenght = length + 4;
			}
			else if(currentIndentLength <= length)
			{
				currentIndentLength = 0;
				maxIndentLenght = 15;
			}
			
		}
		
		return 0;
	}

	private HttpHeaders getSpiraHeader()
	{

		HttpHeaders headers = new HttpHeaders();

		headers.set("username", Constants.USERNAME);
		headers.set("api-key", Constants.KEY_STRING);
		headers.set("Content-Type", Constants.CONTENT_TYPE);
		headers.set("accept", Constants.CONTENT_TYPE);
		return headers;

	}

	public String requestUpdates(SpiraObject sObject)
	{

		try
		{
			HttpHeaders headers = getSpiraHeader();
			HttpEntity<SpiraObject> body = new HttpEntity<SpiraObject>(sObject, headers);
			ResponseEntity<SpiraObject> response = null;

			response = restTemplate.exchange(Constants.URL + "/test-runs/record", HttpMethod.POST, body, SpiraObject.class);
			System.out.println(response.toString());
			return "update successful";
		}
		catch (Exception E)
		{
			E.printStackTrace();
			return "update failed";
		}
	}

	public List<requestObject> extractAll()
	{
		try
		{
			int count = getCount();
			System.out.println(Constants.URL + "/test-cases/search?starting_row=1&number_of_rows=" + count);
			HttpHeaders headers = getSpiraHeader();
			HttpEntity body = new HttpEntity(headers);
			
			ResponseEntity<List<requestObject>> response = null;
			response = restTemplate.exchange(Constants.URL + "/test-cases/search?starting_row=1&number_of_rows="+count, HttpMethod.GET, body, new ParameterizedTypeReference<List<requestObject>>()
			{
			});
			return response.getBody();
			
		}
		catch (Exception E)
		{
			E.printStackTrace();
			System.out.println("there was error");
		}
		return null;
	}

	public excelTable confirm(String key, String ext)
	{
		excelTable ex = null;

		try
		{
			ex = returnTable(key, ext);
			for(excelEntrees entrees:ex.getExEntrees())
			{
				this.selectMode(entrees);
			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return ex;

	}
	
	
	public excelTable confirm(excelTable ex)
	{
		List<excelEntrees> exEntrees = new ArrayList<excelEntrees>();

		try
		{
			for(excelEntrees entrees:ex.getExEntrees())
			{
				exEntrees.add(this.selectMode(entrees));
			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		ex.setExEntrees(exEntrees);
		
		return ex;

	}

	public excelEntrees selectMode(excelEntrees entrees)
	{
		if (entrees.getMode().toLowerCase().trim().equals("add"))
		{
			if(entrees.getError()!= null)
				return entrees;
			
			return this.modeAdd(entrees);
		}
		else if (entrees.getMode().toLowerCase().trim().equals("update"))
		{
			if(entrees.getTcID() == 0)
			{
				entrees.setError("Please Provide Test Case Id For update.");
				return entrees;
			}
			return this.modeUpdate(entrees);
		}
		else if (entrees.getMode().toLowerCase().trim().equals("add testrun"))
		{
			if(entrees.getTcID() == 0)
			{
				entrees.setError("Please Provide Test Case Id For update.");
				return entrees;
			}
			return this.modeTestRunsUpdate(entrees);
		}
			return null;
	}

	public excelEntrees modeAdd(excelEntrees entrees)
	{
		try
		{
			requestObject ro = new requestObject();
			ro.setFromExcelEntrees(entrees);
			//this.printJSON(ro);
			HttpHeaders headers = getSpiraHeader();
			HttpEntity<requestObject> body = new HttpEntity<requestObject>(ro, headers);
			
			ResponseEntity<requestObject> response = null;
			
			System.out.println(Constants.URL + "/test-cases?parent_test_folder_id=" + entrees.getFolder());
			response = restTemplate.exchange(Constants.URL + "/test-cases?parent_test_folder_id=" + entrees.getFolder(), HttpMethod.POST, body, requestObject.class);
			
			
			//printJSON(response.getBody());
			entrees.setTcID(response.getBody().getTestCaseId());

		}
		catch (Exception e)
		{
			e.printStackTrace();
			entrees.setTcExpectedResult(e.getMessage());
		}
		return entrees;
	}

	public excelEntrees modeTestRunsUpdate(excelEntrees entrees)
	{
		try
		{
			updateObject uo = new updateObject();
			
			uo.setTestCaseId(entrees.getTcID());
			
			if(entrees.getTcStatus().trim().toLowerCase().equals("pass"))
				uo.setExecutionStatusId(Constants.SPIRA_STATUS_PASS);
			else if(entrees.getTcStatus().trim().toLowerCase().equals("fail"))
				uo.setExecutionStatusId(Constants.SPIRA_STATUS_FAIL);
			else
				uo.setExecutionStatusId(Constants.SPIRA_STATUS_NOT_RUN);
			
			
			
			HttpHeaders headers = getSpiraHeader();
			HttpEntity<updateObject> body = new HttpEntity(uo, headers);
			
			// System.out.println("header _ " + body.toString());
			// System.out.println();
			ResponseEntity<updateObject> response = null;

			response = restTemplate.exchange(Constants.URL + "/test-runs/record", HttpMethod.POST, body, updateObject.class);

			System.out.println(response.getBody());

		}
		catch (Exception e)
		{
			e.printStackTrace();
			entrees.setError(e.getMessage());
		}
		
		return entrees;
	}
	
	public excelEntrees modeUpdate(excelEntrees entrees)
	{
		try
		{
			requestObject ro;
			HttpHeaders headers = getSpiraHeader();
			
			HttpEntity body = new HttpEntity(headers);
			
			
			ResponseEntity<requestObject> response = null;
			
			response = restTemplate.exchange(Constants.URL + "/test-cases/" + entrees.getTcID(), HttpMethod.GET, body,requestObject.class);
			
			ro = response.getBody();
			ro.setUpdates(entrees);
			
			
			
			HttpEntity<requestObject> bodyUpdate = new HttpEntity(ro, headers);
			printJSON(ro);
			
			ResponseEntity<Void> res = restTemplate.exchange(Constants.URL + "/test-cases", HttpMethod.PUT, bodyUpdate,Void.class);
			System.out.println(res.getStatusCode());

		}
		catch (Exception e)
		{
			e.printStackTrace();
			entrees.setError(e.getMessage());
		}
		
		return entrees;
	}

	public void printJSON(requestObject obj)
	{
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(obj);
		System.out.println(json);
	}

	public int getCount()
	{
		HttpHeaders headers = getSpiraHeader();
		HttpEntity body = new HttpEntity(headers);
		ResponseEntity<Integer> response = null;
		response = restTemplate.exchange(Constants.URL + "/test-cases/count", HttpMethod.GET, body,Integer.class);
		return response.getBody();
	}
	
}
