package com.exceltospira.port.adminService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.exceltospira.port.entity.excelEntrees;
import com.exceltospira.port.entity.excelTable;

public class excelGenerator
{
	
	public HSSFWorkbook createExcel(excelTable table)
	{
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Generated Sheet");
		HSSFFont font = workbook.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		HSSFCellStyle style = workbook.createCellStyle();
		style.setFont(font);
		

		int cellNum = 0;
		
		int rowNum = 0;
		Row row = sheet.createRow(rowNum++);
		//row.setRowStyle(style);
		Cell cell = row.createCell(cellNum++);
		cell.setCellValue("Folder Structure");
		cell.setCellStyle(style);
		
		cell = row.createCell(cellNum++);
		cell.setCellValue("Folder Id");
		cell.setCellStyle(style);
		
		cell = row.createCell(cellNum++);
		cell.setCellValue("Mode");
		cell.setCellStyle(style);
		
		cell = row.createCell(cellNum++);
		cell.setCellValue("Test Case Id");
		cell.setCellStyle(style);
		
		cell = row.createCell(cellNum++);
		cell.setCellValue("Test Case Name");
		cell.setCellStyle(style);
		
		cell = row.createCell(cellNum++);
		cell.setCellValue("Test Case Description");
		cell.setCellStyle(style);
		
		cell = row.createCell(cellNum++);
		cell.setCellValue("Test Case Step");
		cell.setCellStyle(style);
		
		cell = row.createCell(cellNum++);
		cell.setCellValue("Expected Result");
		cell.setCellStyle(style);
		
		cell = row.createCell(cellNum++);
		cell.setCellValue("Status");
		cell.setCellStyle(style);
		
		cell = row.createCell(cellNum++);
		cell.setCellValue("Error");
		cell.setCellStyle(style);
		
		
		for(excelEntrees entrees:table.getExEntrees())
		{
			cellNum = 0;
			row = sheet.createRow(rowNum++);
			cell = row.createCell(cellNum++);
			cell.setCellValue(entrees.getFolderStructure());
			cell = row.createCell(cellNum++);
			cell.setCellValue(entrees.getFolder());
			cell = row.createCell(cellNum++);
			cell.setCellValue(entrees.getMode());
			cell = row.createCell(cellNum++);
			cell.setCellValue(entrees.getTcID());
			cell = row.createCell(cellNum++);
			cell.setCellValue(entrees.getTcName());
			cell = row.createCell(cellNum++);
			cell.setCellValue(entrees.getTcDescription());
			cell = row.createCell(cellNum++);
			cell.setCellValue(entrees.getTcSteps());
			cell = row.createCell(cellNum++);
			cell.setCellValue(entrees.getTcExpectedResult());
			cell = row.createCell(cellNum++);
			cell.setCellValue(entrees.getTcStatus());
			cell = row.createCell(cellNum++);
			cell.setCellValue(entrees.getError());
			
		}
		
		return workbook;
		
	}

}