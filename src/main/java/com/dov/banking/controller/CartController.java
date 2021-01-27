package com.dov.banking.controller;

import com.dov.banking.model.*;
import com.dov.banking.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartArticleJpaRepository cartArticleJpaRepository;
    @Autowired
    CartJpaRepository cartJpaRepository;
    @Autowired
    ArticleJpaRepository articleJpaRepository;

    @Autowired
    CartDataRepository cartDataRepository;

    private User user;
    private Article article;

    @GetMapping
    public String list(HttpSession session, Model model) {
        if (session.getAttribute("user") == null) {
            return "redirect:/accessDenied";
        }
        user = (User) session.getAttribute("user");
        Cart cart = cartJpaRepository.findByIdUser(user.getLogin());
        List<CartArticle> cartArticles = new ArrayList<>();
        if (cart!=null && cartJpaRepository.cartWithArticles(cart.getId())!=null){
            cartArticles = cartJpaRepository.cartWithArticles(cart.getId()).getCartArticles();
        }

        model.addAttribute("cart", cartDataRepository.getCart(cartArticles));
        return "cart/cart";
    }

    // Add a new account
    @GetMapping("/create/{id}")
    public String add(Model model, @PathVariable("id") int id, HttpSession session) {
        user = (User) session.getAttribute("user");

        CartArticle cartArticle = new CartArticle();

        cartArticle.setArticle(articleJpaRepository.findOne(id));
        System.out.println(articleJpaRepository.findOne(id).getDesignation());
        model.addAttribute("cartArticle", cartArticle);
        return "cart/addCart";
    }

    @PostMapping("/create/{id}")
    public String addSave(@ModelAttribute CartArticle cartArticle, @PathVariable("id") int id) {

        cartArticle.setArticle(articleJpaRepository.findOne(id));
        Cart cart = cartJpaRepository.findByIdUser(user.getLogin());
        if (cart != null) {
            cartArticle.setCart(cart);
        } else {
            Cart cart1 = new Cart();
            cart1.setIdUser(user.getLogin());
            cartJpaRepository.save(cart1);
            cartArticle.setCart(cart1);
        }
        cartArticleJpaRepository.save(cartArticle);
        return "redirect:/cart";
    }


    // Delete a  account
    @GetMapping
    @RequestMapping("/delete")
    public String delete(Model model, @RequestParam("id") Integer id) {
        cartArticleJpaRepository.delete(id);
        return "redirect:/cart";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
}