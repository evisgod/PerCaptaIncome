package com.sapient.income.reader;

import java.util.List;

import com.sapient.income.model.InputData;

@FunctionalInterface
public interface CustomFileReader {
	List<InputData> read(String filepath);
}
