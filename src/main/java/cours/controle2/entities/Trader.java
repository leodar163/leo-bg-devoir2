package cours.controle2.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "trader")
public class Trader
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTrader", nullable = false)
    private Integer id;

    @Column(name = "nomTrader", nullable = false, length = 50)
    private String nom;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getNom()
    {
        return nom;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

}