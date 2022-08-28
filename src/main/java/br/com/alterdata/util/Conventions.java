package br.com.alterdata.util;

import java.util.Objects;

public final class Conventions {

	public static String toStringValue(boolean value) {
		return value ? "S" : "N";
	}
	
	public static boolean toBooleanValue(String value) {
		return Objects.requireNonNull(value, "The value is null.").equals("S");
	}
	
}
