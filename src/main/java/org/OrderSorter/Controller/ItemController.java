package org.OrderSorter.Controller;

import org.OrderSorter.Domain.Item;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping(value = "/item")
public class ItemController {

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Item item(@RequestBody Item item) {
        return item;
    }
}
