package data;

import collection.GenerationID;
import error.InvalidInputException;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.time.LocalDate;
/**
 * The class with spaceMarine's constructor
 */
@XmlRootElement
@XmlAccessorType (XmlAccessType.FIELD)
public class SpaceMarine implements Comparable<SpaceMarine>{
    private Long id;
    private String name;
    private Coordinates coordinates;

    @XmlTransient
    private java.time.LocalDate creationDate;
    private Float health;
    private AstartesCategory category;
    private Weapon weaponType;
    private MeleeWeapon meleeWeapon;
    private Chapter chapter;
    public SpaceMarine(){}
    public SpaceMarine(String name, Coordinates coordinates, Float health, AstartesCategory category, Weapon weaponType, MeleeWeapon meleeWeapon, Chapter chapter) {
        if (
//                id == null
                name == null
                || coordinates == null
                || health == null
                || chapter == null
        ){
            throw new InvalidInputException("Значение не может быть null");
        }
        this.id = GenerationID.generateID();
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = LocalDate.now();
        this.health = health;
        this.category = category;
        this.weaponType = weaponType;
        this.meleeWeapon = meleeWeapon;
        this.chapter = chapter;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = GenerationID.generateID();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @XmlElement(name = "creation_date")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Float getHealth() {
        return health;
    }

    public void setHealth(Float health) {
        this.health = health;
    }

    public AstartesCategory getCategory() {
        return category;
    }

    public void setCategory(AstartesCategory category) {
        this.category = category;
    }

    public Weapon getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(Weapon weaponType) {
        this.weaponType = weaponType;
    }

    public MeleeWeapon getMeleeWeapon() {
        return meleeWeapon;
    }

    public void setMeleeWeapon(MeleeWeapon meleeWeapon) {
        this.meleeWeapon = meleeWeapon;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    @Override
    public int compareTo(SpaceMarine o) {
        if (this.getHealth() > o.getHealth()){
            return 1;
        } else if (this.getHealth() < o.getHealth()){
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "SpaceMarine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", health=" + health +
                ", category=" + category +
                ", weaponType=" + weaponType +
                ", meleeWeapon=" + meleeWeapon +
                ", chapter=" + chapter +
                '}';
    }
}

