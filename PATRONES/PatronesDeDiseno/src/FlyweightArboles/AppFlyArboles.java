package FlyweightArboles;

import FlyweightArboles.factory.ArbolFactory;

public class AppFlyArboles {

    public static void main(String[] args) {

        ArbolFactory arbolFactory = new ArbolFactory();
        arbolFactory.getArbol(ArbolFactory.CELESTE);

        //creamos 500000 árboles rojos
        for (int i = 0; i<=500000; i++){
            arbolFactory.getArbol(ArbolFactory.ROJO);
        }
        //creamos 500000 árboles verdes
        for (int i = 0; i<=500000; i++){
            arbolFactory.getArbol(ArbolFactory.VERDE);
        }

        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memoria usada: " + (runtime.totalMemory() -
                runtime.freeMemory()) / (1024 * 1024));

    }
}
