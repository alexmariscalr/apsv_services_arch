package es.upm.dit.apsv.transportationorderserver.controller;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.upm.dit.apsv.transportationorderserver.repository.TransportationOrderRepository;
import es.upm.dit.apsv.transportationorderserver.model.TransportationOrder;

// Identify the class is a REST API implementation
@RestController
public class TransportationOrderController {
    private final TransportationOrderRepository repository;
    public static final Logger log = LoggerFactory.getLogger(TransportationOrderController.class);

    // Constructor
    public TransportationOrderController(TransportationOrderRepository repository) {
        this.repository = repository;
    }

    // Assing path to GET method to list all orders
    @GetMapping("/transportationorders")
    List<TransportationOrder> all() {
        return (List<TransportationOrder>) repository.findAll();
    }

    // Assign path to POST method to create a new order
    @PostMapping("/transportationorders")
    TransportationOrder newOrder(@RequestBody TransportationOrder newOrder) {
        return repository.save(newOrder);
    }

    // Assign path to GET method to get an order by truck
    @GetMapping("/transportationorders/{truck}")
    ResponseEntity<TransportationOrder> getByTruck(@PathVariable String truck) {
        Optional<TransportationOrder> ot = repository.findById(truck);
        if (ot.isPresent())
            return new ResponseEntity<>(ot.get(), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Assign path to PUT method to update an order
    @PutMapping("/transportationorders")
    ResponseEntity<TransportationOrder> update(@RequestBody TransportationOrder updatedOrder) {
        TransportationOrder to = repository.save(updatedOrder);
        if (to == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(to, HttpStatus.OK);
    }

    // Assign path to DELETE method to delete an order
    @DeleteMapping("/transportationorders/{truck}")
    void deleteOrder(@PathVariable String truck) {
        repository.deleteById(truck);
    }

}