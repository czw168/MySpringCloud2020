package com.atguigu.springcloud.lb;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLoadBalancer implements LoadBalancer{

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 负载均衡算法:
     * rest接口第几次请求数 % 服务器集群总数量 = 实际调用服务器位置下标,
     * 每次服务重启动后rest接口计数从1开始
     * @param serviceInstances
     * @return
     */
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }

    public final int getAndIncrement(){
        int current;
        int next;
        // 自旋锁
        do {
            current = this.atomicInteger.get();
            // 超过最大值,为0,重新计数 2147483647 Integer.MAX_VALUE
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        }while (!atomicInteger.compareAndSet(current,next));
        System.out.println("第" + current + "次访问...");
        return next;
    }


}
