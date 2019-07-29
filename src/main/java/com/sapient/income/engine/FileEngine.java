package com.sapient.income.engine;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sapient.income.model.InputData;
import com.sapient.income.reader.CustomFileReader;
import com.sapient.income.reader.FileReaderFactory;
import com.sapient.income.service.FileReaderService;
import com.sapient.income.util.Constant.FILE_TYPE;

@Component
public class FileEngine {
	@Value("${file.input}")
	private String inputFilePath;

	@Autowired
	private FileReaderService fileReaderService;

	public void readInputFile() throws IOException {
		System.out.println("Input File: " + inputFilePath);
		CustomFileReader fileReader = FileReaderFactory.readFile(FILE_TYPE.CSV, inputFilePath);
		List<InputData> inputDataList = fileReader.read(inputFilePath);
		System.out.println(inputDataList);
		fileReaderService.parseInputData(inputDataList);
	}

}
