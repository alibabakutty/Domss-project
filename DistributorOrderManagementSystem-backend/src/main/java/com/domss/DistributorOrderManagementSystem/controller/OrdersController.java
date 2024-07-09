package com.domss.DistributorOrderManagementSystem.controller;


import com.domss.DistributorOrderManagementSystem.dto.ReportDto;
import com.domss.DistributorOrderManagementSystem.entity.Orders;
import com.domss.DistributorOrderManagementSystem.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("orders")
public class OrdersController {

    @Autowired
    private OrdersService orderService;

    @PostMapping("/booking")
    public ResponseEntity<String> saveOrder(@RequestBody Orders order){
        return orderService.addOrder(order);
    }
    @GetMapping("/getAllOrders")
    public ResponseEntity<List<Orders>> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/getOrder/{orderId}")
    public ResponseEntity<Orders> findOrderById(@PathVariable Long orderId){
        return orderService.findOrderById(orderId);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<String> updateOrder(@RequestBody Orders order, @PathVariable Long orderId){
        return orderService.updateOrder(order, orderId);
    }

    @GetMapping("/getInformation")
    public List<ReportDto> getJoinInformation(){
        return orderService.getJoinInformation();
    }

}
