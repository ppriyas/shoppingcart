package com.padma.cartsample.dao;

import com.padma.cartsample.dto.Cartitem;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CartitemRepository extends JpaRepository<Cartitem, Long> {


}
