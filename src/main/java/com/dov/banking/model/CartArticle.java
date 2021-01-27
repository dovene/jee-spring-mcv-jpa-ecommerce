package com.dov.banking.model;

import javax.persistence.*;

@Entity
@Table(name = "Article_Cart")
public class CartArticle {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private int quantity;

    @ManyToOne
    @JoinColumn(name="idCart")
    private Cart cart;

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

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
