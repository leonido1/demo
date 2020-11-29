package demo.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.javaPressistance.*;
import demo.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MyController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/items")
    public List<Item> allItems() {

        return itemService.findAll();
    }

    @GetMapping("/items/count")
    public Long count() {

        return itemService.count();
    }

    @GetMapping("/items/{id}")
    public Optional<Item> get(@PathVariable String id) {

        Long itemId = Long.parseLong(id);
        return itemService.getById(itemId);
    }
    
    
    @PutMapping("/add")
    public void add(@RequestParam(name = "id") Long Id,
    		@RequestParam(name = "amount") Long amount,
    		@RequestParam(name = "name") String name,
    		@RequestParam(name = "code") String Code) {
    	itemService.addItem(Id,amount,name,Code);
    	
    }
    
    
    @PutMapping("/deposit")
    public void deposit(@RequestParam(name = "id") Long Id, 
    		@RequestParam(name="amount") Long amount) {
    	itemService.changeAmount(Id,amount);
    }
    
    @PutMapping("/withdrawal")
    public void withdrawal(@RequestParam(name = "id") Long Id, 
    		@RequestParam(name="amount") Long amount) {
    	
    	itemService.changeAmount(Id,-amount);
    }
    
    @DeleteMapping("/items/{id}")
    public void delete(@PathVariable String id) {

        Long itemId = Long.parseLong(id);
        itemService.deleteById(itemId);
    }

    




}


