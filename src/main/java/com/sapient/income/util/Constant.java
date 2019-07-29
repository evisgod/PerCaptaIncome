package com.sapient.income.util;

public class Constant {

	public static final String CVS_SPLIT_BY = ",";

	public enum FILE_TYPE {
		CSV(1), XML(2), TXT(3);
		int type;

		FILE_TYPE(int type) {
			this.type = type;
		}
	}
}
