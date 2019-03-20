package com.liam.springboot.dubboconsumer.dubboapi;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.utils.ReferenceConfigCache;
import com.alibaba.dubbo.rpc.service.GenericService;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.HashMap;
import java.util.Map;

/**
 * 泛化调用
 *
 * @Author: Liam
 * @Date: 2019/3/13 22:12
 */
public class DubboApiGeneric {
    public static void main(String[] args) throws JsonProcessingException {
        //应用配置
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("dubbo-consumer");
        //注册中心配置
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("127.0.0.1:2181");
        registryConfig.setProtocol("zookeeper");
        //泛化服务调用配置
        ReferenceConfig<GenericService> referenceConfig = new ReferenceConfig<>();
        referenceConfig.setApplication(applicationConfig);
        referenceConfig.setRegistry(registryConfig);
        referenceConfig.setVersion("1.0.0");
        referenceConfig.setGroup("dubbo");
        referenceConfig.setTimeout(3000);
        referenceConfig.setInterface("com.liam.springboot.dubboapi.SimpleService");
        referenceConfig.setGeneric(true);
        //ReferenceConfig实例很重，封装了与注册中心的连接以及与提供者的连接，
        //需要缓存，否则重复生成ReferenceConfig可能造成性能问题并且会有内存和连接泄漏
        //API方式编程时，容易忽略此问题
        //这里使用dubbo内置的简单缓存工具类进行缓存
        ReferenceConfigCache configCache = ReferenceConfigCache.getCache();
        GenericService service = configCache.get(referenceConfig);
        //调用
        Object result = service.$invoke("sayHello", new String[]{"java.lang.String"}, new Object[]{"Liam"});
        System.out.println(result);
        Map<String, Object> map = new HashMap<>();
        map.put("class", "com.liam.springboot.dubboprovider.service.UserImpl");
        map.put("name", "liam");
        map.put("password", "123456");
        result = service.$invoke("testPojo", new String[]{"com.liam.springboot.dubboapi.User"}, new Object[]{map});
        System.out.println(result);
    }
}
