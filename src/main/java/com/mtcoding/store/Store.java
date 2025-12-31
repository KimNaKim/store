package com.mtcoding.store;

public class Store {
    private Integer id;
    private String name;
    private Integer price;
    private Integer qty;

    public Store(Integer id, String name, Integer price, Integer qty){
        this.id = id;
        this.name = name;
        this.price = price;
        this.qty = qty;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return id + ", " + name + ", " + price + ", " + qty;
    }
}
