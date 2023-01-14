package cars;

import Drivers.Drivers;
import Mechanics.Mechanics;

import java.util.List;

public class Buses extends Transports {
    private PeopleCapacity peopleCapacity;

    public Buses(String brand, String model, double engineVolume, PeopleCapacity peopleCapacity) {
        super(brand, model, engineVolume);
        this.peopleCapacity = peopleCapacity;
    }

    public enum PeopleCapacity {
        ESPECIALLY_SMALL(0, 10),
        SMALL(0, 25),
        AVERAGE(40, 50),
        BIG(60, 80),
        EXTRA_LARGE(100, 120);

        private final int minSeats;
        private final int maxSeats;

        PeopleCapacity(int minSeats, int maxSeats) {
            this.minSeats = minSeats;
            this.maxSeats = maxSeats;
        }

        public int getMinSeats() {
            return minSeats;
        }

        public int getMaxSeats() {
            return maxSeats;
        }


    }

    public void getStart() {
        super.getStart();
    }

    public void getFinish() {
        super.getFinish();
    }

    public PeopleCapacity getPeopleCapacity() {
        return peopleCapacity;
    }

    public void setPeopleCapacity(PeopleCapacity peopleCapacity) {
        this.peopleCapacity = peopleCapacity;
    }

    public void printType() {
        if (peopleCapacity.minSeats == 0) {
            System.out.println("Вместимость " + getBrand() + " " + getModel() + ": до " + getPeopleCapacity().maxSeats + " мест");
        } else {
            System.out.println("Вместимость " + getBrand() + " " + getModel() + ":  " + getPeopleCapacity().minSeats + " - " + getPeopleCapacity().maxSeats + " мест");
        }
    }

    public void service() {
        System.out.println("Автобусы не нуждаются в диагностике");
    }
    @Override
    public void getTechnicalService(List<Mechanics> namesMechanics) {
        System.out.println("Механики :");
        for (Mechanics value : namesMechanics) {
            if (value.getRepairSpecification() == Mechanics.RepairSpecification.SPECIFICATION_BUS||value.getRepairSpecification() == Mechanics.RepairSpecification.SPECIFICATION_UNIVERSAL) {
                System.out.println("- " + value);
            }
        }
        System.out.println("производят регулярное ТО на автомобиле " + getBrand() + " " + getModel());
    }
    public void getFixCar(List<Mechanics> namesMechanics) {
        System.out.println("Механики :");
        for (Mechanics value : namesMechanics) {
            if (value.getRepairSpecification() == Mechanics.RepairSpecification.SPECIFICATION_BUS || value.getRepairSpecification() == Mechanics.RepairSpecification.SPECIFICATION_UNIVERSAL) {
                System.out.println("- " + value);
            }
        }
        System.out.println("занимаются ремонтом транспорта " + getBrand() + " " + getModel());

    }
    @Override
    public void getInfoAboutCar(List<Mechanics> namesMechanics,List<Drivers> drivers) {
        System.out.println("Водитель автомобиля " + getBrand() + " " + getModel() + " - ");
        for (Drivers value : drivers) {
            System.out.println( value);
        }
        System.out.println("Механики автомобиля :" + getBrand() + " " + getModel());
        for (Mechanics value : namesMechanics) {
            if (value.getRepairSpecification() == Mechanics.RepairSpecification.SPECIFICATION_CAR || value.getRepairSpecification() == Mechanics.RepairSpecification.SPECIFICATION_UNIVERSAL) {
                System.out.println("- " + value);
            }
        }

    }

}
