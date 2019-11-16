package com.combinationMVC.boot.exploreComputer.web.application;

import com.combinationMVC.boot.exploreComputer.domain.Order;
import com.combinationMVC.boot.exploreComputer.entity.UserOrder;
import com.combinationMVC.boot.exploreComputer.services.UserOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/userorders")
public class userOrderController {
    private static final Logger logger  = LoggerFactory.getLogger(userOrderController.class);
    @Autowired
    private UserOrderService userOrderService;

//    @RequestMapping(method=RequestMethod.GET)
//    @ResponseBody
//    public String getUserOderall(Model model){
//        List<UserOrder> myList =  userOrderService.getOrder();
//        model.addAttribute("myLists",myList);
//
//        return "myLists";
//    }
//    @RequestMapping(method = RequestMethod.GET)
//    @ResponseBody
//    public List<Order> getUserOrders(@RequestParam(value="date", required=false)String dateString, Model model){
//        List<Order> orderList = this.userOrderService.getOrderbyDate();
////        model.addAttribute("orders",orderList);
//
//        return orderList;
//    }
//    @RequestMapping(method = RequestMethod.GET)
//    @ResponseBody
//    public String getData(){
//        userOrderService.getOrderbyDate(new Date());
////        logger.trace("This is a TRACE message.");
////        logger.debug("This is a DEBUG message.");
////        logger.info("This is an INFO message.");
////        logger.warn("This is a WARN message.");
////        logger.error("You guessed it, an ERROR message.");
////        String hello = this.userOderService.hello();
//        return "userorders";
//    }

    @RequestMapping(method=RequestMethod.GET)
    public String getUserOrders(){
        return "userorders";
    }
}
