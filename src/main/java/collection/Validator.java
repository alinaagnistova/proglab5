package collection;

import data.AstartesCategory;
import data.MeleeWeapon;
import data.SpaceMarine;
import data.Weapon;
import error.IncorrectCollectionException;

public class Validator {


    public boolean checkName(String name){
//        String name = spaceMarine.getName();
            if (name.equals("") || !name.matches("^[a-zA-Z-А-Яа-я]*$")) {
                return false;
            }
        return true;
    }

    public boolean checkCoordinateX(Integer X) { //todo numberfotmatexc?
//        Integer X = spaceMarine.getCoordinates().getX();
        if (X <= -595 || X == null) {
            return false;
        }
        return true;
    }

    public boolean checkCoordinateY(Float Y){
//        Float Y = spaceMarine.getCoordinates().getY();
        if (Y == null){
            return false;
        }
        return true;
    }

    public boolean checkHealth(Float health){
//        Float health = spaceMarine.getHealth();
        if (health < 0){
            return false;
        }
        return true;
    }
    public boolean checkMarinesCount(Integer marinesCount){
//        Integer marinesCount = spaceMarine.getChapter().getMarinesCount();
        if (0 >= marinesCount || marinesCount > 1000){
            return false;
        }
        return true;
    }
    public boolean checkCategory(AstartesCategory category) {
//        AstartesCategory category = spaceMarine.getCategory();
        for (AstartesCategory category1 : AstartesCategory.values()) {
            if (!category1.name().equals(category)){
                return false;
            }
        }
        return true;
    }

    public boolean checkMeleeWeapon(MeleeWeapon meleeWeapon){
//        MeleeWeapon meleeWeapon = spaceMarine.getMeleeWeapon();
        for (MeleeWeapon meleeWeapon1 : MeleeWeapon.values()) {
            if (!meleeWeapon1.name().equals(meleeWeapon)){
                return false;
            }
        }
        return true;
    }
    public boolean checkWeapon(Weapon weapon){
//        Weapon weapon = spaceMarine.getWeaponType();
        for (Weapon weapon1 : Weapon.values()) {
            if (!weapon1.name().equals(weapon)){
                return false;
            }
        }
        return true;
    }
}
