package validator;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import exceptions.PatientException;

public class PatientValidation {
	public static void nameValidate(String name) throws PatientException {
		if (name.length() == 0) {
			throw new PatientException("Null fields");
		}

		Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
		Matcher matcher = pattern.matcher(name);
		if (!matcher.find()) {
			throw new PatientException("Fields with invalid format");
		}

	}
	
	public static void ssnValidate(String ssn) throws PatientException {
		if (ssn.equals(""))
			throw new PatientException("Null fields");
		if (ssn.length() != 13) {
			System.out.println("ssn="+ ssn+" si lungime="+ssn.length());
			throw new PatientException("Fields with invalid format");
		}
		Pattern pattern = Pattern.compile("^\\d+$");
		Matcher matcher = pattern.matcher(ssn);
		if (!matcher.find()) {
			throw new PatientException("Fields with invalid format");
		}
	}
	
	public static void addressValidate(String address) throws PatientException {
		if (address.length() == 0) {
			throw new PatientException("Null fields");
		}
	}
}
