package com.project.atelier_2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
public class FactureTest {

    @Test
    public void testAjouterArticle() {
        Facture facture = new Facture();
        Article article1 = new Article("Article 1", 2, 10.0);
        Article article2 = new Article("Article 2", 3, 20.0);
        facture.ajouterArticle(article1);
        facture.ajouterArticle(article2);
        List<Article> articles = facture.getArticles();
        assertEquals(2, articles.size(), "La facture doit contenir 2 articles");
        assertTrue(articles.contains(article1), "La facture doit contenir l'article 1");
        assertTrue(articles.contains(article2), "La facture doit contenir l'article 2");
    }

    @Test
    public void testSupprimerArticle() {
        Facture facture = new Facture();
        Article article1 = new Article("Article 1", 2, 10.0);
        Article article2 = new Article("Article 2", 3, 20.0);
        facture.ajouterArticle(article1);
        facture.ajouterArticle(article2);
        facture.supprimerArticle(article1);
        List<Article> articles = facture.getArticles();
        assertEquals(1, articles.size(), "La facture doit contenir 1 article après suppression");
        assertFalse(articles.contains(article1), "La facture ne doit plus contenir l'article 1");
    }

    @Test
    public void testCalculerTotal() {
        Facture facture = new Facture();
        Article article1 = new Article("Article 1", 2, 10.0);
        Article article2 = new Article("Article 2", 3, 20.0);
        facture.ajouterArticle(article1);
        facture.ajouterArticle(article2);
        double total = facture.getTotal();
        assertEquals(80.0, total, "Le total de la facture doit être égal à 80.0");
    }

    @Test
    public void testViderFacture() {
        Facture facture = new Facture();
        Article article1 = new Article("Article 1", 2, 10.0);
        facture.ajouterArticle(article1);
        facture.viderFacture();
        List<Article> articles = facture.getArticles();
        assertTrue(articles.isEmpty(), "La facture doit être vide après appel de viderFacture()");
    }
}