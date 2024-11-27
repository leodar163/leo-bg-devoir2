﻿package cours.controle2.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "acheter")
public class Acheter
{
    @EmbeddedId
    private AcheterId id;

    @Column(name = "montantAchat", nullable = false)
    private Double prix;

    @Column(name = "quantite", nullable = false)
    private Integer quantite;

    public AcheterId getId()
    {
        return id;
    }

    public void setId(AcheterId id)
    {
        this.id = id;
    }

    public Double getPrix()
    {
        return prix;
    }

    public void setPrix(Double prix)
    {
        this.prix = prix;
    }

    public Integer getQuantite()
    {
        return quantite;
    }

    public void setQuantite(Integer quantite)
    {
        this.quantite = quantite;
    }

}