package com.example.venta.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.Date;

@Data
@Entity
@Table(name="factura")
public class FacturaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name="clientes_id")
    private ClienteModel cliente;
    @Column(name="fecha_creacion")
    private Date fechaCreacion;
    private double total;
}
