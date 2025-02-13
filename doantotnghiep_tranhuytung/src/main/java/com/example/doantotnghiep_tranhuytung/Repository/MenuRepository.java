package com.example.doantotnghiep_tranhuytung.Repository;

import com.example.doantotnghiep_tranhuytung.Entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<MenuEntity , Long> {
}
