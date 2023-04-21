package data;

import error.InvalidInputException;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
/**
 * The class with spaceMarine's coordinates
 */
@XmlRootElement
@XmlAccessorType (XmlAccessType.FIELD)
@XmlType(propOrder = {"x", "y"})
public class Coordinates implements Serializable {
    @XmlTransient
    private Integer x;
    @XmlTransient
    private Float y;

    public Coordinates() {
    }

    public Coordinates(Integer x, Float y) {
        if (x == null || y == null) {
            throw new InvalidInputException("Значение не может быть null");
        }
        if (x <= -595) {
            throw new InvalidInputException("Значение поля должно быть больше -595");  //todo не работает??
        }
        this.x = x;
        this.y = y;
    }

    @XmlElement
    public void setX(Integer x) {
        this.x = x;
    }

    @XmlElement
    public void setY(Float y) {
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public Float getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}


