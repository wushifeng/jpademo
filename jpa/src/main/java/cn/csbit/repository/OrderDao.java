package cn.csbit.repository;

import cn.csbit.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wushifeng on 2016/6/27.
 */
@Repository
public interface  OrderDao  extends CrudRepository<Order, Integer > {
    public List<Order> findByAmount(Float am);
}
