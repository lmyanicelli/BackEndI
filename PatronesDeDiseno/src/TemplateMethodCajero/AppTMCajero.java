package TemplateMethodCajero;

public class AppTMCajero {
    public static void main (String[] args){

        CajeroAutomatico cajeroAutomatico = new CajeroAutomatico("cuenta1", 3000.0, 1);//acción 1 para depositar
        System.out.println("--------------------");
        cajeroAutomatico.procesar("cuenta1",1000.0,2);
        System.out.println("--------------------");

        Cajero cajero = new Cajero("cuenta2",5000.0,1);
        cajero.procesar("cuenta2", 3000.0, 2);

    }
}
