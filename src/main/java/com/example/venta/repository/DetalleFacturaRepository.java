package com.example.venta.repository;

import com.example.venta.model.DetallesFacturaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleFacturaRepository extends JpaRepository<DetallesFacturaModel,Long> {
}
