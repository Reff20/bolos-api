package br.com.belluzzibolos.lojabolosback.service;

import br.com.belluzzibolos.lojabolosback.dto.request.RequestOrderRegister;
import br.com.belluzzibolos.lojabolosback.dto.response.ResponseError;
import br.com.belluzzibolos.lojabolosback.dto.response.ResponseSuccess;
import br.com.belluzzibolos.lojabolosback.dto.status.OrderStatus;
import br.com.belluzzibolos.lojabolosback.model.OrderModel;
import br.com.belluzzibolos.lojabolosback.repository.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public ResponseEntity<Object> insertOrders(RequestOrderRegister newOrder){
        ResponseSuccess success = new ResponseSuccess();
        ResponseError error = new ResponseError();
        try{
            if(!(newOrder.getCustomer().isEmpty() || newOrder.getItems().isEmpty() || newOrder.getCost() == 0f)){
                OrderModel order = new OrderModel();
                Date date = new Date();
                order.setOrderCost(newOrder.getCost());
                order.setOrderCustomer(newOrder.getCustomer());
                order.setOrderDate(date);
                order.setOrderItems(newOrder.getItems().toString());
                order.setOrderStatus(OrderStatus.PENDENTE.name());
                orderRepository.save(order);

                success.setStatus(201);
                success.setMsg("PEDIDO CRIADO COM SUCESSO!");
                success.setRenew(true);

                return new ResponseEntity<>(success, HttpStatus.OK);
            }else{
                error.setMsg("Faild Process...");
                error.setStatus(400);
                return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception ex){
            System.out.println(ex);
        }
        return null;
    }
}
