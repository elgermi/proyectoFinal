package com.example.venta.repository;

import com.example.venta.model.ProductosModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductosReposirory extends JpaRepository<ProductosModel, Long> {
}
