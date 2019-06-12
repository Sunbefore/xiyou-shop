import lombok.Data;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class TestEhCache {
    public static void main(String[] args) {
        // 1. 创建缓存管理器
        CacheManager cacheManager = CacheManager.create("D:\\xiyou-shop\\xiyou-shop\\xiyou-shop\\ehCache-test\\src\\main\\resources\\ehcache.xml");
        // 2. 获取缓存对象,HelloWorldCache是xml中配置的name属性
        Cache cache = cacheManager.getCache("HelloWorldCache");
        // 3. 创建元素
        Element element = new Element("key1", "value1");
        // 4. 将元素添加到缓存
        cache.put(element);
        // 5. 获取缓存
        Element value = cache.get("key1");
        System.out.println(value);
        System.out.println(value.getObjectValue());
        // 6. 删除元素
        cache.remove("key1");

        Dog dog = new Dog();
        dog.setId(1);
        dog.setName("泰迪");
        dog.setNum(2);
        Element dogElement = new Element("taidi", dog);
        cache.put(dogElement);
        Element element1 = cache.get("taidi");
        Dog dogResult = (Dog) element1.getObjectValue();
        System.out.println(cache.getSize());
        System.out.println(dogResult);
        // 刷讯缓存
        cache.flush();
    }
}

@Data
class Dog{
    private Integer id;
    private String name;
    private Integer num;
}
