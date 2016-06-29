package cn.csbit.controller;

import cn.csbit.form.PersonForm;
import cn.csbit.service.OrderService;
import cn.csbit.model.Order;
import cn.csbit.model.OrderItem;
import cn.csbit.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import cn.csbit.repository.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by wushifeng on 2016/6/27.
 */
@Controller
public class HomeController {
    @Autowired
    UserDao dao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login() {
        User u = new User();
        u.setName("hello");

        dao.save(u);

        u = dao.findOne(1);
        if (u == null)
            assert (true);

        List<User> ls = dao.findByName("hello");
        if (ls == null)
            assert (true);

        dao.delete(ls);
        return "index";
    }

    @Autowired
    OrderDao ord;
    @Autowired
    OrderItemDao ordItem;
    @Autowired
    OrderService svc;

    @RequestMapping(value = "/o", method = RequestMethod.GET)
    public String order() {
        this.ord.deleteAll();

        Order order = new Order();
        order.setAmount(34f);
        order.getItems().add(new OrderItem(order, 20f));
        order.getItems().add(new OrderItem(order, 25f));

        this.ord.save(order);

        //Transaction close 在controllerc层处理关系就不对了
//            List<Order> ls = this.ord.findByAmount(34f);
//            assert(ls.size() > 0);
//            for(Order o : ls){
//                o.setItems(ordItem.findByOrder(o));
//
//                System.out.println(o.getItems().size());
//            }
        this.svc.getLazy(order);

        Integer id = order.getId();
        order = new Order();
        order.setId(id);

        List<OrderItem> ls = this.ordItem.findByOrder(order);
        System.out.println(ls.size());

        return "index";
    }

    @RequestMapping(value = "/newadd", method = RequestMethod.GET)
    public ModelAndView newadd(Long typeId, Model model) throws Exception {
        PersonForm person = new PersonForm();

        model.addAttribute(person);
        System.out.println("sss");
        return new ModelAndView("/user/personAdd", model.asMap());
    }

    @RequestMapping(value = "/savePerson")
    public ModelAndView savePerson(@Valid PersonForm person,
                                   BindingResult bindingResult) {
        Model model = new ExtendedModelMap();
        model.addAttribute(person);

        if (bindingResult.hasErrors()) {
            model.addAttribute(person);
            return new ModelAndView("/user/personAdd", model.asMap());
        } else {
            person = new PersonForm();
            model.addAttribute(person);
            return new ModelAndView("/user/personAdd", model.asMap());
        }
    }
}
