package GachaGame;
import java.util.PriorityQueue;

public class ToyQueue {
    private PriorityQueue<Toy> queue;

    ToyQueue(Toy[] toys) {
        queue = new PriorityQueue<>((t1, t2) -> t2.frequency - t1.frequency);
        for (Toy toy : toys) {
            queue.add(toy);
        }
    }

    Toy poll() {
        return queue.poll();
    }

    boolean isEmpty() {
        return queue.isEmpty();
    }
}
    