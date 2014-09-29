package org.OrderSorter.Controller;

import org.OrderSorter.Domain.Header;
import org.OrderSorter.Domain.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/header")
public class HeaderController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
        public Header header() {
        Header header = new Header();
        header.generateOrderNum();
        header.generateCustomerName();
        header.generateNumOfBoxes();
        return header;
    }
}