
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Basket {
    private Map<Product, Integer> basket;

    public Basket() {
        basket = new HashMap<>();
    }

    /**
     * @param product  Товар добавляемый в корзину
     * @param quantity Количество товара. Если товар уже есть в корзине, то количество суммируется.
     * @apiNote Метод добавления товара в корзину.
     */
    public void addProduct(Product product, int quantity) {
        Integer res = basket.put(product, quantity);
        if (!Objects.isNull(res)) {
            basket.put(product, res + quantity);
        }
    }

    /**
     * @param product  Товар
     * @param quantity Число на которое уменьшаем количество в корзине если товар есть в ней.
     * @apiNote Метод уменьшения количества товара в корзине.
     */
    public void decreaseProduct(Product product, int quantity) {
        if (basket.containsKey(product)) {
            int res = basket.get(product);
            basket.put(product, res - quantity);
        }
    }

    /**
     * @param product товар, который удаляем. Если товара нет в корзине будет выведено в консоль сообщение об этом.
     * @apiNote Метод удаления товара из корзины.
     */
    public void removeProduct(Product product) {
        if (!basket.containsKey(product)) {
            System.out.printf("Товар %s не найден в корзине", product);
            return;
        }
        basket.remove(product);
    }

    public int getQuantity(Product product){
        return basket.getOrDefault(product,0);
    }

    public boolean hasProduct(Product product) {
        return basket.containsKey(product);
    }

    public void showBasket() {
        for (Product product : basket.keySet()) {
            if (product instanceof ProductCategory) {
                product.showProducts();
            } else System.out.printf("%s кол. = %d%n",product, basket.get(product));

        }
    }
}
