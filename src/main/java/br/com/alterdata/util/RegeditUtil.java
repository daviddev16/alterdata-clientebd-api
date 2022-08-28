package br.com.alterdata.util;

import java.io.IOException;

import static br.com.alterdata.util.Utilities.*;

public class RegeditUtil {

	public static void updateRegSubkey(String regkeyPath, String subkeyName, String newValue) throws IOException {
		Runtime.getRuntime().exec(
				String.format("reg add \"%s\" /v \"%s\" /t REG_SZ /d \"%s\" /f", 
						regkeyPath, 
						subkeyName, 
						quickSanitize(newValue)));
	}

	public static String queryRegSubkey(String regkeyPath, String subkeyName) throws IOException, InterruptedException {
		Process process = Runtime.getRuntime().exec(
				String.format("reg query \"%s\" /v \"%s\"", 
						regkeyPath, 
						quickSanitize(subkeyName)));
		process.waitFor();
		if (process.exitValue() != 0)
			throw new RuntimeException(String.format("Could not query on [%s].\n%s", subkeyName, getString(process.getErrorStream())));
		
		String queryResult = getString(process.getInputStream());
		return getValueFromQueryResult(queryResult);
	}
	
}
