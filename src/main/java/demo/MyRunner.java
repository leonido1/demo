package demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import demo.javaPressistance.Item;
import demo.javaPressistance.ItemRepository;

import javax.transaction.Transactional;

@Component
public class MyRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

    @Autowired
    private ItemRepository userRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        logger.info("initializing users");
        
        
        var i1 = new Item((long) 1,"Knife", (long) 14, "100");
        userRepository.save(i1);

        var i2 = new Item((long) 2,"Plate",(long) 7, "101");
        userRepository.save(i2);

        var i3 = new Item((long) 3,"Spone",(long) 14, "102");
        userRepository.save(i3);
    
        var i4 = new Item((long) 4,"Fork", (long)14,"103");
        userRepository.save(i4);
    	
    
    }
}