
/**
 * Класс описывающий магазин
 *
 */
public class Store {
    private String name;
    private Basket store;

    public Store(String name) {
        this.name = name;
        store = new Basket();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Метод продажи товара product пользователю user
     * @param user Пользователь
     * @param product Товар
     * @param quantity Количество товара
     */
    public void sell(User user, Product product, int quantity){
        if (product instanceof ProductCategory){return;}
        if (store.hasProduct(product)) {
            user.addProductToBasket(product, quantity);
            store.decreaseProduct(product, quantity);
            if (store.getQuantity(product)<=0){
                store.removeProduct(product);
            }
        } else System.out.printf("!!!ОШИБКА!!!%n"+
                        "В магазине \'%s\' нет товара %s в количестве %d для покупателя %s%n", name, product,
                quantity,user.getName());
    }

    /**
     * Метод добавления на склад магазина товаров
     * @param product Товар или Категория товаров
     * @param quantity Количество
     * Если параметр product передается Категория товаров, то в цикле
     * все товары из категории добавляются на склад в количестве quantity
     */
    public void addProductToStore(Product product, int quantity){
        if (product instanceof ProductCategory){
            for (Product newProduct: ((ProductCategory) product).getProducts()){
                store.addProduct(newProduct,quantity);
            }
        }else store.addProduct(product,quantity);

    }

    public void showStore(){
        store.showBasket();
    }
}
