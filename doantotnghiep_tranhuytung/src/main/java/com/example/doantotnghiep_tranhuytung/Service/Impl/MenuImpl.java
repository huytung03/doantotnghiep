package com.example.doantotnghiep_tranhuytung.Service.Impl;

import com.example.doantotnghiep_tranhuytung.Entity.MenuEntity;
import com.example.doantotnghiep_tranhuytung.Repository.MenuRepository;
import com.example.doantotnghiep_tranhuytung.Service.MenuService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
public class MenuImpl implements MenuService{
    private final MenuRepository menuRepository;

    public MenuImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public List<MenuEntity> getAllMenu(Pageable pageable) {
       try {
           List<MenuEntity> list = menuRepository.findAll(pageable).getContent();
           return list;
       }catch (Exception e){
           throw new RuntimeException(e.getMessage());
       }
    }

    @Override
    public MenuEntity getMenuById(Long id) {
   try {
       MenuEntity menuEntity = menuRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy thực đơn phù hợp"));
       return menuEntity;

   }catch (Exception e){
       throw new RuntimeException(e.getMessage());
   }
    }

    @Override
    public boolean createMenu(MenuEntity menu) {
        try {
            menu.setCreatedAt(Timestamp.from(Instant.now()));
            menuRepository.save(menu);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean updateMenu(MenuEntity menu) {
        try {
            MenuEntity entity = menuRepository.findById(menu.getId()).orElse(null);
            entity.setName(menu.getName());
            entity.setDescription(menu.getDescription());
            entity.setCategory(menu.getCategory());
            entity.getImage()
            menuRepository.save(entity);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteMenu(Long id) {
        return false;
    }
}
