package com.sapient.income.util;

import com.sapient.income.model.InputData;

public class Utils {
	public static InputData getInputData(String[] inputDataAttributes) {
		InputData inputData = new InputData();
		inputData.setCity(inputDataAttributes[0]);
		inputData.setCountry(inputDataAttributes[1]);
		inputData.setGender(inputDataAttributes[2]);
		inputData.setCurrency(inputDataAttributes[3]);
		inputData.setAmount(Double.parseDouble(inputDataAttributes[4]));
		return inputData;
	}
}
