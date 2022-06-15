package com.maktab74.bank.repositori.Imple;

import com.maktab74.bank.base.reposity.imple.BaseReposityImple;
import com.maktab74.bank.domain.Cart;
import com.maktab74.bank.repositori.CartRepository;
import com.maktab74.bank.util.CartBrief;

import javax.persistence.EntityManager;


public class CartRepositoryImple extends BaseReposityImple<Cart, Long>
        implements CartRepository {


    public CartRepositoryImple(EntityManager entityManager) {
        super(entityManager);
    }


    @Override
    public Class<Cart> getEntityClass() {
        return Cart.class;
    }


    public Cart findByAccuntId(Long acountId) {
        return entityManager.createQuery("select c from Cart c where Account.id=:example",
                Cart.class).setParameter("example", acountId).getSingleResult();
    }

    @Override
    public Cart chekCart(CartBrief cartBrief) {

        return entityManager.createQuery("select c from Cart c where c.numberCart= :numberCart  " +
                        "and c.ccv2=:ccv and c.password=:pass", Cart.class)
                .setParameter("numberCart", cartBrief.getNumberCart())
                .setParameter("ccv", cartBrief.getCcv2()).setParameter("pass", cartBrief.getPassword())
                .getSingleResult()
                ;
    }

    @Override
    public Cart destination(String cart) {
        return entityManager.createQuery("select c from Cart c where c.numberCart=:numberCart"
                        , Cart.class)
                .setParameter("numberCart", cart)
                .getSingleResult();
    }
}
