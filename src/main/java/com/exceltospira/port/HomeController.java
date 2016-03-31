package com.exceltospira.port;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import com.exceltospira.port.adminService.adminstrativeService;
import com.exceltospira.port.adminService.excelGenerator;
import com.exceltospira.port.entity.ResponseObject;
import com.exceltospira.port.entity.excelTable;
import com.exceltospira.port.entity.requestObject;

/**1
 * Handles requests for the application home page.
 */
@RestController
public class HomeController
{

	@Autowired
	adminstrativeService adminService;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping(value = "/upload", method = {RequestMethod.POST}, produces = "application/json")
	public ResponseObject upload(Locale locale, Model model, WebRequest webRequest,@RequestParam("fileToUpload") MultipartFile file)
	{
		ResponseObject response = new ResponseObject();
		String key = adminService.keyGenerator();
			if(!file.isEmpty())
			{
				String extension = FilenameUtils.getExtension(file.getOriginalFilename());
				
				if (extension.equals("xls") || extension.equals("xlsx")) {
						key = key + "." + extension;
	                    try
						{
							file.transferTo(new File("content/" + key));
						}
						catch (IllegalStateException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						catch (IOException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                    response.setStatus("success");
	                }
				else
				{
					response.setStatus("error");
					key = "uploading file: Invalid Format";
				}
			}
		response.setKey(key);
		return response;
	}
	
	
	@RequestMapping(value = "/extractAll", method = {RequestMethod.GET ,RequestMethod.POST}, produces = "application/json")
	public List<requestObject> extractAll(Locale locale, Model model)
	{
		return adminService.extractAll();
		
		//return response.getBody();
	}
	
	
	@RequestMapping(value = "/display/{key}/{ext}", method = {RequestMethod.GET,RequestMethod.POST}, produces = "application/json")
	public excelTable display(Locale locale,@PathVariable("key") String key,@PathVariable("ext") String ext)
	{
		excelTable ex=  adminService.returnTable(key, ext);
		return ex;
	}
	
	@RequestMapping(value = "/confirm/{key}/{ext}", method = {RequestMethod.GET,RequestMethod.POST}, produces = "application/json")
	public excelTable confirm(Locale locale,@PathVariable("key") String key,@PathVariable("ext") String ext)
	{
		excelTable ex=  (excelTable) adminService.confirm(key, ext);
		return ex;
	}
	
	@RequestMapping(value = "/confirm", method = {RequestMethod.GET,RequestMethod.POST}, produces = "application/vnd.ms-excel", consumes = "application/json")
	public void confirmJSON(Locale locale,@RequestBody excelTable ex, HttpServletResponse response)
	{
		ex =  adminService.confirm(ex);
		
		HSSFWorkbook workbook = new excelGenerator().createExcel(ex);
		response.setHeader("Content-disposition", "attachment;filename=newTestCase.xls");
		try
        {
              ByteArrayOutputStream bos = new ByteArrayOutputStream(); 
              workbook.write(bos); 
              response.setContentLength(bos.size()); 
              workbook.write(response.getOutputStream());
              response.flushBuffer();
        }
        catch(IOException e) {
            e.printStackTrace();
        }  
		

	}
	
}
