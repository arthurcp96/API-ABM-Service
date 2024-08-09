package com.ar.sportclubcafe.service;


import java.util.List;



import com.ar.sportclubcafe.model.dto.MenuDto;



public interface MenuService {
    
    List<MenuDto> findAll();

    MenuDto save(MenuDto menuDto);

    MenuDto findById(Integer id);

    MenuDto delete(Integer id);

    MenuDto update(Integer id, MenuDto menuDto);
    
    boolean existsById(Integer id);
}
