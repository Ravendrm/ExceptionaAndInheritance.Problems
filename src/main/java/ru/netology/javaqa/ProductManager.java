package ru.netology.javaqa;

public class ProductManager {
    private Repository repository;

    ProductManager(Repository repo) {
        repository = repo;
    }

    public void add(Product product) {
        repository.add(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product: repository.findAll()) {
            if (matches(product, text)) {
                result = addToProducts(result, product);
            }
        }
        return result;
    }
    public boolean matches(Product product, String search) {
        if (product.name.contains(search)) {
            return true;
        } else {
            return false;
        }

        // return product.getName().contains(search);
    }

    private Product[] addToProducts(Product[] products, Product p) {
        Product[] res = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            res[i] = products[i];
        }

        res[res.length - 1] = p;
        return res;
    }
}