package br.com.alterdata.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Utilities {
	
	public static String getString(InputStream inputStream) throws IOException {
		StringBuilder builder = new StringBuilder();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		String line;
		while((line = bufferedReader.readLine()) != null ) {
			builder.append(line).append('\n');
		}
		builder.trimToSize();
		return builder.toString();
	}

	public static String getValueFromQueryResult(String queryResult) {
		return queryResult.split("\\s{4}")[3].trim();
	}
	
	public static String quickSanitize(String str) {
		return str.replaceAll(";", "").trim();
	}
	
	public static boolean isNullOrEmpty(String str) {
		return (str == null || str.isEmpty());
	}
	
}
