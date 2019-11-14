package com.combinationMVC.boot.exploreComputer.web.application;

import com.combinationMVC.boot.exploreComputer.domain.Order;
import com.combinationMVC.boot.exploreComputer.services.UserOderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/userorders")
public class userOrderController {
    private static final Logger logger  = LoggerFactory.getLogger(userOrderController.class);
    @Autowired
    private UserOderService userOderService;

//    @RequestMapping(method = RequestMethod.GET)
//    @ResponseBody
//    public String getUserOrders(@RequestParam(value="date", required=false)String dateString, Model model){
//        List<Order> orderList = this.userOderService.getOrderForDate(dateString);
//        model.addAttribute("orders",orderList);
//
//        return "orders";
//    }
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String getData(){
        logger.trace("This is a TRACE message.");
        logger.debug("This is a DEBUG message.");
        logger.info("This is an INFO message.");
        logger.warn("This is a WARN message.");
        logger.error("You guessed it, an ERROR message.");
        return "This is finish point";
    }
}
