package com.padma.cartsample.service;

import com.padma.cartsample.dto.Cartitem;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface CartService {

    public List<Cartitem> findAll();

    public Cartitem findById(Long id);

    public Cartitem add(Cartitem cartitem);

    public Cartitem update(Cartitem cartitem);

    public void remove(Cartitem cartitem);

}
