import Drivers.Driver_C;
import Drivers.Driver_B;
import Drivers.Driver_D;
import Drivers.Drivers;
import Mechanics.Mechanics;
import cars.Buses;
import cars.Cargo_cars;
import cars.Passenger_cars;
import cars.Transports;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Passenger_cars audi = new Passenger_cars("AUDI", "RS6", 3.0, Passenger_cars.TypeOfBody.SEDAN);
        Passenger_cars BMW = new Passenger_cars("BMW", "M5", 3.2, Passenger_cars.TypeOfBody.WAGON);
        Passenger_cars Porsche = new Passenger_cars("Porsche", "911", 3.5, Passenger_cars.TypeOfBody.COUPE);
        Passenger_cars FORD = new Passenger_cars("FORD", "Mustang", 4.0, Passenger_cars.TypeOfBody.SUV);
        Passenger_cars ssFORD = new Passenger_cars("FORD", "Mustang", 4.0, Passenger_cars.TypeOfBody.PICKUP);
        System.out.println(audi);
        System.out.println(BMW);
        audi.printType();
        BMW.printType();

        Cargo_cars mercedes = new Cargo_cars("Mercedes", "Actros", 13.5, Cargo_cars.LoadCapacity.N3);
        Cargo_cars DAF = new Cargo_cars("DAF", "XF 105", 10.0, Cargo_cars.LoadCapacity.N2);
        Cargo_cars MAN = new Cargo_cars("MAN", "TGX", 9.3, Cargo_cars.LoadCapacity.N1);
        Cargo_cars scania = new Cargo_cars("SCANIA", "R-370", 12.7, Cargo_cars.LoadCapacity.N3);
        System.out.println(mercedes);
        System.out.println(DAF);
        System.out.println(MAN);
        mercedes.printType();

        Buses BAF = new Buses("BAF", "X45", 3.5, Buses.PeopleCapacity.SMALL);
        Buses PAZ = new Buses("PAZ", "335", 5.0, Buses.PeopleCapacity.BIG);
        Buses LIAZ = new Buses("LIAZ", "33-56", 4.0, Buses.PeopleCapacity.EXTRA_LARGE);
        Buses HYUNDAI = new Buses("HYUNDAI", "Fly Wagon", 3.7, Buses.PeopleCapacity.ESPECIALLY_SMALL);

        System.out.println(BAF);
        System.out.println(PAZ);
        System.out.println(LIAZ);
        System.out.println(HYUNDAI);
        BAF.printType();

        audi.getStart();
        mercedes.getStart();
        PAZ.getStart();

        audi.maxSpeed(280);
        audi.bestLapTime(1.21);

        mercedes.pitStop();
        mercedes.maxSpeed(123);
        mercedes.bestLapTime(3.45);

        PAZ.pitStop();
        PAZ.maxSpeed(98);
        PAZ.bestLapTime(4.51);

        audi.getFinish();
        mercedes.getFinish();
        PAZ.getFinish();

        Drivers<Passenger_cars> shrudt = new Driver_B("Дуайт Карл Шрудт", "B", 5);
        shrudt.getStart(audi);
        shrudt.getGasUp(audi);
        shrudt.getFinish(audi);

        Drivers<Cargo_cars> figel = new Driver_C("Готлиб Маркус Фигельбаум", "C", 9);
        figel.getStart(mercedes);
        figel.getGasUp(mercedes);
        figel.getFinish(mercedes);

        Drivers<Buses> michalich = new Driver_D("Побединский Иван Михайлович", "D", 38);
        michalich.getStart(PAZ);
        michalich.getGasUp(PAZ);
        michalich.getFinish(PAZ);

        audi.service();
        mercedes.service();
        PAZ.service();

        List<Transports> raceTransport = new ArrayList<>();
        raceTransport.add(audi);
        raceTransport.add(mercedes);
        raceTransport.add(BAF);
        System.out.println("Участвуют в гонке: " + raceTransport);

        Mechanics alex = new Mechanics("Alex Ivanov", "FixAll", Mechanics.RepairSpecification.SPECIFICATION_CAR);
        Mechanics ivan = new Mechanics("Ivan Petrov", "RepairCar", Mechanics.RepairSpecification.SPECIFICATION_BUS);
        Mechanics petr = new Mechanics("Petr Nachimov", "ToolMax", Mechanics.RepairSpecification.SPECIFICATION_TRUCK);
        Mechanics mark = new Mechanics("Mark Verona", "ToolMax", Mechanics.RepairSpecification.SPECIFICATION_UNIVERSAL);


        List<Drivers> namesDrivers = new ArrayList<>();
        namesDrivers.add(shrudt);
        namesDrivers.add(figel);
        namesDrivers.add(michalich);
        System.out.println("Имена водителей: " + namesDrivers);

        List<Mechanics> namesMechanics = new ArrayList<>();
        namesMechanics.add(alex);
        namesMechanics.add(alex);
        namesMechanics.add(ivan);
        namesMechanics.add(petr);
        namesMechanics.add(mark);
        System.out.println("Механики: " + namesMechanics);

        audi.getTechnicalService(namesMechanics);
        BAF.getTechnicalService(namesMechanics);

        audi.getFixCar(namesMechanics);
        BAF.getFixCar(namesMechanics);

        audi.getInfoAboutCar(namesMechanics,namesDrivers);

        Map<Transports, Mechanics> carAndMechanic = new HashMap();
        carAndMechanic.putIfAbsent(audi, alex);
        carAndMechanic.putIfAbsent(mercedes, ivan);
        carAndMechanic.putIfAbsent(mercedes, mark);

        for (Map.Entry<Transports, Mechanics> i: carAndMechanic.entrySet()) {
            System.out.println("Автомобиль " + i.getKey() + " обслуживает " + i.getValue());
        }




    }
}