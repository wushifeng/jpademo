package cn.csbit.repository;

import cn.csbit.model.Order;
import cn.csbit.model.OrderItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wushifeng on 2016/6/27.
 */
@Repository
public interface OrderItemDao extends CrudRepository<OrderItem, Integer > {
    public List<OrderItem> findByOrder(Order am);
}
