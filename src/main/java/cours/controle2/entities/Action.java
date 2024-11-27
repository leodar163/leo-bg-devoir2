package cours.controle2.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "action")
public class Action
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAction", nullable = false)
    private Integer id;

    @Column(name = "nomAction", nullable = false, length = 50)
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