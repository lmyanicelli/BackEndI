package Flyweight.Fly;

import Flyweight.DTO.Computer;
import Flyweight.Factory.ComputerFactory;

public class AppFlyweight {

    public static void main(String[] args) {
        ComputerFactory computerFactory = new ComputerFactory();
        Computer mac1 = computerFactory.getComputer(16,500);
        Computer windows = computerFactory.getComputer(2,256);
        Computer mac2 = computerFactory.getComputer(8,500);
        Computer mac3 = computerFactory.getComputer(8,500);

        System.out.println(mac1);
        System.out.println(windows);
        System.out.println(mac2);
        System.out.println(mac3);
    }
}
