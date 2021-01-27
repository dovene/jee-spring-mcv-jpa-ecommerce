package com.dov.banking.repository;

import com.dov.banking.model.Account;
import com.dov.banking.model.Cart;
import com.dov.banking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartJpaRepository extends JpaRepository<Cart, Integer> {

    @Query("select c from Cart c where c.idUser = (:idUser)")
    Cart findByIdUser(@Param("idUser")String  idUser);

    @Query("SELECT c from Cart c JOIN FETCH c.cartArticles WHERE c.id = (:id)")
    Cart cartWithArticles(@Param("id") Integer id);
}

