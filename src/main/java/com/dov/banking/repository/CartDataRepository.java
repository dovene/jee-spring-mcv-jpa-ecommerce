package com.dov.banking.repository;

import com.dov.banking.model.CartArticle;
import com.dov.banking.model.CartData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CartDataRepository {
    @Autowired ArticleJpaRepository articleJpaRepository;
    public List<CartData> getCart(List<CartArticle> cartArticles){
        List<CartData> cartDatas = new ArrayList<CartData>();
        for (CartArticle cartArticle : cartArticles){
            CartData cartData = new CartData();
            cartData.setDesignationArticle(articleJpaRepository.findOne(cartArticle.getArticle().getId()).getDesignation());
            cartData.setIdArticle(cartArticle.getArticle().getId());
            cartData.setIdCart(cartArticle.getId());
            cartData.setUserId(cartArticle.getCart().getIdUser());
            cartData.setQuantity(cartArticle.getQuantity());
            cartDatas.add(cartData);
        }

        return cartDatas;
    }
}
