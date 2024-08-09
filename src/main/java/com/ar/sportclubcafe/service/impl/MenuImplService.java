package com.ar.sportclubcafe.service.impl;

import java.util.List;

import javax.print.attribute.UnmodifiableSetException;


import org.springframework.stereotype.Service;

import com.ar.sportclubcafe.exception.BadRequestException;
import com.ar.sportclubcafe.exception.ResourceNotFoundException;
import com.ar.sportclubcafe.mapper.MenuMapper;
import com.ar.sportclubcafe.model.dto.MenuDto;
import com.ar.sportclubcafe.model.entity.Menu;
import com.ar.sportclubcafe.repository.MenuRepository;
import com.ar.sportclubcafe.service.MenuService;

@Service
public class MenuImplService implements MenuService {
    private final MenuRepository menuRepository;
    private final MenuMapper menuMapper;

    public MenuImplService(MenuRepository menuRepository, MenuMapper menuMapper) {
        this.menuRepository = menuRepository;
        this.menuMapper = menuMapper;
    }

    @Override
    public List<MenuDto> findAll() {
        if (menuRepository.findAll() == null || menuRepository.findAll().isEmpty()) {
            throw new UnmodifiableSetException("No hay registros en el sistema");
        } else {
            return menuMapper.toMenuDto(menuRepository.findAll());
        }
    }

    @Override
    public MenuDto save(MenuDto menuDto) {

        Menu menu = menuMapper.toMenu(menuDto);

        if (menuRepository.existsById(menuDto.getIdMenu())) {
            throw new UnsupportedOperationException("Id existente");
        }

        return menuMapper.toMenuDto(menuRepository.save(menu));

    }

    @Override
    public MenuDto findById(Integer id) {
        Menu menu = menuRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Menu", "id", id));
        return menuMapper.toMenuDto(menu);
    }

    @Override
    public MenuDto delete(Integer id) {

        Menu menu = menuRepository.findById(id).orElseThrow(() -> new BadRequestException("Not found"));
        MenuDto menuDto = menuMapper.toMenuDto(menu);
        menuRepository.deleteById(id);
        return menuDto;

    }

    @Override
    public MenuDto update(Integer id, MenuDto menuDto) {
        Menu menu = menuRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Menu not found!"));
        menuDto.setIdMenu(id);
        menuMapper.updateMenu(menu, menuDto);

        return menuMapper.toMenuDto(menuRepository.save(menu));
    }

    @Override
    public boolean existsById(Integer id) {

        throw new UnsupportedOperationException("Unimplemented method 'existsById'");
    }

}
