package com.tarea3.dgmt04e03;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import org.springframework.stereotype.Service;


@Service
public class Servicios {
    Random random = new Random();
    private Set<Integer> lista  = new LinkedHashSet<>();

	public Set<Integer> getLista() {
		return this.lista;
	}

    public void agregar(){
        boolean añadido;
        do{
            añadido = lista.add(random.nextInt(100)+1);
        }while(!añadido);
    }

    public void remover(int id){
        lista.remove(id);
    }
}
