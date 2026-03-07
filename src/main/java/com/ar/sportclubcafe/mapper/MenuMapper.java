package com.ar.sportclubcafe.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.ar.sportclubcafe.model.dto.MenuDto;
import com.ar.sportclubcafe.model.entity.Menu;
@Mapper(componentModel = "spring")
public interface MenuMapper {
    // Le decimos a MapStruct que el campo "imagenUrl" en MenuDto se mapea al campo "imagenUrl" en Menu
    
    @Mapping(target = "imagenUrl", source="imagenUrl")
    @Mapping(target = "fechaRegistro", ignore = true) // Ignoramos el campo fechaRegistro para que no se mapee automáticamente
    Menu toMenu(MenuDto menuDto, String imagenUrl);

    MenuDto toMenuDto(Menu menu);

    List <MenuDto> toMenuDto (List<Menu> menu);

    @Mapping(target = "imagenUrl", ignore= true) // Ignoramos el campo imagenUrl para que no se mapee automáticamente
    @Mapping(target = "fechaRegistro", ignore = true) // Ignoramos el campo fechaRegistro para que no se mapee automáticamente
    void updateMenu(@MappingTarget Menu menu, MenuDto menuDto);
    
}
