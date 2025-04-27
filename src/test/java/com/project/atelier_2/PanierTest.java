package com.project.atelier_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PanierTest {

    private Panier panier;

    @BeforeEach
    void setUp() {
        panier = new Panier();
    }

    @Test
    void testAddItem() {
        assertTrue(panier.addItem("Produit A"));
        assertEquals(1, panier.getItemCount());
    }

    @Test
    void testAddInvalidItem() {
        assertFalse(panier.addItem(""));
        assertFalse(panier.addItem(null));
    }

    @Test
    void testRemoveItem() {
        panier.addItem("Produit B");
        assertTrue(panier.removeItem("Produit B"));
        assertEquals(0, panier.getItemCount());
    }

    @Test
    void testClearPanier() {
        panier.addItem("Produit C");
        panier.addItem("Produit D");
        panier.clear();
        assertEquals(0, panier.getItemCount());
    }
}
