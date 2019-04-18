package com.licerlee.fastwork.common.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.util.Date;

/**
 * 基础entity定义
 * @author licer
 */
@Data
@MappedSuperclass
public class BaseEntity extends MysqlSquenceIdEntity implements Serializable {

    public static final Integer DELETE_FLAG_DELETED = 1;
    public static final Integer DELETE_FLAG_NORMAL = 0;


    /**
     * 创建时间
     */
    @Column(updatable = false)
   protected Date createAt;
    /**
     * 创建人
     */
    @Column(nullable = false)
   protected String createBy;
    /**
     * 最后更新时间
     */
   @Column(nullable = false)
   protected Date updateAt;
    /**
     * 最后操作人
     */
   @Column(nullable = false)
   protected String updateBy;
    /**
     * 数据标志
     */
   @Column(nullable = false)
   protected Integer deletedFlag;



   @PrePersist
    public void prePersit(){
       if(this.createAt == null){
           this.setCreateAt(new Date());
       }
       this.setUpdateAt(this.getCreateAt());
       if(this.deletedFlag == null){
           this.setDeletedFlag(BaseEntity.DELETE_FLAG_NORMAL);
       }
   }


   @PreUpdate
    public void preUpdate(){
       this.setUpdateAt(new Date());
   }
}
