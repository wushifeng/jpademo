package cn.csbit.model;

import cn.csbit.model.base.BaseModel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by wushifeng on 2016/6/27.
 */
@Entity
@Table(name="orders")
public class Order extends BaseModel {
    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Set<OrderItem> getItems() {
        return items;
    }

    public void setItems(Set<OrderItem> items) {
        this.items = items;
    }

    @Column(nullable = false)
    private Float amount = 0f;
    // @OneToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    // mappedBy="order": 指明Order类为双向关系维护端，负责外键的更新
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "order")
    private Set<OrderItem> items = new HashSet<OrderItem>();
}
