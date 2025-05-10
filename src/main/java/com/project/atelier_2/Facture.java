package com.project.atelier_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFacture;

    private Date dateFacture; // Date de la facture

    private String client; // Nom ou ID du client

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Article> articles;

    // Constructeur
    public Facture() {
        this.articles = new ArrayList<>();
        this.dateFacture = new Date(); // Par défaut, on met la date actuelle
    }

    // Ajouter un article à la facture
    public boolean ajouterArticle(Article article) {
        if (article == null) {
            return false;
        }
        return articles.add(article);
    }

    // Supprimer un article de la facture
    public boolean supprimerArticle(Article article) {
        return articles.remove(article);
    }

    // Récupérer tous les articles de la facture
    public List<Article> getArticles() {
        return new ArrayList<>(articles);
    }

    // Vider la facture
    public void viderFacture() {
        articles.clear();
    }

    // Calculer le total de la facture
    public double getTotal() {
        double total = 0;
        for (Article article : articles) {
            total += article.calculerPrixTotal();
        }
        return total;
    }

    // Getters et Setters
    public Long getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(Long idFacture) {
        this.idFacture = idFacture;
    }

    public Date getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(Date dateFacture) {
        this.dateFacture = dateFacture;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}