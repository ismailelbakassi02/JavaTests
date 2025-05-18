package com.project.atelier_2;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LigneCommandeModelTest {
    
	private static Article article;
	private static LigneCommandeModel ligneCommande;
    
    @BeforeAll
    static void setUp() {
        // Initialisation d'un article pour les tests
        article = new Article("Produit Test", 10, 100.0);
        article.setIdArticle(1L); 
        
        // Initialisation d'une ligne de commande standard
        ligneCommande = new LigneCommandeModel(article, 2, 100.0, 5.0);
    }
        
    
    @Test
    public void testConstructeurSansRemise() {
        LigneCommandeModel ligne = new LigneCommandeModel(article, 2, 100.0);
        assertEquals(article, ligne.getArticle());
        assertEquals(2, ligne.getQuantite());
        assertEquals(100.0, ligne.getPrixUnitaire(), 0.001);
        assertEquals(0.0, ligne.getRemise(), 0.001);
    }
    
    @Test
    public void testConstructeurAvecRemise() {
        assertEquals(article, ligneCommande.getArticle());
        assertEquals(2, ligneCommande.getQuantite());
        assertEquals(100.0, ligneCommande.getPrixUnitaire(), 0.001);
        assertEquals(5.0, ligneCommande.getRemise(), 0.001);
    }
    
    @Test
    public void testCalculerMontantBrut() {
        double montantBrut = ligneCommande.calculerMontantBrut();
        assertEquals(200.0, montantBrut);
    }
    
    @Test
    public void testCalculerMontantRemise() {
        double montantRemise = ligneCommande.calculerMontantRemise();
        assertEquals(10.0, montantRemise, 0.001);
    }
    
    @Test
    public void testCalculerMontantNet() {
        double montantNet = ligneCommande.calculerMontantNet();
        assertEquals(190.0, montantNet, 0.001);
    }
    
    @Test
    public void testVerifierDisponibilite_Disponible() {
        assertTrue(ligneCommande.verifierDisponibilite());
    }
    
    @Test
    public void testVerifierDisponibilite_NonDisponible() {
        ligneCommande.setQuantite(20); // Quantité > stock disponible
        assertFalse(ligneCommande.verifierDisponibilite());
    }
    
    @Test
    public void testVerifierDisponibilite_ArticleNull() {
        ligneCommande.setArticle(null);
        assertFalse(ligneCommande.verifierDisponibilite());
    }
    
    @Test
    public void testMettreAJourStock_Succes() {
        assertTrue(ligneCommande.mettreAJourStock());
        assertEquals(8, article.getQuantite()); // 10 - 2 = 8
    }
    
    @Test
    public void testMettreAJourStock_Echec() {
        ligneCommande.setQuantite(20); // Quantité > stock disponible
        assertFalse(ligneCommande.mettreAJourStock());
        assertEquals(10, article.getQuantite()); // Le stock n'a pas changé
    }
    
    @Test
    public void testSettersGetters() {
        // Test des setters et getters
        Article nouvelArticle = new Article("Nouveau produit", 5, 50.0);
        ligneCommande.setArticle(nouvelArticle);
        ligneCommande.setQuantite(3);
        ligneCommande.setPrixUnitaire(75.0);
        ligneCommande.setRemise(10.0);
        
        assertEquals(nouvelArticle, ligneCommande.getArticle());
        assertEquals(3, ligneCommande.getQuantite());
        assertEquals(75.0, ligneCommande.getPrixUnitaire(), 0.001);
        assertEquals(10.0, ligneCommande.getRemise(), 0.001);
    }
    
    @Test
    public void testToString() {
        String expected = "LigneCommande [article=Produit Test, quantité=2, prix unitaire=100.0, remise=5.0%]";
        assertEquals(expected, ligneCommande.toString());
    }
    
    @Test
    public void testToString_ArticleNull() {
        ligneCommande.setArticle(null);
        String expected = "LigneCommande [article=null, quantité=2, prix unitaire=100.0, remise=5.0%]";
        assertEquals(expected, ligneCommande.toString());
    }
}