package demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.javaPressistance.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    
  
    
    public List<Item> findAll() {

        var it = itemRepository.findAll();

        var items = new ArrayList<Item>();
        it.forEach(e -> items.add(e));

        return items;
    }

    public Long count() {

        return itemRepository.count();
    }

    public void deleteById(Long userId) {

        itemRepository.deleteById(userId);
    }

	public Optional<Item> getById(Long itemId) {
		
		Optional<Item> item =itemRepository.findById(itemId);
		
		return item;
	}

	@Transactional
	public void changeAmount(Long id, Long amount) {
		
		Optional<Item> opItem =itemRepository.findById(id);
		Item item = opItem.get();
		
		item.setAmount(item.getAmount()+ amount );
		
		itemRepository.save(item);
	}

	
	public void addItem(Long id, Long amount, String name, String code) {
		itemRepository.save(new Item(id,name,amount,code));
	}

	
}