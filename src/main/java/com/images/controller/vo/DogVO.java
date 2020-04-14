package com.images.controller.vo;

public class DogVO {
	private String name;
	private int price;
	private String color;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "DogVO [name=" + name + ", price=" + price + ", color=" + color + "]";
	}

}
