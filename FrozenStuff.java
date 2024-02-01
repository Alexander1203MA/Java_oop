

import java.util.Objects;

public class FrozenStuff extends Product {
    private double weight;
    private static String defaultName;
    private static int maxPrice;
    private static int defaultIndex;

    static {
        FrozenStuff.defaultName = "Полуфабрикат";
        FrozenStuff.maxPrice = 2_000;
        FrozenStuff.defaultIndex = 0;
    }

    public FrozenStuff(String name, int price, double rating, double weight) {
        super(name, price, rating);
        this.weight = weight;
    }

    public FrozenStuff(String name, int price, double weight) {
        super(name, price);
        this.weight = weight;
    }

    public FrozenStuff(String name) {
        this(name,
                setRandomPrice(maxPrice),
                (FrozenStuff.rand.nextDouble() * 3 * 100) / 100.0);
    }

    public FrozenStuff(double weight) {
        this(setDefaultName(FrozenStuff.defaultName, ++FrozenStuff.defaultIndex),
                setRandomPrice(maxPrice),
                weight);
    }

    public FrozenStuff() {
        this(setDefaultName(FrozenStuff.defaultName, ++FrozenStuff.defaultIndex),
                setRandomPrice(maxPrice),
                (FrozenStuff.rand.nextDouble() * 3 * 100) / 100.0);

    }

    @Override
    public String toString() {
        return FrozenStuff.defaultName + "{" + super.toString() + String.format(", Вес = %.2f}", weight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FrozenStuff that = (FrozenStuff) o;
        return Double.compare(weight, that.weight) == 0 && super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), weight);
    }
}
