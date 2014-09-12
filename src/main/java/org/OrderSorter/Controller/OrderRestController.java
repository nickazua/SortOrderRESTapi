package org.OrderSorter.Controller;

import org.OrderSorter.Domain.Order;
import org.OrderSorter.Domain.Item;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping(value = "/rest/order")
public class OrderRestController {

    @RequestMapping(value ="/random", method = RequestMethod.POST)
    public @ResponseBody Order randomOrder() {
        Order randomOrder = new Order();
        randomOrder.randomizeOrder();
        return randomOrder;
    }

    @RequestMapping(value = "/sort", method = RequestMethod.POST)
    public @ResponseBody Order sortedOrder(@RequestBody Order order) {
        HashMap sortedOrder = new HashMap();
        order.sizeItems();
        System.out.println(order.getItems().size());
        order.boxOrder(order.sortByType());
        return order;
    }
}
