package com.tarea4.dgmt04e05;

import org.springframework.stereotype.Service;

@Service
public class MathService {
    public Double calcularHipotenusa(Double cat1, Double cat2) throws RuntimeException {
        if (cat1 < 0 || cat2 < 0){
            throw new RuntimeException("Error en parámetros: Hay catetos menores a cero.");
        }        if (cat1 > 1000 || cat2 > 1000){
            throw new RuntimeException("Error en parámetros: Hay catetos mayores a 1000");
        }
        return Math.hypot(cat1, cat2);
    }
}
