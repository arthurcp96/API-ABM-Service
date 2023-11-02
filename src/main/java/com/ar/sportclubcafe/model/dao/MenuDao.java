package com.ar.sportclubcafe.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ar.sportclubcafe.model.entity.Menu;
@Repository
public interface MenuDao extends CrudRepository<Menu,Integer>{
    
}
