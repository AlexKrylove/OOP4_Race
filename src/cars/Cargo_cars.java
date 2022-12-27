package cars;

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
            System.out.println("Грузоподъемность" + getBrand()+ " " + getModel() + ": до " + getLoadCapacity().maxMass + " тонн");
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

}
