package cn.csbit.model;

import cn.csbit.model.base.BaseModel;

import javax.persistence.*;

/**
 * Created by wushifeng on 2016/6/27.
 */
@Entity
@Table
public class User extends BaseModel {
    @Column(nullable = false)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
