package org.OrderSorter.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/sortorder")
public class SortOrderController {

    @RequestMapping
    public String get() {
        return "sortorder";
    }

//    @RequestMapping(value = "/{orderId}", method = RequestMethod.GET)
//    public String getOrder(@PathVariable(value = "orderId") String orderId, Model model) {
//        model.addAttribute("orderId", orderId);
//        return "sortorder";
//    }
}
