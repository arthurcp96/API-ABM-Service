package com.ar.sportclubcafe.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ar.sportclubcafe.model.dto.MenuDto;
import com.ar.sportclubcafe.model.entity.Menu;
import com.ar.sportclubcafe.model.payload.MensajeResponse;
import com.ar.sportclubcafe.service.MenuService;

@RestController
@RequestMapping("/api/v1")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("menus")
    public ResponseEntity<?> showAll() {
        List<Menu> getList = menuService.listAlll();
        if (getList == null) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje("No hay registros")
                            .object(null)
                            .build()
                    , HttpStatus.OK);
        }

        return new ResponseEntity<>(
                MensajeResponse.builder()
                        .mensaje("")
                        .object(getList)
                        .build()
                , HttpStatus.OK);
    }


    @PostMapping("menu")
    public ResponseEntity<?> create (@RequestBody MenuDto menuDto){
        Menu menuSave = null;
        try {
            menuSave = menuService.save(menuDto);
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("Guardado correctamente")
                    .object(MenuDto.builder()
                            .idMenu(menuSave.getIdMenu())
                            .nombre(menuSave.getNombre() )
                            .precio(menuSave.getPrecio())
                            .fechaRegistro(menuSave.getFechaRegistro())
                            .build())
                    .build()
                    , HttpStatus.CREATED);
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje(exDt.getMessage())
                            .object(null)
                            .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @GetMapping("menu/{id}")
    public ResponseEntity<?> showById(@PathVariable Integer id)  {
        Menu menu = menuService.findById(id);
        if(menu == null){
            return new ResponseEntity<>(
                MensajeResponse.builder()
                         .mensaje("El Registro que intenta buscar, no existe!")
                         .object(null)
                         .build()
                    , HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<>(
            MensajeResponse.builder()
                     .mensaje("")
                     .object(MenuDto.builder()
                             .idMenu(menu.getIdMenu())
                             .nombre(menu.getNombre())
                             .precio(menu.getPrecio())
                             .fechaRegistro(menu.getFechaRegistro())
                             .build())
                      .build()
                    , HttpStatus.OK);       
        
        }
    

    @DeleteMapping("menu/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            Menu menuDelete = menuService.findById(id);
            menuService.delete(menuDelete);
            return new ResponseEntity<>(menuDelete, HttpStatus.NO_CONTENT);
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje(exDt.getMessage())
                            .object(null)
                            .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @PutMapping("menu/{id}")
    public ResponseEntity<?> update(@RequestBody MenuDto menuDto, @PathVariable Integer id) {
        Menu menuUpdate = null;
        try {
            if (menuService.existsById(id)) {
                menuDto.setIdMenu(id);
                menuUpdate = menuService.save(menuDto);
                return new ResponseEntity<>(MensajeResponse.builder()
                        .mensaje("Guardado correctamente")
                        .object(MenuDto.builder()
                                .idMenu(menuUpdate.getIdMenu())
                                .nombre(menuUpdate.getNombre())
                                .precio(menuUpdate.getPrecio())
                                .fechaRegistro(menuUpdate.getFechaRegistro())
                                .build())
                        .build()
                        , HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(
                        MensajeResponse.builder()
                                .mensaje("El registro que intenta actualizar no se encuentra en la base de datos.")
                                .object(null)
                                .build()
                        , HttpStatus.NOT_FOUND);
            }
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje(exDt.getMessage())
                            .object(null)
                            .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

}
