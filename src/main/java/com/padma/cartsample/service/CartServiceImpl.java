package com.padma.cartsample.service;

import com.padma.cartsample.dao.CartitemRepository;
import com.padma.cartsample.dto.Cartitem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service("CartService")
@Repository
public class CartServiceImpl implements CartService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CartServiceImpl.class);

    @Resource
    private CartitemRepository cartitemRepository;

    @Transactional(readOnly = true)
    public List<Cartitem> findAll()
    {
        return cartitemRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Cartitem findById(Long id)
    {
        return cartitemRepository.findOne(id);
    }

    @Transactional(readOnly = false, rollbackFor = DataAccessException.class)
    public Cartitem add(Cartitem cartitem)
    {
        LOGGER.debug("Creating a new item in shopping cart: " + cartitem);

        return cartitemRepository.save(cartitem);
    }

    @Transactional(readOnly = false, rollbackFor = DataAccessException.class)
    public Cartitem update(Cartitem cartitem)
    {
        LOGGER.debug("Updating item in shopping cart: " + cartitem);

        return cartitemRepository.save(cartitem);
    }

    @Transactional(readOnly = false, rollbackFor = DataAccessException.class)
    public void remove(Cartitem cartitem)
    {
        LOGGER.debug("Deleting item in shopping cart: " + cartitem);

        cartitemRepository.delete(cartitem);
    }

}

