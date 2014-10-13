package org.OrderSorter.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.OrderSorter.Domain.Order;


import org.OrderSorter.Domain.Sorter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URL;

@Controller
@RequestMapping(value = "/rest/order")
public class OrderRestController {

    @RequestMapping(value ="/random", method = RequestMethod.GET)
    public @ResponseBody Order randomOrder() {
        Order randomOrder = new Order();
        randomOrder.randomizeOrder();
        return randomOrder;
    }

    @RequestMapping(value = "/sort", method = RequestMethod.POST)
    public @ResponseBody Order sortedOrder(@RequestBody Order order) {

        order.sizeItems();
        System.out.println("Number of items: " + order.getItems().size());
        order.boxOrder(order.sortByType());
        return order;
    }

    @RequestMapping(value = "/sort/random", method = RequestMethod.GET)
    public @ResponseBody Order sortedOrder() throws Exception{

        final String url = "https://sleepy-eyrie-4425.herokuapp.com/getOrder";
        // This creates a JSON object mapper

        ObjectMapper mapper = new ObjectMapper();

        Order order =  mapper.readValue(new URL(url), Order.class);

        order.sizeItems();
        System.out.println("Number of items: " + order.getItems().size());

        order.boxOrder(order.sortByType());
        return order;
    }

    @RequestMapping(value = "/sort/random/min_box", method = RequestMethod.GET)
    public @ResponseBody Order sortedOrderByMinNumBoxes() throws Exception {

        final String url = "https://sleepy-eyrie-4425.herokuapp.com/getOrder";
        // This creates a JSON object mapper

        ObjectMapper mapper = new ObjectMapper();

        Order order =  mapper.readValue(new URL(url), Order.class);
        order.sizeItems();

        Sorter sort = new Sorter();
        order.setBoxes(sort.fillBoxesToMaxCapacity(order.getItems()));
        order.setNumOfBoxes(order.getBoxes().size());

        return order;
    }

    @RequestMapping(value = "/sort/min_box", method = RequestMethod.POST)
    public @ResponseBody Order sortedOrderByMinNumBoxes(@RequestBody Order order) {
        order.sizeItems();
        System.out.println("Number of items: " + order.getItems().size());

        Sorter sorter = new Sorter();
        order.setBoxes(sorter.fillBoxesToMaxCapacity(order.getItems()));
        order.setNumOfBoxes(order.getBoxes().size());

        return order;
    }
}
