package cn.csbit.service;

import cn.csbit.model.Order;
import cn.csbit.model.OrderItem;
import cn.csbit.repository.OrderDao;
import cn.csbit.repository.OrderItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wushifeng on 2016/6/27.
 */
@Service
public class OrderService {
    @Autowired
    OrderDao ord;
    @Autowired
    OrderItemDao ordItem;

    @Transactional
    public void getLazy(Order order) {
        List<Order> ls = this.ord.findByAmount(order.getAmount());
        OrderItem it = null;
        assert (ls.size() > 0);
        for (Order o : ls) {
            System.out.println(o.getItems().size());
            it = o.getItems().iterator().next();
        }

        it = this.ordItem.findOne(it.getId());
        System.out.println(it.getOrder().getAmount());
    }
}
