package br.com.belluzzibolos.lojabolosback.controller;

import br.com.belluzzibolos.lojabolosback.dto.request.RequestOrderRegister;
import br.com.belluzzibolos.lojabolosback.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createOrder(@RequestBody RequestOrderRegister requestOrderRegister){
        return orderService.insertOrders(requestOrderRegister);
    }
}
