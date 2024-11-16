package com.tarea4.dgmt04e02.Servicios;

import java.util.ArrayList;

public interface CalculosService {
    String err = null;
    String respuesta = null;
    ArrayList<Integer> divisores = new ArrayList<>();
    int size = 0;

    // Metodos
    boolean esPrimo(int n);

    double calchipotenusa(int val1, int val2);

    ArrayList<Integer> calcdivisores(int val);

    // Getters & setters
    int getSize();

    void setSize(int val);

    String geterr();

    void seterr(String error);

    String getresp();

    void setresp(String resp);

    ArrayList<Integer> getDivisores();

    void clearDivisores();
}
