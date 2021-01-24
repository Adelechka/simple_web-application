package ru.itis.javalab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itis.javalab.dto.OrderDto;
import ru.itis.javalab.services.CountryService;
import ru.itis.javalab.services.OrderService;
import ru.itis.javalab.services.ShippingService;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private ShippingService shippingService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String getOrdersPage(Model model) {
        model.addAttribute("countries", countryService.getAllCountries());
        model.addAttribute("shippings", shippingService.getAllShipping());
        model.addAttribute("orders", orderService.getAllOrders());
        return "orders_page";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createTour(OrderDto order) {
        orderService.saveOrder(order);
        return "redirect:/create";
    }

}
