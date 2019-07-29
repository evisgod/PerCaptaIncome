package com.sapient.income.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sapient.income.model.InputData;
import com.sapient.income.util.Constant;
import com.sapient.income.util.Utils;

@Component
public class CSVFileReader implements CustomFileReader {

	@Override
	public List<InputData> read(String filepath) {
		List<InputData> list = new ArrayList<>();
		String line = "";
		BufferedReader br = null;
		try {
			File inputDataFile = new File(filepath);
			br = new BufferedReader(new FileReader(inputDataFile));
			br.readLine();
			while ((line = br.readLine()) != null && !line.isEmpty()) {
				String[] inputDataAttributes = line.split(Constant.CVS_SPLIT_BY);
				System.out.println("Data length " + inputDataAttributes.length);
				if (inputDataAttributes.length > 0) {
					InputData inputData = Utils.getInputData(inputDataAttributes);
					list.add(inputData);
				}
			}
			return list;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

}
