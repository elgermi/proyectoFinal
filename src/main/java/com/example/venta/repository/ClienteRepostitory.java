package com.example.venta.repository;

import com.example.venta.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepostitory extends JpaRepository<ClienteModel,Long>{

}
