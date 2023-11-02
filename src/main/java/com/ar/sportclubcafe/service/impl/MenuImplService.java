package com.ar.sportclubcafe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ar.sportclubcafe.model.dao.MenuDao;
import com.ar.sportclubcafe.model.dto.MenuDto;
import com.ar.sportclubcafe.model.entity.Menu;
import com.ar.sportclubcafe.service.MenuService;

import jakarta.transaction.Transactional;

@Service
public class MenuImplService implements MenuService {
    @Autowired
    private MenuDao menuDao;
    
    @Override
    public List<Menu> listAlll(){
        return (List) menuDao.findAll();
    }

    @Transactional
    @Override
    public Menu save(MenuDto menuDto) {
        Menu menu = Menu.builder()
                .idMenu(menuDto.getIdMenu())
                .nombre(menuDto.getNombre())
                .precio(menuDto.getPrecio())
                .fechaRegistro(menuDto.getFechaRegistro())
                .build();
        return menuDao.save(menu);
    }

    @Transactional()
    @Override
    public Menu findById(Integer id) {
        return menuDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Menu menu) {
        menuDao.delete(menu);
    }

    @Override
    public boolean existsById(Integer id) {
        return menuDao.existsById(id);
    }
}
