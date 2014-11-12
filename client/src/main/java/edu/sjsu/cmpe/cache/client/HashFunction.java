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
	
	public static void main(String[] args) throws Exception {
		ArrayList<String> servernames = new ArrayList<String>();
		servernames.add("Cache3");
		servernames.add("Cache1");
		servernames.add("Cache2");
		
		
		ConsistentHash<String> consistentHash = new ConsistentHash<String>(30, servernames);
		
		System.out.println(consistentHash.get("6"));
		int i =1;
		System.out.println(String.valueOf(i));
	}
}
