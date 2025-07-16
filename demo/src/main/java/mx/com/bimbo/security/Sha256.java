package mx.com.bimbo.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha256 {
	 public static String getSHA256(String input) {
	        try {
	            MessageDigest digest = MessageDigest.getInstance("SHA-256");
	            byte[] hashBytes = digest.digest(input.getBytes());
	            StringBuilder hexString = new StringBuilder();
	            for (byte b : hashBytes) {
	                String hex = Integer.toHexString(0xff & b);
	                if (hex.length() == 1) {
	                    hexString.append('0');
	                }
	                hexString.append(hex);
	            }
	            return hexString.toString();
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
}
