package com.trabajo.apicrud.entitis;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
public class Bicycle {
    @Id
    private Long id;
    private String marcaCuadro;
    private String marcaGrupo;
    private String marcaRines;
    private double peso;
    private double precio;
}
