package cars;

import drivers.Driver_B;
import drivers.Drivers;
import Mechanics.Mechanics;

import java.util.List;

public class Passenger_cars extends Transports {

    private TypeOfBody typeOfBody;

    public Passenger_cars(String brand, String model, double engineVolume, TypeOfBody typeOfBody) {
        super(brand, model, engineVolume);
        this.typeOfBody = typeOfBody;
    }


    public enum TypeOfBody {
        SEDAN("Седан"),
        HATCHBACK("Хетчбек"),
        COUPE("Купе"),
        WAGON("Универсал"),
        SUV("Внедорожник"),
        CROSSOVER("Кроссовер"),
        PICKUP("Пикап"),
        VAN("Фургон"),
        MINIVAN("Минивэн");

        public final String type;

        TypeOfBody(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

    }

    @Override
    public void printType() {
        if (typeOfBody == null) {
            System.out.println("Данных по авто не достаточно");
        } else {
            System.out.println("Тип кузова " + getBrand() + " " + getModel() + ":" + typeOfBody.type);
        }
    }

    @Override
    public void service() {
        System.out.println("Диагностика для " + getBrand() + " " + getModel() + " пройдена");

    }

    public TypeOfBody getTypeOfBody() {
        return typeOfBody;
    }

    public void setTypeOfBody(TypeOfBody typeOfBody) {
        this.typeOfBody = typeOfBody;
    }

    public void getStart() {
        super.getStart();
    }

    public void getFinish() {
        super.getFinish();
    }

    @Override
    public void getTechnicalService(List<Mechanics> namesMechanics) {
        System.out.println("Механики :");
        for (Mechanics value : namesMechanics) {
            if (value.getRepairSpecification() == Mechanics.RepairSpecification.SPECIFICATION_CAR || value.getRepairSpecification() == Mechanics.RepairSpecification.SPECIFICATION_UNIVERSAL) {
                System.out.println("- " + value);
            }
        }
        System.out.println("производят регулярное ТО на автомобиле " + getBrand() + " " + getModel());

    }

    @Override
    public void getFixCar(List<Mechanics> namesMechanics) {
        System.out.println("Механики :");
        for (Mechanics value : namesMechanics) {
            if (value.getRepairSpecification() == Mechanics.RepairSpecification.SPECIFICATION_CAR || value.getRepairSpecification() == Mechanics.RepairSpecification.SPECIFICATION_UNIVERSAL) {
                System.out.println("- " + value);
            }
        }
        System.out.println("занимаются ремонтом транспорта " + getBrand() + " " + getModel());

    }

    @Override
    public void getInfoAboutCar(List<Mechanics> namesMechanics, List<Drivers> drivers) {
        System.out.print("Водитель автомобиля " + getBrand() + " " + getModel() + ": ");
        for (Drivers value : drivers) {
            if (value instanceof Driver_B) {
                System.out.println(value);
            }
        }
        System.out.println("Механики автомобиля " + getBrand() + " " + getModel() + ": ");
        for (Mechanics value : namesMechanics) {
            if (value.getRepairSpecification() == Mechanics.RepairSpecification.SPECIFICATION_CAR || value.getRepairSpecification() == Mechanics.RepairSpecification.SPECIFICATION_UNIVERSAL) {
                System.out.println("- " + value);
            }
        }
    }

}
