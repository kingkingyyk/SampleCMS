package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utils {

	public static byte[] hash(String password) {
		try {
		    MessageDigest sha256 = MessageDigest.getInstance("SHA-256");        
		    byte[] passBytes = password.getBytes();
		    byte[] passHash = sha256.digest(passBytes);
		    return passHash;
		} catch (NoSuchAlgorithmException e) {}
		return new byte [0];
	}
}
