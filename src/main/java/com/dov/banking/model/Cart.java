package com.dov.banking.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy="cart")
    List<CartArticle> cartArticles;

    private String idUser;

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public List<CartArticle> getCartArticles() {
        return cartArticles;
    }

    public void setCartArticles(List<CartArticle> cartArticles) {
        this.cartArticles = cartArticles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
