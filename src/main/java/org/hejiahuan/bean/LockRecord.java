package org.hejiahuan.bean;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author HJH
 * @create 2020-07-06 14:12
 */
@Table(name="lock_record")
@Getter
@Setter
public class LockRecord {

    @Id
    private  Integer id;

    @Column(name="lock_name")
    private String lockName;
}
