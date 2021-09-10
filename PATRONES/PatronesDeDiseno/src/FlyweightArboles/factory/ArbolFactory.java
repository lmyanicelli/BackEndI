package FlyweightArboles.factory;

import FlyweightArboles.dto.Arbol;

import java.util.HashMap;

public class ArbolFactory {

    //Constantes
    public static final String TIPO_FRUTAL = "Frutal";
    public static final String ROJO = "rojo";
    public static final String ORNAMENTAL = "Ornamental";
    public static final String VERDE = "verde";
    public static final String CELESTE = "celeste";

    //Map
    final static HashMap<String, Arbol> listadoArboles = new HashMap();


    public Arbol getArbol (String color){
        String clave = color;
        Arbol arbol;
        if(!listadoArboles.containsKey(clave)){
            //creamos el arbol
            switch (clave){
                case ROJO:
                    arbol = new Arbol(500.0,300.0,clave,TIPO_FRUTAL);
                    break;
                case VERDE:
                    arbol = new Arbol(200.0,400.0,clave, ORNAMENTAL);
                    break;
                case CELESTE:
                    arbol = new Arbol(100.0,200.0,clave,TIPO_FRUTAL);
                    break;
                default:
                    //System.out.println("Código inválido");
                    arbol = new Arbol(500.0,300.0,clave,TIPO_FRUTAL);
            }
            listadoArboles.put(clave, arbol);
            System.out.println("Árbol creado");
            return listadoArboles.get(clave);
        }
        //Ya existe el árbol solicitado
        System.out.println("Árbol obtenido");
        return listadoArboles.get(clave);
    }


}
