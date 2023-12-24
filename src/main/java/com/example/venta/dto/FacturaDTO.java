package com.example.venta.dto;

import com.example.venta.model.ClienteModel;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Data
public class FacturaDTO {
    private Long id;
    private ClienteModel cliente;
    private LocalDate fechaCreacion;
    private double total;

    private Set<DetalleFacturaDTO> lineas;

    public Set<DetalleFacturaDTO> getLineas() {
        return lineas;
    }

    public void setLineas(Set<DetalleFacturaDTO> lineas) {
        this.lineas = lineas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}

