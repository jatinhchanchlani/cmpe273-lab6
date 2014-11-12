package edu.sjsu.cmpe.cache.client;

import java.util.ArrayList;

public class Client {

	public static ConsistentHash<String> consistentHash;
	private static CacheServiceInterface cache1 = new DistributedCacheService("http://localhost:3000");
	private static CacheServiceInterface cache2 = new DistributedCacheService("http://localhost:3001");
	private static CacheServiceInterface cache3 = new DistributedCacheService("http://localhost:3002");
	
	public static CacheServiceInterface getCacheServer(String value) throws Exception
	{
		String bucket = consistentHash.get(value);
		if(bucket.equalsIgnoreCase("cache1"))
		{
			System.out.println("Hitting Server: http://localhost:3000 ");
			return cache1;
		}
		else if(bucket.equalsIgnoreCase("cache2"))
		{
			System.out.println("Hitting Server: http://localhost:3001 ");
			return cache2;
		}
		else
		{
			System.out.println("Hitting Server: http://localhost:3002 ");
			return cache3;
		}
		
	}
	
	public static void initializeConsistentHashing() throws Exception
	{
		ArrayList<String> servernames = new ArrayList<String>();
		servernames.add("Cache3");
		servernames.add("Cache1");
		servernames.add("Cache2");
				
		 consistentHash = new ConsistentHash<String>(30, servernames);		

	}
    public static void main(String[] args) throws Exception {
        System.out.println("Starting Cache Client...");
       
		initializeConsistentHashing();			

		System.out.println("put(1 => a)");		
		CacheServiceInterface cache = getCacheServer("1");
		cache.put(1, "a");
		
		System.out.println("put(2 => b)");
		cache = getCacheServer("2");
		cache.put(2, "b");
		
		System.out.println("put(3 => c)");
		cache = getCacheServer("3");
		cache.put(3, "c");
		
		
		System.out.println("put(4 => d)");
        cache = getCacheServer("4");
		cache.put(4, "d");
		
	
		System.out.println("put(5 => e)");
		cache = getCacheServer("5");
		cache.put(5, "e");
		
		
		System.out.println("put(6 => f)");
		cache = getCacheServer("6");
		cache.put(6, "f");
		
		
		System.out.println("put(7 => g)");
		cache = getCacheServer("7");
		cache.put(7, "g");
		
		System.out.println("put(8 => h)");
		cache = getCacheServer("8");
		cache.put(8, "h");
		
		
		System.out.println("put(9 => i)");
		cache = getCacheServer("9");
		cache.put(9, "i");
		
		
		System.out.println("put(10 => j)");
		cache = getCacheServer("10");
		cache.put(10, "j");
		
		
		System.out.println("\nGetting values from the cache servers\n");
		
		
		cache = getCacheServer("1");
		String value = cache.get(1);
		System.out.println("get(1) from Server, Value :" + value);
	
		cache = getCacheServer("2");
		value = cache.get(2);
		System.out.println("get(2) from Server, Value :" + value);
	
		cache = getCacheServer("3");
		value = cache.get(3);
		System.out.println("get(3) from Server, Value :" + value);
	
		cache = getCacheServer("4");
		value = cache.get(4);
		System.out.println("get(4) from Server, Value :" + value);
	
		cache = getCacheServer("5");
		value = cache.get(5);
		System.out.println("get(5) from Server, Value :" + value);
	
		cache = getCacheServer("6");
		value = cache.get(6);
		System.out.println("get(6) from Server, Value :" + value);
	
		cache = getCacheServer("7");
		value = cache.get(7);
		System.out.println("get(7) from Server, Value :" + value);
	
		cache = getCacheServer("8");
		value = cache.get(8);
		System.out.println("get(8) from Server, Value :" + value);
	
		cache = getCacheServer("9");
		value = cache.get(9);
		System.out.println("get(9) from Server, Value :" + value);
	
		cache = getCacheServer("10");
		value = cache.get(10);
		System.out.println("get(10) from Server, Value :" + value);
	
	    System.out.println("Existing Cache Client...");
    }

}
