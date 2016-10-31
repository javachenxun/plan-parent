package component.redis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import com.chenxun.component.redis.JedisClient;

/** 
 * @author：chenxun
 * 创建时间：2016年10月15日 下午9:41:26 
 * 参考：
 * 说明：
 */
public class RedisTest {
	
    Jedis jedis = JedisClient.getJedis();
	
	
    @Test
	public  void methodString1() throws InterruptedException {
    	
		jedis.set("foo", "bar");
		System.out.println(jedis.get("foo"));
		System.out.println(jedis.exists("foo"));
		
		jedis.append("foo", "bar");
		System.out.println(jedis.get("foo"));
		
		jedis.expire("foo", 3);//单位秒
		System.out.println(jedis.get("foo"));
		
		Thread.sleep(2000L);
		System.out.println(jedis.get("foo"));
		
		jedis.del("foo");
		System.out.println(jedis.get("foo"));
	}
    /**
     * Redis的Hash实际是内部存储的Value为一个HashMap，
     * 并提供了直接存取这个Map成员的接口
     */
    @Test
   	public  void methodHash2()  {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "chenxun");
		map.put("age", "22");
		jedis.hmset("map",map);
		System.out.println(jedis.hmget("map", "name","age"));
		
		System.out.println(jedis.hkeys("map"));
		System.out.println(jedis.hvals("map"));
		System.out.println(jedis.hlen("map"));
		
		//jedis.del("map");
   	}
    
    /**
     * 先进后出
     */
    @Test
	public  void methodList3_1()  {
		
    	for (int i = 0; i < 5; i++) {
    		jedis.lpush("listkey", "listvalue"+i);
		}
    	
    	Long llen = jedis.llen("listkey");
		
    	for (int i = 0; i < llen; i++) {
    		System.out.println(jedis.lpop("listkey"));
		}
    	
    	System.out.println(jedis.lindex("listkey",2));
   	}
    /**
     *  先进后出
     */
    @Test
  	public  void methodRPushPop3_2()  {
  		
    	for (int i = 0; i < 5; i++) {
    		jedis.rpush("listkey", "message"+i);
		}
    	for (int i = 0; i < 5; i++) {
    		System.out.println(jedis.rpop("listkey"));
		}
    	
    	System.out.println(jedis.scard("setkey"));
    }
    
    /**
     * 无序的取出  ，没有的为null
     */
    @Test
  	public  void methodSet4()  {
    	jedis.del("");
    	for (int i = 0; i < 5; i++) {
    		jedis.sadd("setkey", "message"+i);
		}
    	
    	for (int i = 0; i < 6; i++) {
    		System.out.println(jedis.spop("setkey"));
		}
    	System.out.println(jedis.scard("setkey"));
    	
    }
    
    /**
     * 有序存储
     */
    @Test
  	public  void methodSortSet5()  {
    	jedis.del("setkey");
    	
    	Random random = new Random();
    	for (int i = 0; i < 5; i++) {
    		jedis.zadd("setkey", random.nextInt(10) ,"message"+i);
		}
    	
    	System.out.println(jedis.zcard("setkey"));//返回集合的元素个数 
    	
    	for (int i = 0; i < 5; i++) {
    		jedis.zrem("setkey", "message"+i);//删除
    		System.out.println(jedis.zrange("setkey",0,-1));
		}
    	
    	System.out.println(jedis.zcard("setkey"));
    	
    }
    /**
     * 
     */
    @Test
    public  void methodTransaction6()  {
        String watch = jedis.watch("testabcd");  
        System.out.println(Thread.currentThread().getName()+"--"+watch);  
        Transaction multi = jedis.multi();  
        multi.set("testabcd", "23432");  
        try {  
            Thread.sleep(3000);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
        List<Object> exec = multi.exec();  
        System.out.println("---"+exec);  
        jedis.unwatch(); 
    }
    
    
    class Person{
    	
    	private String name;
    	private Integer age;
    	
		public Person(String name, Integer age) {
			super();
			this.name = name;
			this.age = age;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getAge() {
			return age;
		}
		public void setAge(Integer age) {
			this.age = age;
		}
    	
    }
}
