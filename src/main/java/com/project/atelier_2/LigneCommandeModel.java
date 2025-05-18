package com.project.atelier_2;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
public class LigneCommandeModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLigneCommande;
    
    @ManyToOne
    @JoinColumn(name = "idArticle")
    private Article article;
    
    private int quantite;
    private double prixUnitaire;
    private double remise;
    
    // Constructeurs
    public LigneCommandeModel() {
    }
    
    public LigneCommandeModel(Article article, int quantite, double prixUnitaire) {
        this.article = article;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
        this.remise = 0.0;
    }
    
    public LigneCommandeModel(Article article, int quantite, double prixUnitaire, double remise) {
        this.article = article;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
        this.remise = remise;
    }
    
    // Getters et Setters
    public Long getIdLigneCommande() {
        return idLigneCommande;
    }
    
    public void setIdLigneCommande(Long idLigneCommande) {
        this.idLigneCommande = idLigneCommande;
    }
    
    public Article getArticle() {
        return article;
    }
    
    public void setArticle(Article article) {
        this.article = article;
    }
    
    public int getQuantite() {
        return quantite;
    }
    
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    
    public double getPrixUnitaire() {
        return prixUnitaire;
    }
    
    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
    
    public double getRemise() {
        return remise;
    }
    
    public void setRemise(double remise) {
        this.remise = remise;
    }
    
    // Méthodes métier
    
    /**
     * Calcule le montant total de la ligne de commande sans remise
     * @return le montant total (quantité * prix unitaire)
     */
    public double calculerMontantBrut() {
        return quantite * prixUnitaire;
    }
    
    /**
     * Calcule le montant de la remise
     * @return le montant de la remise
     */
    public double calculerMontantRemise() {
        return calculerMontantBrut() * (remise / 100.0);
    }
    
    /**
     * Calcule le montant net (après remise)
     * @return le montant net
     */
    public double calculerMontantNet() {
        return calculerMontantBrut() - calculerMontantRemise();
    }
    
    /**
     * Vérifie si la quantité commandée est disponible en stock
     * @return true si la quantité est disponible, false sinon
     */
    public boolean verifierDisponibilite() {
        if (article == null) {
            return false;
        }
        return quantite <= article.getQuantite();
    }
    
    /**
     * Met à jour le stock de l'article après validation de la commande
     * @return true si la mise à jour a réussi, false sinon
     */
    public boolean mettreAJourStock() {
        if (!verifierDisponibilite()) {
            return false;
        }
        
        article.setQuantite(article.getQuantite() - quantite);
        return true;
    }
    
    @Override
    public String toString() {
        return "LigneCommande [article=" + (article != null ? article.getNom() : "null") + 
               ", quantité=" + quantite + 
               ", prix unitaire=" + prixUnitaire + 
               ", remise=" + remise + "%]";
    }
}