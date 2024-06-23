package org.example.controllers;

import lombok.RequiredArgsConstructor;
import org.example.entities.OrderEntity;
import org.example.services.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public String saveOrder(
            @RequestParam(name = "personId") UUID personId,
            @RequestParam(name = "productId") List<UUID> productIds
    ) {
        orderService.createOrder(personId, productIds);
        return "";
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable(name = "id") String uuid) {
        orderService.delete(UUID.fromString(uuid));
        return "";
    }

    @GetMapping("/{id}")
    public String getOrder(@PathVariable(name = "id") String uuid) {
        OrderEntity order = orderService.findById(UUID.fromString(uuid));
        System.out.println(order);
        return "";
    }
}
