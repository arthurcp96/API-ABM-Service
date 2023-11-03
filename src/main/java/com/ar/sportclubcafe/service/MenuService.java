package com.ar.sportclubcafe.service;


import java.util.List;



import com.ar.sportclubcafe.model.dto.MenuDto;
import com.ar.sportclubcafe.model.entity.Menu;


public interface MenuService {
    
    List<Menu> listAlll();

    Menu save(MenuDto menu);

    Menu findById(Integer id);

    void delete(Menu menu);

    boolean existsById(Integer id);
    
    
}
