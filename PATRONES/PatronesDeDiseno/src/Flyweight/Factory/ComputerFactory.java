package Flyweight.Factory;

import Flyweight.DTO.Computer;

import java.util.HashMap;
import java.util.Map;

public class ComputerFactory {

    final static Map<String, Computer> macLigeros = new HashMap<>();

    public Computer getComputer(int ram, int disco){
        String clave = "key: " + ram + ":" + disco;
        System.out.println(clave);
        if(!macLigeros.containsKey(clave)){
            macLigeros.put(clave, new Computer(ram,disco));
            System.out.println("Computadora creada");
            return macLigeros.get(clave);
        }
        System.out.println("Computadora obtenida");
        return macLigeros.get(clave);
    }
}
