package oop;
/*
Урок 1 Домашнее задание на закрепление:
1)Создать класс Товар, имеющий переменные имя, цена, рейтинг.
2)Создать класс Категория, имеющий переменные имя и массив товаров. Создать несколько объектов класса Категория.
3)Создать класс Basket, содержащий массив купленных товаров.
4)Создать класс User, содержащий логин, пароль и объект класса Basket. Создать несколько объектов класса User.
5)Вывести на консоль каталог продуктов. (все продукты магазина)
6)Вывести на консоль покупки посетителей магазина. (После покупки у пользователя добавляется товар, а из магазина - удаляется)
 */
public class Main {
    public static void main(String[] args) {
        String separator = "===================================================";
        Store store = new Store("Красный Октябрь");
        Product bottledWater = new BottledWater("Новотерская минералка",300,10.1,1.0);
        Product frozenStuff = new FrozenStuff();
        Product bottledWater2 = new BottledWater();
        Product frozenChicken = new FrozenStuff("Жаренная курочка");
        Product Novoterskaya = new BottledWater("Новотерская минералка", 150, 0.5);
        ProductCategory frozenStuffCat = new ProductCategory("Полуфабрикаты");
        ProductCategory bottledWaterCat = new ProductCategory("Вода");
        frozenStuffCat.addProduct(frozenStuff);
        frozenStuffCat.addProduct(frozenChicken);
        bottledWaterCat.addProduct(Novoterskaya);
        bottledWaterCat.addProduct(bottledWater2);
        bottledWaterCat.addProduct(bottledWater);
        store.addProductToStore(bottledWaterCat,10);
        store.addProductToStore(frozenStuffCat,20);
        User Vsevolodovich = new User("Алекс Всеволодович", "Alex", "pass");
        User Bunin = new User("Роман Бунин","roma","12345");
        System.out.println(separator);
        System.out.println(Vsevolodovich);
        System.out.println(separator);
        System.out.println(Bunin);
        System.out.println(separator);
        System.out.printf("В магазине '%s' есть товары:%n",store.getName());
        store.showStore();
        System.out.println(separator);
        store.sell(Vsevolodovich,Novoterskaya,5);
        store.sell(Vsevolodovich,Novoterskaya,5);
        store.sell(Vsevolodovich,frozenStuff,14);
        store.sell(Bunin,frozenStuffCat,20);
        store.sell(Bunin,Novoterskaya,5);
        store.sell(Bunin,frozenChicken,13);
        System.out.printf("У покупателя %s в корзине находятся товары: %n", Vsevolodovich.getName());
        Vsevolodovich.showUserBasket();
        System.out.println(separator);
        System.out.printf("У покупателя %s в корзине находятся товары: %n", Bunin.getName());
        Bunin.showUserBasket();
        System.out.println(separator);
        System.out.printf("В магазине '%s' есть товары:%n",store.getName());
        store.showStore();
        System.out.println(separator);
    }
}