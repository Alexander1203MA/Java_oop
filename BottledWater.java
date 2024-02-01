

import java.util.Objects;

public class BottledWater extends Product{
    private double volume;
    private static String defaultName;
    private static int maxPrice;
    private static int defaultIndex;
    static {
        BottledWater.defaultName = "Бутилированная вода ";
        BottledWater.maxPrice = 400;
        BottledWater.defaultIndex = 0;
    }

    public BottledWater(String name, int price, double rating, double volume) {
        super(name, price, rating);
        this.volume = volume;
    }

    public BottledWater(String name, int price, double volume) {
        super(name, price);
        this.volume = volume;
    }

    public BottledWater(double volume) {
        this(setDefaultName(BottledWater.defaultName,++BottledWater.defaultIndex),
                setRandomPrice(maxPrice),
                volume);
    }

    public BottledWater() {
        this(setDefaultName(BottledWater.defaultName,++BottledWater.defaultIndex),
                setRandomPrice(maxPrice),
                BottledWater.rand.nextDouble()*5*100/100.0);

    }

    @Override
    public String toString() {
        return BottledWater.defaultName+"{"+super.toString()+String.format(", Объем = %.2f}", volume);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BottledWater that = (BottledWater) o;
        return Double.compare(volume, that.volume) == 0 && super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), volume);
    }
}
