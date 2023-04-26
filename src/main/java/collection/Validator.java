package collection;

import data.AstartesCategory;
import data.MeleeWeapon;
import data.SpaceMarine;
import data.Weapon;
import error.IncorrectCollectionException;

public class Validator {


    public boolean checkName(String name){
            if (name.equals("") || !name.matches("^[a-zA-Z-А-Яа-я]*$")) {
                return false;
            }
        return true;
    }

    public boolean checkCoordinateX(Integer X) {
        if (X <= -595 || X == null) {
            return false;
        }
        return true;
    }

    public boolean checkCoordinateY(Float Y){
        if (Y == null){
            return false;
        }
        return true;
    }

    public boolean checkHealth(Float health) {
            if (health < 0) {
                return false;
            }
        return true;
    }

    public boolean checkMarinesCount(Integer marinesCount){
        if (0 >= marinesCount || marinesCount > 1000){
            return false;
        }
        return true;
    }
    public boolean checkCategory(AstartesCategory category) {
        for (AstartesCategory category1 : AstartesCategory.values()) {
            if (!category1.name().equals(category)){
                return false;
            }
        }
        return true;
    }

    public boolean checkMeleeWeapon(MeleeWeapon meleeWeapon){
        for (MeleeWeapon meleeWeapon1 : MeleeWeapon.values()) {
            if (!meleeWeapon1.name().equals(meleeWeapon)){
                return false;
            }
        }
        return true;
    }
    public boolean checkWeapon(Weapon weapon){
        for (Weapon weapon1 : Weapon.values()) {
            if (!weapon1.name().equals(weapon)){
                return false;
            }
        }
        return true;
    }
}
