package com.liam.springboot.dubboconsumer.dubboapi;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.rpc.RpcContext;
import com.liam.springboot.dubboapi.SimpleService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 异步调用
 *
 * @Author: Liam
 * @Date: 2019/3/13 23:06
 */
@SuppressWarnings("Duplicates")
public class DubboApiAsync {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //应用配置
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("dubbo-consumer");
        //注册中心配置
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("127.0.0.1:2181");
        registryConfig.setProtocol("zookeeper");
        //泛化服务调用配置
        ReferenceConfig<SimpleService> referenceConfig = new ReferenceConfig<>();
        referenceConfig.setApplication(applicationConfig);
        referenceConfig.setRegistry(registryConfig);
        referenceConfig.setInterface(SimpleService.class);
        referenceConfig.setVersion("1.0.0");
        referenceConfig.setGroup("dubbo");
        referenceConfig.setTimeout(3000);
        referenceConfig.setAsync(true);
        SimpleService service = referenceConfig.get();
        //调用
        System.out.println(service.sayHello("Liam"));
        Future<String> serviceFutureOne = RpcContext.getContext().getFuture();
        System.out.println(service.sayHello2("Liam2"));
        Future<String> serviceFutureTwo = RpcContext.getContext().getFuture();
        System.out.println(serviceFutureOne.get());
        System.out.println(serviceFutureTwo.get());
    }
}
