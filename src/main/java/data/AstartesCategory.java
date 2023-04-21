package data;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
/**
 * The class with spaceMarine's astartesCategory
 */
@XmlEnum(String.class)
public enum AstartesCategory {
    @XmlEnumValue("Scout")
    SCOUT,
    @XmlEnumValue("Inceptor")
    INCEPTOR,
    @XmlEnumValue("tactical")
    TACTICAL,
    @XmlEnumValue("terminator")
    TERMINATOR,
    @XmlEnumValue("helix")
    HELIX;
}