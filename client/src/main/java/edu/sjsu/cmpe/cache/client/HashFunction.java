package edu.sjsu.cmpe.cache.client;
import java.security.MessageDigest;
import java.util.ArrayList;


public class HashFunction {
	
	public static String hash(String value)throws Exception
	{
		
		 
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(value.getBytes());
 
        byte byteData[] = md.digest();
 
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
 
        return sb.toString();
	}
	
}
