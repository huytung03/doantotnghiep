package com.example.doantotnghiep_tranhuytung.Service;

import com.example.doantotnghiep_tranhuytung.Entity.MenuEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MenuService  {
    List<MenuEntity> getAllMenu(Pageable pageable);
    MenuEntity getMenuById(Long id);
    boolean createMenu(MenuEntity menu);
    boolean updateMenu(MenuEntity menu);
    boolean deleteMenu(Long id);

}
