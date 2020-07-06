package org.hejiahuan.test;

import org.hejiahuan.bean.Stock;
import org.hejiahuan.db.DbLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author HJH
 * @create 2020-07-04 0:07
 */
public class StockMain {

    @Autowired
    private static DbLock dbLock;

    static {
//        从spring中拿出dblock
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("beans.xml");
        dbLock  = classPathXmlApplicationContext.getBean(DbLock.class);
    }

    static class StockTread implements Runnable{

        public void run() {
            //调用方法前上锁
            dbLock.lock();
            //调用stock减少库存
            boolean s=new Stock().reduceStock();
            //调用完后解锁。
            dbLock.unlock();
            if(s){
                System.out.println(Thread.currentThread().getName()+"减少库存成功");
            }else {
                System.out.println(Thread.currentThread().getName()+"减少库存失败");
            }
        }
    }

    public static void main(String[] args) {

        new Thread(new StockTread(),"线程1").start();
        new Thread(new StockTread(),"线程2").start();
    }
}
