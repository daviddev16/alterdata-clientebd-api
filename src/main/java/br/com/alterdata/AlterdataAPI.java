package br.com.alterdata;

import java.io.IOException;
import java.util.Objects;

import static br.com.alterdata.util.Utilities.isNullOrEmpty;
import static br.com.alterdata.util.RegeditUtil.*;

public final class AlterdataAPI {

	private static final String CLIENTEBD_HKEY_PATH = "HKEY_LOCAL_MACHINE\\SOFTWARE\\WOW6432Node\\TurboPower\\FlashFiler\\Client Configuration";

	public static void updateClienteBDProperty(ClienteBDPropertyType clienteBDPropertyType, String value) throws IOException {
		Objects.requireNonNull(clienteBDPropertyType, "ClienteBD Property is null.");
		if (isNullOrEmpty(value))
			throw new NullPointerException(String.format("The new value for \"%s\" is null. It will not be changed.",
					clienteBDPropertyType.getKey().toUpperCase()));

		updateRegSubkey(CLIENTEBD_HKEY_PATH, clienteBDPropertyType.getKey(), value);
	}

	public static String queryClienteBDProperty(ClienteBDPropertyType clienteBDPropertyType) throws IOException, InterruptedException {
		Objects.requireNonNull(clienteBDPropertyType, "ClienteBD Property is null.");
		return queryRegSubkey(CLIENTEBD_HKEY_PATH, clienteBDPropertyType.getKey());
	}

	


}
