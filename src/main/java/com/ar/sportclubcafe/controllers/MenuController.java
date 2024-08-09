package com.ar.sportclubcafe.controllers;


import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ar.sportclubcafe.model.dto.MenuDto;


import com.ar.sportclubcafe.service.MenuService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }
    
    @GetMapping("/menu")
    public ResponseEntity<List<MenuDto>> get(){
        return new ResponseEntity<>(menuService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/menu")
    public ResponseEntity<MenuDto> save(@RequestBody @Valid MenuDto menuDto){
        return new ResponseEntity<>(menuService.save(menuDto),HttpStatus.CREATED);
    }

    @PutMapping("/menu/{id}")
    public ResponseEntity<MenuDto> update (@PathVariable Integer id, @RequestBody @Valid MenuDto menuDto){
        return new ResponseEntity<>(menuService.update(id, menuDto), HttpStatus.OK);
    }

    @DeleteMapping("/menu/{id}")
    public ResponseEntity<MenuDto> delete(@PathVariable Integer id){
        return new ResponseEntity<>(menuService.delete(id), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/menu/{id}")
    public ResponseEntity<?> getMenu(@PathVariable Integer id){
        MenuDto menuDto = menuService.findById(id);
        return ResponseEntity.ok(menuDto);
    }


    
    /*private MenuService menuService;

    @GetMapping("menu")
    public ResponseEntity<?> showAll() {
        List<Menu> getList = menuService.listAlll();
        if (getList == null || getList.isEmpty()) {
            throw new ResourceNotFoundException("clientes");
        }

        return new ResponseEntity<>(
                MensajeResponse.builder()
                        .mensaje("")
                        .object(getList)
                        .build()
                , HttpStatus.OK);
    }


    @PostMapping("menu")
    public ResponseEntity<?> create (@RequestBody @Valid MenuDto menuDto){
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
            throw new BadRequestException(exDt.getMessage());
        }
    }

    @GetMapping("menu/{id}")
    public ResponseEntity<?> showById(@PathVariable Integer id)  {
        Menu menu = menuService.findById(id);
        if(menu == null){
            
            throw new ResourceNotFoundException("cliente", "id", id);
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
            throw new BadRequestException(exDt.getMessage());
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
                throw new ResourceNotFoundException("menu","id",id);
            }
        } catch (DataAccessException exDt) {
            throw new BadRequestException(exDt.getMessage());
        }
    }*/

}
