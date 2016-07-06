package cn.csbit.model;

import cn.csbit.model.base.BaseModel;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;

/**
 * Created by wushifeng on 2016/6/27.
 */
@Entity
@Table
public class OrderItem extends BaseModel {
    public Float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Float sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Column(nullable = false)
    private Float sellPrice = 0f;
    // optional=true：可选，表示此对象可以没有，可以为null；false表示必须存在
    @ManyToOne(cascade = {CascadeType.REMOVE, CascadeType.MERGE}, optional = false)
    @JoinColumn(name = "order_id")
    private Order order;

    //级联删除时必须要的构造
    public OrderItem() {
    }

    public OrderItem(Order order, Float sellPrice) {
        super();
        this.order = order;
        this.sellPrice = sellPrice;
    }
}
