package br.com.alterdata;

import java.util.Arrays;

public enum ClienteBDPropertyType {

	DATABASE_PROVIDER          ("ProviderName"   , "PostgreSQL", "SQL Server"),
	DATABASE_NAME              ("Database"       , "ALTERDATA"),
	SERVER_ADDRESS             ("Server"         , "localhost"),
	
	CHANGE_SERVER_ADDRESS      ("ShowConnection" , "S", "N"),
	CHANGE_DATABASE_CONNECTION ("ShowDataBase"   , "S", "N"),
	CHANGE_DATABASE_PROVIDER   ("ExibeProvider"  , "S", "N");
	
	private final String[] defaults;
	private final String key;
	
	private ClienteBDPropertyType(String key, String... defaults) {
		this.defaults = Arrays.copyOf(defaults, defaults.length);
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public String[] getDefaults() {
		return defaults;
	}
	
}
