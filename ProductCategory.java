
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductCategory extends Product {
    protected String name;
    protected List<Product> products;

    public ProductCategory(String name) {
        super();
        this.name = name;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void showProducts(){
        for (Product product: products){
            System.out.println(product);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCategory that = (ProductCategory) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
