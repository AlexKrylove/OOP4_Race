package cars;

import drivers.Driver_B;
import drivers.Driver_C;
import drivers.Drivers;
import Mechanics.Mechanics;

import java.util.List;

public class Cargo_cars extends Transports {
    private LoadCapacity loadCapacity;

    public Cargo_cars(String brand, String model, double engineVolume, LoadCapacity loadCapacity) {
        super(brand, model, engineVolume);
        this.loadCapacity = loadCapacity;
    }

    public enum LoadCapacity {
        N1(null, 3.5f),
        N2(3.5f, 12.0f),
        N3(12.0f, null);

        private final Float minMass;
        private final Float maxMass;

        LoadCapacity(Float minMass, Float maxMass) {
            this.minMass = minMass;
            this.maxMass = maxMass;
        }

        public Float getMinMass() {
            return minMass;
        }

        public Float getMaxMass() {
            return maxMass;
        }

        @Override
        public String toString() {
            if (minMass == null) {
                return ", Грузоподъемность до " + maxMass + " тонн";
            }
            if (maxMass == null) {
                return ", Грузоподъемность от " + minMass + " тонн";
            } else {
                return ", Грузоподъемность от " + minMass + " тонн до " + maxMass + " тонн";
            }
        }
    }

    @Override
    public void printType() {
        if (loadCapacity.minMass == null) {
            System.out.println("Грузоподъемность" + getBrand() + " " + getModel() + ": до " + getLoadCapacity().maxMass + " тонн");
        }
        if (loadCapacity.maxMass == null) {
            System.out.println("Грузоподъемность " + getBrand() + " " + getModel() + ": от " + getLoadCapacity().minMass + " тонн");
        } else {
            System.out.println("Грузоподъемность " + getBrand() + " " + getModel() + ": от " + getLoadCapacity().maxMass + " тонн до " + getLoadCapacity().minMass + " тонн");
        }
    }

    public void getStart() {
        super.getStart();
    }

    public void getFinish() {
        super.getFinish();
    }

    public LoadCapacity getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(LoadCapacity loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public String toString() {
        return "Марка: " + brand +
                ", модель: " + model +
                ", объем двигателя: " + engineVolume + loadCapacity;
    }

    public void service() {
        System.out.println("Диагностика для " + getBrand() +" " + getModel() + " пройдена");

    }
    @Override
    public void getTechnicalService(List<Mechanics> mechanics) {
        System.out.println("Механики :");
        for (Mechanics value : mechanics) {
            if (value.getRepairSpecification() == Mechanics.RepairSpecification.SPECIFICATION_TRUCK||value.getRepairSpecification() == Mechanics.RepairSpecification.SPECIFICATION_UNIVERSAL) {
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
    public void getInfoAboutCar(List<Mechanics> namesMechanics, List<Drivers> drivers) {
        System.out.print("Водитель автомобиля " + getBrand() + " " + getModel() + ": ");
        for (Drivers value : drivers) {
            if (value instanceof Driver_C) {
                System.out.println(value);
            }
        }
        System.out.println("Механики автомобиля " + getBrand() + " " + getModel() + ": ");
        for (Mechanics value : namesMechanics) {
            if (value.getRepairSpecification() == Mechanics.RepairSpecification.SPECIFICATION_TRUCK || value.getRepairSpecification() == Mechanics.RepairSpecification.SPECIFICATION_UNIVERSAL) {
                System.out.println("- " + value);
            }
        }
    }
}
