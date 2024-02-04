package oop;

import java.util.Objects;

public class User {
    private String name;
    private String login;
    private int passwordHash;
    private Basket basket;

    public User(String name, String login, String password) {
        this.name = name;
        this.login = login;
        passwordHash = setPassword(password);
        basket = new Basket();
    }

    private static int setPassword(String password) {
        return Objects.hashCode(password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String password) {
        this.passwordHash = setPassword(password);
    }

    public void addProductToBasket(Product product, int quantity){
        basket.addProduct(product, quantity);
    }


    public void removeProductFromBasket(Product product){
        if (basket.hasProduct(product)){
            basket.removeProduct(product);
        }

    }

    public void showUserBasket(){
        basket.showBasket();
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + passwordHash + '\''+
                '}';
    }
}
