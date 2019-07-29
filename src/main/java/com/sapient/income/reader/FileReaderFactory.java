package com.sapient.income.reader;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.sapient.income.util.Constant.FILE_TYPE;

@Component
public class FileReaderFactory {
	public static CustomFileReader readFile(FILE_TYPE fileType, String filePath) throws IOException {
		switch (fileType) {
		case CSV:
			return new CSVFileReader();
		case TXT:
			return new TXTFileReader();
		case XML:
			return new XMLFileReader();
		default:
			System.out.println("Unknown/unsupported file-type");
			return null;
		}

	}
}
