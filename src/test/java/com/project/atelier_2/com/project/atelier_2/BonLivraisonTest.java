package com.project.atelier_2;

import com.project.atelier_2.BonLivraison;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BonLivraisonTest {

    private BonLivraison bonLivraison;

    @BeforeEach
    public void setUp() {
        bonLivraison = new BonLivraison("BL12345", "2025-05-12");
    }

    @Test
    public void testGetDetails() {
        String expected = "Bon de Livraison - Numéro: BL12345, Date: 2025-05-12";
        String actual = bonLivraison.getDetails();
        assertEquals(expected, actual);
    }

    @Test
    public void testNumero() {
        bonLivraison.setNumero("BL54321");
        assertEquals("BL54321", bonLivraison.getNumero());
    }

    @Test
    public void testDateLivraison() {
        bonLivraison.setDateLivraison("2025-06-15");
        assertEquals("2025-06-15", bonLivraison.getDateLivraison());
    }
}
