package com.domss.DistributorOrderManagementSystem.service;

import com.domss.DistributorOrderManagementSystem.dto.ReportDto;
import com.domss.DistributorOrderManagementSystem.entity.OrderItems;
import com.domss.DistributorOrderManagementSystem.entity.Orders;
import com.domss.DistributorOrderManagementSystem.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrdersService {

    @Autowired
    private OrdersRepository orderRepository;

    public ResponseEntity<String> addOrder(Orders order) {
        List<OrderItems> orderItems = order.getItems().stream().map(items -> {
            OrderItems item = new OrderItems();
            item.setCategory(items.getCategory());
            item.setCode(items.getCode());
            item.setDescription(items.getDescription());
            item.setOrderQty(items.getOrderQty());
            item.setUom(items.getUom());
            item.setApprovedQuantity(items.getApprovedQuantity());
            item.setRate(items.getRate());
            item.setDiscount(items.getDiscount());
            item.setAmount(items.getAmount());
            return item;
        }).collect(Collectors.toList());

        order.setItems(orderItems);
        orderRepository.save(order);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);

    }

    public ResponseEntity<List<Orders>> getAllOrders() {
        try {
            return new ResponseEntity<>(orderRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Orders> findOrderById(Long id) {
        try {
            Optional<Orders> orderOptional = orderRepository.findById(id);
            if (orderOptional.isPresent())
                return new ResponseEntity<>(orderOptional.get(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<String> updateOrder(Orders newOrder, Long orderId) {
        Optional<Orders> optionalOrder = orderRepository.findById(orderId);
        if (optionalOrder.isEmpty()) {
            return new ResponseEntity<>("Order Not found", HttpStatus.NOT_FOUND);
        }
        Orders existingOrder = optionalOrder.get();
        existingOrder.setVoucherType(newOrder.getVoucherType());
        existingOrder.setVoucherNo(newOrder.getVoucherNo());
        existingOrder.setDistributorName(newOrder.getDistributorName());
        existingOrder.setVoucherDate(newOrder.getVoucherDate());
        existingOrder.setDistributorCode(newOrder.getDistributorCode());
        existingOrder.setCreatedBy(newOrder.getCreatedBy());
        existingOrder.setApprovedBy(newOrder.getApprovedBy());
        existingOrder.setNarration(newOrder.getNarration());

        List<OrderItems> updatedOrderItems = newOrder.getItems().stream().map(items -> {

            Optional<OrderItems> existingItem = existingOrder.getItems().stream()
                    .filter(item -> item.getId().equals(items.getId())).findFirst();

            if (existingItem.isPresent()) {
                OrderItems item = existingItem.get();
                item.setCategory(items.getCategory());
                item.setCode(items.getCode());
                item.setDescription(items.getDescription());
                item.setOrderQty(items.getOrderQty());
                item.setUom(items.getUom());
                item.setApprovedQuantity(items.getApprovedQuantity());
                item.setRate(items.getRate());
                item.setDiscount(items.getDiscount());
                item.setAmount(items.getAmount());
                return item;
            } else {
                OrderItems newItem = new OrderItems();
                newItem.setCategory(items.getCategory());
                newItem.setCode(items.getCode());
                newItem.setDescription(items.getDescription());
                newItem.setOrderQty(items.getOrderQty());
                newItem.setUom(items.getUom());
                newItem.setApprovedQuantity(items.getApprovedQuantity());
                newItem.setRate(items.getRate());
                newItem.setDiscount(items.getDiscount());
                newItem.setAmount(items.getAmount());
                return newItem;
            }
        }).collect(Collectors.toList());

        existingOrder.setItems(updatedOrderItems);
        existingOrder.setApprovedDateOnce(LocalDateTime.now());

        orderRepository.save(existingOrder);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }


    public List<ReportDto> getJoinInformation() {
        return orderRepository.getJoinInformation();
    }
}