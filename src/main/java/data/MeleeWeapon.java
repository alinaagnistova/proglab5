package data;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
/**
 * The class with spaceMarine's MeleeWeapon
 */
@XmlEnum(String.class)
public enum MeleeWeapon {
    @XmlEnumValue("chain")
    CHAIN_SWORD,
    @XmlEnumValue("power")
    POWER_SWORD,
    @XmlEnumValue("chain")
    CHAIN_AXE,
    @XmlEnumValue("reaper")
    MANREAPER,
    @XmlEnumValue("claw")
    LIGHTING_CLAW;
}