package data;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
/**
 * The class with spaceMarine's Weapon
 */
@XmlEnum(String.class)
public enum Weapon {
    @XmlEnumValue("bolt")
    BOLT_PISTOL,
    @XmlEnumValue("plasme")
    PLASMA_GUN,
    @XmlEnumValue("flamer")
    FLAMER,
    @XmlEnumValue("gravy")
    GRAV_GUN,
    @XmlEnumValue("inferno")
    INFERNO_PISTOL;
}