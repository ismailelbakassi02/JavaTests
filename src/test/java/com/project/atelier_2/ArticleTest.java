package com.project.atelier_2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArticleTest {

    @Test
    public void testCalculerPrixTotal() {
        Article article = new Article("Article 1", 3, 10.0);
        double total = article.calculerPrixTotal();
        assertEquals(30.0, total, "Le prix total doit être égal à 3 * 10.0 = 30.0");
    }

    @Test
    public void testArticleAvecQuantiteZero() {
        Article article = new Article("Article 2", 0, 10.0);
        double total = article.calculerPrixTotal();
        assertEquals(0.0, total, "Le prix total doit être égal à 0.0 quand la quantité est 0");
    }

    @Test
    public void testArticleAvecPrixZero() {
        Article article = new Article("Article 3", 5, 0.0);
        double total = article.calculerPrixTotal();
        assertEquals(0.0, total, "Le prix total doit être égal à 0.0 quand le prix est 0.0");
    }
}
