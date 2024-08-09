package com.ar.sportclubcafe.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.ar.sportclubcafe.model.dto.MenuDto;
import com.ar.sportclubcafe.model.entity.Menu;
@Mapper(componentModel = "spring")
public interface MenuMapper {

    Menu toMenu(MenuDto menuDto);
    MenuDto toMenuDto(Menu menu);
    List <MenuDto> toMenuDto (List<Menu> menu);
    void updateMenu(@MappingTarget Menu menu, MenuDto menuDto);
    
}
