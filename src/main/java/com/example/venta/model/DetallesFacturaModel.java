package com.example.venta.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="detalle_factura")
public class DetallesFacturaModel {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    private Long id;

    @ManyToOne
    @JoinColumn(name="factura")
    private FacturaModel factura;
    @Column(name="cantidad_profuctos")
    private int cantidadProductos;
    @ManyToOne
    @JoinColumn(name="productos_id")
    private ProductosModel producto;

    private double importe;
}
