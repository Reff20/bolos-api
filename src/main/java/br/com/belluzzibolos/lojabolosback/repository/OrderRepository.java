package br.com.belluzzibolos.lojabolosback.repository;

import br.com.belluzzibolos.lojabolosback.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderModel, Integer> {

}
