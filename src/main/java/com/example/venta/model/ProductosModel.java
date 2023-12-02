package com.example.venta.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="productos")
public class ProductosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descripcion;
    private String codigo;
    private int stock;
    private double precio;
}
