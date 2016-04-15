package ch.hasselba.xpages;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {

	private static final String SECRET_SALT = "geheim";
	private static final int HASH_LENGTH = 8;

	public static boolean isValidHash(final String data, final String hash) {
		String hashedData = generateHash(data);
		return hash.equalsIgnoreCase(hashedData);
	}

	public static String generateHash(final String data) {
		String result = null;
		StringBuffer toHash = new StringBuffer();
		toHash.append(data);
		toHash.append(SECRET_SALT);

		try {
			byte[] bytesOfMessage = toHash.toString().getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] thedigest = md.digest(bytesOfMessage);
			result = new BigInteger(1, thedigest).toString(16);
			while (result.length() < 32) {
				result = "0" + result;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return result;
	}

}