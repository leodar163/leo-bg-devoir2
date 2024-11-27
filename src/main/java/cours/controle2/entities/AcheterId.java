package cours.controle2.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AcheterId implements Serializable
{
    private static final long serialVersionUID = 425516361641636548L;
    @Column(name = "numAction", nullable = false)
    private Integer action;

    @Column(name = "numTrader", nullable = false)
    private Integer trader;

    public Integer getAction()
    {
        return action;
    }

    public void setAction(Integer action)
    {
        this.action = action;
    }

    public Integer getTrader()
    {
        return trader;
    }

    public void setTrader(Integer trader)
    {
        this.trader = trader;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AcheterId entity = (AcheterId) o;
        return Objects.equals(this.trader, entity.trader) &&
                Objects.equals(this.action, entity.action);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(trader, action);
    }

}