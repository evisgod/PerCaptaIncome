package com.sapient.income.service;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sapient.income.model.InputData;

@Service
public class FileReaderService {

	public void parseInputData(List<InputData> inputDataList) {
		Map<String, Map<String, Double>> list = inputDataList.stream()
				.collect(Collectors.groupingBy(InputData::getCountry,
						Collectors.groupingBy(InputData::getCity, Collectors.averagingDouble(InputData::getAmount))));

		for (Entry<String, Map<String, Double>> entry : list.entrySet())
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
	}

}
