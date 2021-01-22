package com.dov.banking.repository;

import com.dov.banking.model.Account;
import com.dov.banking.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleJpaRepository extends JpaRepository<Article, Integer> {
}

