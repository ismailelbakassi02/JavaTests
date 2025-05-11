package com.project.atelier_2;
public class BonLivraison {
    private String numero;
    private String dateLivraison;

    public BonLivraison(String numero, String dateLivraison) {
        this.numero = numero;
        this.dateLivraison = dateLivraison;
    }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public String getDateLivraison() { return dateLivraison; }
    public void setDateLivraison(String dateLivraison) { this.dateLivraison = dateLivraison; }

    public String getDetails() {
        return "Bon de Livraison - Numéro: " + numero + ", Date: " + dateLivraison;
    }
}
