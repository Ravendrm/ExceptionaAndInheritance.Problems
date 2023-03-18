package ru.netology.javaqa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.TextParsingException;
import ru.netology.javaqa.ProductManager;

public class ProductTest {
    @Test
    public void testNewRepo() {
        Repository repo = new Repository();
        Assertions.assertEquals(0, repo.findAll().length);
    }

    @Test
    public void testAdd() {
        Product p = new Product();
        p.name = "product";
        p.price = 10;
        p.id = 1;

        Repository repo = new Repository();
        repo.add(p);

        Product[] products = repo.findAll();

        Assertions.assertEquals(1, products.length);
        Assertions.assertEquals(p.id, products[0].id);
    }

    @Test
    public void testDelete() {
    Book a = new Book();
        a.author = "Lovecraft";
        a.name = "Hills of Madness";
        a.id = 128281;

        Repository repo = new Repository();
        repo.add(a);
        repo.removeById(a.id);

        Product[] products = repo.findAll();

        Assertions.assertEquals(0, products.length);
    }

    @Test
    public void testSearch() {
        Smartphone a = new Smartphone();
        a.brand = "Apple";
        a.model = "Iphone 13 Pro";
        a.id = 1;
        a.name = "Andromeda";

        Repository repo = new Repository();

        ProductManager manager = new ProductManager(repo);
        manager.add(a);
        Product[] res = manager.searchBy("Andromeda");

        Assertions.assertEquals(1, res.length);
        Assertions.assertEquals(a.id, res[0].id);
    }

    @Test
    public void testSearchNotFound() {
        Smartphone a = new Smartphone();
        a.brand = "Apple";
        a.model = "Iphone 13 Pro";
        a.id = 1;
        a.name = "Andromeda";

        Repository repo = new Repository();

        ProductManager manager = new ProductManager(repo);
        manager.add(a);
        Product[] res = manager.searchBy("Bndromeda");

        Assertions.assertEquals(0, res.length);
    }
}
