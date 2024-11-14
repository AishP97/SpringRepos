package com.example.SpringDas;

public class grocery {
	
	private String vegetableName;
	private int vegetableQuantity;
	private int vegetablePrice;
	
	
	public grocery() {
		super();
		// TODO Auto-generated constructor stub
	}
	public grocery(String vegetableName, int vegetableQuantity, int vegetablePrice) {
		super();
		this.vegetableName = vegetableName;
		this.vegetableQuantity = vegetableQuantity;
		this.vegetablePrice = vegetablePrice;
	}
	public String getVegetableName() {
		return vegetableName;
	}
	public void setVegetableName(String vegetableName) {
		this.vegetableName = vegetableName;
	}
	public int getVegetableQuantity() {
		return vegetableQuantity;
	}
	public void setVegetableQuantity(int vegetableQuantity) {
		this.vegetableQuantity = vegetableQuantity;
	}
	public int getVegetablePrice() {
		return vegetablePrice;
	}
	public void setVegetablePrice(int vegetablePrice) {
		this.vegetablePrice = vegetablePrice;
	}
	
	
	

}
