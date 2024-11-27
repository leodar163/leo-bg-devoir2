package cours.controle2.dto;
import cours.controle2.entities.Action;
import cours.controle2.entities.Trader;

public class AcheterDTO
{
    public Trader trader;
    public Action action;
    public Integer quantite;
    public float prix;

    public AcheterDTO(Trader trader, Action action, Integer quantite, float prix)
    {
        this.trader = trader;
        this.action = action;
        this.quantite = quantite;
        this.prix = prix;
    }
}
