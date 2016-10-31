package com.chenxun.component.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/** 
 * @author：chenxun
 * 创建时间：2016年10月16日 下午3:06:53 
 * 参考：
 * 说明：
 * download ：https://github.com/ServiceStack/redis-windows
 */
public class JedisClient {
	
   static Logger log = LoggerFactory.getLogger(JedisClient.class);  
   
   private static JedisPool  pool = null; 
   
   private static String       ip = "127.0.0.1";
   private static int          port  = 6379;
   private static int          timeout  = 1000;
   private static int          maxWaitMillis  = 1000;
   private static int          maxTotal  = 100;
   
   private JedisClient() {}
   
   /** 
    * 设置  PoolConfig
    */  
   private static JedisPoolConfig getPoolConfig() {  
	   JedisPoolConfig  config = new JedisPoolConfig();
	   
	   config.setMaxTotal(maxTotal);
	   config.setMaxWaitMillis(maxWaitMillis);
	   config.setTestOnBorrow(true);  
	   config.setTestOnReturn(true);  
	   
	   return config;  
   }  
   
   /** 
    * 获取连接池
    */  
   private static JedisPool getPool() {  
       try{     
    	   if(pool==null){
    		   synchronized (JedisClient.class) {
    			   pool = new JedisPool(getPoolConfig(), ip, port,timeout);  
			   }
    	   }
    	   
       } catch(Exception e) {  
    	   log.error("获取 JedisPool 异常");
       }  
       return pool;  
   }  
   
   public static Jedis getJedis(){
	   
	  return JedisClient.getPool().getResource();
	  
   }
}
