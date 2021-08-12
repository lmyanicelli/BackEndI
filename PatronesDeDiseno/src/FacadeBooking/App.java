package FacadeBooking;

import FacadeBooking.fachada.CheckFacade;

public class App {
    public static void main(String[] args){
        CheckFacade cliente1 = new CheckFacade();

        cliente1.buscar("09/08/21","12/08/21","Tuc","Miami");

        CheckFacade cliente2 = new CheckFacade();
        cliente2.buscar("09/08/21","12/08/21","Bogotá","México");


    }
}
