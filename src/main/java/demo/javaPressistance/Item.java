package demo.javaPressistance;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {

	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemNo;
    private String name;
    private Long amount;
    private String inventoryCode;

    public Item() {}


    public Item(Long itemNo, String name, Long amount, String inventoryCode ) {
    	
    	this.amount = amount;
    	this.name = name;
    	this.inventoryCode = inventoryCode;
    	this.itemNo = itemNo;
    	
    }

    
    
    public Long getId() {
        return itemNo;
    }

    public void setId(Long itemNo) {
        this.itemNo = itemNo;
    }


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Long getAmount() {
		return amount;
	}


	public void setAmount(Long amount) {
		this.amount = amount;
	}


	public String getInventoryCode() {
		return inventoryCode;
	}


	public void setInventoryCode(String inventoryCode) {
		this.inventoryCode = inventoryCode;
	}



}
