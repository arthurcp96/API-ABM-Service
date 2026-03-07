package com.ar.sportclubcafe.service.impl;

import java.util.Date;
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
import org.springframework.web.multipart.MultipartFile;

import org.springframework.transaction.annotation.Transactional;

import com.ar.sportclubcafe.service.CloudinaryService;

@Service
public class MenuImplService implements MenuService {
    private final MenuRepository menuRepository;
    private final MenuMapper menuMapper;
    private final CloudinaryService cloudinaryService;

    public MenuImplService(MenuRepository menuRepository,
                           MenuMapper menuMapper,
                           CloudinaryService cloudinaryService) {
        this.menuRepository = menuRepository;
        this.menuMapper = menuMapper;
        this.cloudinaryService = cloudinaryService;
    }

    @Override
    @Transactional(readOnly = true)
    public List<MenuDto> findAll() {
        if (menuRepository.findAll() == null || menuRepository.findAll().isEmpty()) {
            throw new UnmodifiableSetException("No hay registros en el sistema");
        } else {
            return menuMapper.toMenuDto(menuRepository.findAll());
        }
    }

    @Override
    @Transactional
    public MenuDto save(MenuDto menuDto, MultipartFile imagen) throws Exception {

        // 1. Validamos y subimos la imagen (para el alta suele ser obligatoria)
        if (imagen == null || imagen.isEmpty()) {
            throw new IllegalArgumentException("La imagen es obligatoria para crear un menú");
        }
        String urlImagen = cloudinaryService.uploadImage(imagen);

        Menu menu = menuMapper.toMenu(menuDto, urlImagen);
        menu.setFechaRegistro(new Date());

        if (menuRepository.existsById(menuDto.getIdMenu())) {
            throw new UnsupportedOperationException("Id existente");
        }

        return menuMapper.toMenuDto(menuRepository.save(menu));

    }

    @Override
    @Transactional(readOnly = true)
    public MenuDto findById(Integer id) {
        Menu menu = menuRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Menu", "id", id));
        return menuMapper.toMenuDto(menu);
    }

    @Override
    @Transactional
    public MenuDto delete(Integer id) {

        Menu menu = menuRepository.findById(id).orElseThrow(() -> new BadRequestException("Not found"));
        MenuDto menuDto = menuMapper.toMenuDto(menu);
        menuRepository.deleteById(id);
        return menuDto;

    }

    @Override
    @Transactional
    public MenuDto update(Integer id, MenuDto menuDto, MultipartFile imagen) throws Exception {
        Menu menu = menuRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Menu not found!"));
        menuDto.setIdMenu(id);
        menuMapper.updateMenu(menu, menuDto);

        // 2. Lógica condicional para la imagen:
        // Si el administrador envió una nueva imagen, la subimos y reemplazamos la URL

        if (imagen!= null && !imagen.isEmpty()) {
            String nuevaUrl = cloudinaryService.uploadImage(imagen);
            menu.setImagenUrl(nuevaUrl);
        }

        return menuMapper.toMenuDto(menuRepository.save(menu));
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsById(Integer id) {

        throw new UnsupportedOperationException("Unimplemented method 'existsById'");
    }

}
