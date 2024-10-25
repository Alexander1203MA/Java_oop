package Lotmachine;
public class Lot {
    private int id;
    private Toy item;
    private int amt;
    private double prob;

    public Lot(Toy toy) {
        this.item = toy;
        this.id = toy.getId();
    }

    public int getId() {
        return id;
    }

    public int getAmt() {
        return amt;
    }

    public void setAmt(int amt) {
        this.amt = amt;
    }

    public void decrAmt() {
        amt -= 1;
    }

    public double getProb() {
        return prob;
    }

    public void setProb(double prob) {
        this.prob = prob;
    }

    public Toy getItem() {
        return item;
    }

    @Override
    public String toString() {
        return item.toString() + " " + amt + " шт" + " " + prob;
    }
}

