package com.maktab74.bank.domain;

import com.maktab74.bank.base.domain.BaseEntity;

import javax.persistence.*;

@Entity

public class Cart extends BaseEntity<Long> {


    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private Long numberCart;

    private Long ccv2;

    private Long password;

    @OneToOne
    private Account account;

    public Cart(Long numberCart, Long ccv2, Long password, Account account) {
        this.numberCart = numberCart;
        this.ccv2 = ccv2;
        this.password = password;
        this.account = account;
    }

    public Cart(Long id, Long password, Account account) {
        this.id = id;
        this.password = password;
        this.account = account;
    }

    public Cart() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumberCart() {
        return numberCart;
    }

    public void setNumberCart(Long numberCart) {
        this.numberCart = numberCart;
    }

    public Long getCcv2() {
        return ccv2;
    }

    public void setCcv2(Long ccv2) {
        this.ccv2 = ccv2;
    }

    public Long getPassword() {
        return password;
    }

    public void setPassword(Long password) {
        this.password = password;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", numberCart='" + numberCart + '\'' +
                ", ccv2=" + ccv2 +
                ", password=" + password +
                ", account=" + account +
                "} " + super.toString();
    }
}
