package com.spring.files.excel.springbootuploadexcelfiles.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spring.files.excel.springbootuploadexcelfiles.helper.ExcelHelper;
import com.spring.files.excel.springbootuploadexcelfiles.madel.Tutorial;
import com.spring.files.excel.springbootuploadexcelfiles.repository.TutorialRepository;

@Service
public class ExcelService {

	@Autowired
	  TutorialRepository repository;

	  public void save(MultipartFile file) {
	    try {
	    	System.out.println("Debug3");
	      List<Tutorial> tutorials = ExcelHelper.excelToTutorials(file.getInputStream());
	      System.out.println("Debug 5");
	      repository.saveAll(tutorials);
	      System.out.println("Debug 6");
	    } catch (IOException e) {
	      throw new RuntimeException("fail to store excel data: " + e.getMessage());
	    }
	  }

	  public List<Tutorial> getAllTutorials() {
	    return repository.findAll();
	  }
}
