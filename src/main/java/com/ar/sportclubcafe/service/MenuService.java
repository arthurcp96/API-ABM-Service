package com.ar.sportclubcafe.service;


import java.util.List;


import com.ar.sportclubcafe.model.dao.MenuDao;
import com.ar.sportclubcafe.model.dto.MenuDto;
import com.ar.sportclubcafe.model.entity.Menu;


public interface MenuService {
    
    List<Menu> listAlll();

    Menu save(MenuDto menu);

    Menu findById(Integer id);

    void delete(Menu menu);

    boolean existsById(Integer id);
    
    // public ArrayList<Menu> obtenerMenu(){
    //     return (ArrayList<Menu>) menuDao.findAll();
    // }

    // public Menu guardarMenu(Menu menu){
    //     return menuDao.save(menu);
    // }

    // public Optional <Menu> obtenerPorId(Integer id){
    //     return menuDao.findById(id);
    // }

    // public boolean eliminarMenu(Integer id) {
    //     try {
    //         menuDao.deleteById(id);
    //         return true;
    //     } catch (Exception e) {
    //         return false;
    //     }

    // }

    // public Menu modificarMenu(Menu menu){
    //     return menuDao.save(menu);
    // }
}
