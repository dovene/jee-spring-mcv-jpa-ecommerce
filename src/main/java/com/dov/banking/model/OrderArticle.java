package com.dov.banking.model;

import javax.persistence.*;

@Entity
@Table(name = "Article_Order")
public class OrderArticle {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private int quantity;
    private double price;

    @ManyToOne
    @JoinColumn(name="idOrder")
    private Order order;

    @ManyToOne
    @JoinColumn(name="idArticle")
    private Article article;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
