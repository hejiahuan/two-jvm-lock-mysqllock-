package org.hejiahuan.mapper;

import org.hejiahuan.bean.LockRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tk.mybatis.mapper.entity.Example;


/**
 * @author HJH
 * @create 2020-07-06 15:04
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class LockRecordMapperTest {

    @Autowired
    private LockRecordMapper lockRecordMapper;

    @Test
    public void test(){

        Example ex=new Example(LockRecord.class);
        ex.createCriteria().andEqualTo("lockName","dddd");

        LockRecord lockRecord = lockRecordMapper.selectOneByExample(ex);
        System.out.println(lockRecord);

    }

}