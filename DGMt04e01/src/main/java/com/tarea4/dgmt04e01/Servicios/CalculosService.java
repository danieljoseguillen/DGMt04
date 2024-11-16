package com.tarea4.dgmt04e01.Servicios;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class CalculosService {
    private String err = null;
    private String respuesta = null;
    private ArrayList<Integer> divisores = new ArrayList<>();
    private int size = 0;

    public boolean esPrimo(int n) {
        if (n <= 0) {
            throw new RuntimeException("Deben ingresarse valores positivos para la operación de numeros primos.");
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public double calchipotenusa(int val1, int val2) {
        if (val1 <= 0 || val2 <= 0) {
            throw new RuntimeException("Deben ingresarse valores positivos para la operación de hipotenusa.");
        }
        return Math.hypot(val1, val2);
    }

    public ArrayList<Integer> calcdivisores(int val) {
        if (val <= 0) {
            throw new RuntimeException("Deben ingresarse valores positivos para la operación de divisores.");
        }
        for (int i = 1; i <= val; i++) {
            if (val % i == 0) {
                divisores.add(i);
                System.out.println(i);
            }
        }
        size = divisores.size();
        return divisores;
    }

    // Getters & setters
    public int getSize() {
        return this.size;
    }

    public void setSize(int val) {
        size = val;
    }

    public String geterr() {
        return err;
    }

    public void seterr(String error) {
        err = error;
    }

    public String getresp() {
        return respuesta;
    }

    public void setresp(String resp) {
        respuesta = resp;
    }

    public ArrayList<Integer> getDivisores() {
        return this.divisores;
    }

    public void clearDivisores() {
        divisores.clear();
    }
}
