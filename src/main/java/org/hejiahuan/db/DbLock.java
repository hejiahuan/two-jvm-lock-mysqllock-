package org.hejiahuan.db;

import org.hejiahuan.bean.LockRecord;
import org.hejiahuan.mapper.LockRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 *@Component将整个类给spring来管理
 * @author HJH
 * @create 2020-07-06 14:02
 */
@Component
public class DbLock implements Lock {

    private static final  String LOCK_NAME="db_lock_stock";

    @Autowired
    private LockRecordMapper lockRecordMapper;

    /**
     * 上锁
     */
    public void lock() {
        while (true){
            boolean b = tryLock();
            //如果为false
            if(b){
                LockRecord lockRecord = new LockRecord();
                //上锁
                lockRecord.setLockName(LOCK_NAME);

                lockRecordMapper.insert(lockRecord);

                return;

            }else {
                //查询到有锁
                System.out.println("有人再用！！！！等待中........");
            }
        }


    }

    public void lockInterruptibly() throws InterruptedException {

    }

    /**
     * 尝试获取锁，在数据库中添加之前，我们看看有没有记录在数据中
     * sql:select * from lock_record where lock_name = "db_lock_stock"
     * @return
     */
    public boolean tryLock() {
        Example ex=new Example(LockRecord.class);
        ex.createCriteria().andEqualTo("lockName",LOCK_NAME);

        LockRecord lockRecord = lockRecordMapper.selectOneByExample(ex);

        if (lockRecord==null){
            return true;
        }

        return false;
    }

    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    /**
     * 解锁
     * 就是删除mysql中的数据
     */
    public void unlock() {
        Example ex=new Example(LockRecord.class);
        ex.createCriteria().andEqualTo("lockName",LOCK_NAME);

      lockRecordMapper.deleteByExample(ex);
    }

    public Condition newCondition() {
        return null;
    }
}
