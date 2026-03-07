package com.ar.sportclubcafe.service;


import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ar.sportclubcafe.model.dto.MenuDto;



public interface MenuService {
    
    List<MenuDto> findAll();

    MenuDto save(MenuDto menuDto, MultipartFile imagen) throws Exception;

    MenuDto findById(Integer id);

    MenuDto delete(Integer id);

    MenuDto update(Integer id, MenuDto menuDto, MultipartFile imagen) throws Exception;
    
    boolean existsById(Integer id);
}
