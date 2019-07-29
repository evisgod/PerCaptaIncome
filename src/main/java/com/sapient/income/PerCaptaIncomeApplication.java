package com.sapient.income;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sapient.income.engine.FileEngine;

@SpringBootApplication
@EnableAutoConfiguration
public class PerCaptaIncomeApplication {

	@Autowired
	FileEngine fileEngine;

	public static void main(String[] args) throws IOException {
		ApplicationContext context = SpringApplication.run(PerCaptaIncomeApplication.class, args);
		FileEngine fileEngine = (FileEngine) context.getBean("fileEngine");
		fileEngine.readInputFile();
	}

}
