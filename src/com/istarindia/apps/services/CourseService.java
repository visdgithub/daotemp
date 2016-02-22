/**
 * 
 */
package com.istarindia.apps.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import com.istarindia.apps.dao.ContentAdmin;
import com.istarindia.apps.dao.Course;
import com.istarindia.apps.dao.*;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 * @author mak
 *
 */
public class CourseService {

	public void readFile(File storeFile, ContentAdmin user) throws IOException {
		FileInputStream file = new FileInputStream(storeFile);
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		HSSFSheet worksheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = worksheet.iterator();
		rowIterator.next();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			if(!row.getCell(0).getStringCellValue().trim().equalsIgnoreCase("") && 
					!row.getCell(1).getStringCellValue().trim().equalsIgnoreCase("") && 
					!row.getCell(2).getStringCellValue().trim().equalsIgnoreCase("") && 
					!row.getCell(3).getStringCellValue().trim().equalsIgnoreCase("") && 
					!row.getCell(4).getStringCellValue().trim().equalsIgnoreCase("")) {
			
			Course course = createCourse(row.getCell(0));
			Module module = createModule(row.getCell(1), course);
			//Cmsession session = createSession(row.getCell(2), row.getCell(3), module, row.getCell(4), user);
			}
		}

	}
	
	private static Course createCourse(Cell cell) {
		CourseDAO dao = new CourseDAO();
		Course course = new Course();
		if (dao.findByCourseName(cell.getStringCellValue()).size() == 0) {

			course.setCourseName(cell.getStringCellValue());
			Session session1 = dao.getSession();
			Transaction tx1 = null;
			try {
				tx1 = session1.beginTransaction();
				Short iiii = 1;
				dao.save(course);
				tx1.commit();
			} catch (HibernateException e) {
				if (tx1 != null)
					tx1.rollback();
				e.printStackTrace();
			} finally {
				session1.close();
			}
		} else {
			course = dao.findByCourseName(cell.getStringCellValue()).get(0);
		}

		return course;

	}
	
	private static Module createModule(Cell cell, Course course) {
		ModuleDAO dao = new ModuleDAO();
		Module module = new Module();
		if (dao.findByModuleName(cell.getStringCellValue()).size() == 0) {

			module.setModuleName(cell.getStringCellValue());
			Session session1 = dao.getSession();
			Transaction tx1 = null;
			try {
				tx1 = session1.beginTransaction();
				module.setCourse(course);
				dao.save(module);
				tx1.commit();
			} catch (HibernateException e) {
				if (tx1 != null)
					tx1.rollback();
				e.printStackTrace();
			} finally {
				session1.close();
			}
		} else {
			module = dao.findByModuleName(cell.getStringCellValue()).get(0);
		}

		return module;

	}
	
	private static Cmsession createSession(Cell sessionName, Module module, Cell learningObjectives, ContentAdmin user) {
		
		return null;
	}
	
	
}
