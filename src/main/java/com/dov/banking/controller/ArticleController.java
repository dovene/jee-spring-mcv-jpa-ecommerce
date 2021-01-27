package com.dov.banking.controller;

import com.dov.banking.model.Article;
import com.dov.banking.repository.ArticleJpaRepository;
import com.dov.banking.repository.ArticleJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    ArticleJpaRepository articleJpaRepository;

    @GetMapping
    public String list(HttpSession session, Model model) {
        if (session.getAttribute("user") == null) {
            return "redirect:/accessDenied";
        }

        model.addAttribute("articles", articleJpaRepository.findAll());
        return "articles/articles";
    }

    // Add a new article
    @GetMapping("/create")
    public String add(Model model) {
        model.addAttribute("article", new Article());
        return "articles/addArticle";
    }

    @PostMapping("/create")
    public String addSave(@ModelAttribute Article article) {
        articleJpaRepository.save(article);
        return "redirect:/articles";
    }

    // Edit an article
    @GetMapping
    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("article", articleJpaRepository.findOne(id));
        return "articles/editArticle";
    }

    @PostMapping("edit/{id}")
    public String editSave(@ModelAttribute Article article) {
        articleJpaRepository.save(article);
        return "redirect:/articles";
    }

    // Delete an  article
    @GetMapping
    @RequestMapping("/delete")
    public String delete(Model model, @RequestParam("id") Integer id) {
        articleJpaRepository.delete(id);
        return "redirect:/articles";
    }

}