package ru.netology.javaqa;

public class Repository {

   public void add(Product product) {
       Product[] newProducts = new Product[this.products.length + 1];
       for (int i = 0; i < this.products.length; i++) {
           newProducts[i] = this.products[i];
       }

       newProducts[newProducts.length - 1] = product;
       this.products = newProducts;
   }

    public Product[] findAll() {
        return this.products;
    }

    public void removeById(int id) {
       if (products.length == 0) {
           return;
       }

        Product[] tmp = new Product[this.products.length - 1];
        int copyToIndex = 0;
        for (Product item : this.products) {
            if (item.id != id) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        this.products = tmp;
    }

    private Product[] products = new Product[0];
}
