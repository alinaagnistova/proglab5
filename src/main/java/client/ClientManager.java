package client;
import data.*;
import error.InvalidInputException;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * The class is responsible for creating the character
 */
public class ClientManager {
    ReadManager readManager = new ReadManager();
    /**
     * creates a spaceMarine whose data is recorded in the console
     *
     *
     * @return new SpaceMarine
     */
    public SpaceMarine getSpaceMarine(){
        String name = readManager.readName();
        Integer x = readManager.readCoordinateX();
        Float y = readManager.readCoordinateY();
        Float health = readManager.readHealth();
        AstartesCategory category = readManager.readCategory();
        Weapon weapon = readManager.readWeapon();
        MeleeWeapon meleeWeapon = readManager.readMeleeWeapon();
        String chapterName = readManager.readName();
        Integer marinesCount = readManager.readChapterMarinesCount();
        return new SpaceMarine(name, new Coordinates(x, y), health, category, weapon, meleeWeapon, new Chapter(chapterName, marinesCount));
    }
    /**
     * creates a person whose data is recorded in the script
     *
     * @param data
     * @return
     */
    public static SpaceMarine createSpaceMarineFromScript(ArrayList<String> data) {
        try {
            if (data.size() != 9) {
                throw new InvalidInputException("Неправильное количество аргументов");
            }
            String name = data.get(0);
            int x = Integer.parseInt(data.get(1));
            float y = Float.parseFloat(data.get(2));
            Float health = Float.parseFloat(data.get(3));
            AstartesCategory astartesCategory = Enum.valueOf(AstartesCategory.class, data.get(4));
            Weapon weaponType = Enum.valueOf(Weapon.class, data.get(5));
            MeleeWeapon meleeWeapon = Enum.valueOf(MeleeWeapon.class, data.get(6));
            Chapter chapter = new Chapter(data.get(7), Integer.parseInt(data.get(8)));
            Coordinates coordinates = new Coordinates(x, y);
            return new SpaceMarine(name, coordinates, health, astartesCategory, weaponType, meleeWeapon, chapter);
        } catch (NumberFormatException e) {
            System.out.println("Неправильно введены данные");
            return null;
        }
    }
//            try {
//                // Проверяем корректность входных данных и создаем новый объект SpaceMarine
//                if (!data.get(0).equals("") &&
//                                Float.parseFloat(data.get(3)) > 0 &&
//                                ReadManager.doesThisCategoryExist(data.get(4)) &&
//                                ReadManager.doesThisWeaponExist(data.get(5)) &&
//                                ReadManager.doesThisMeleeWeaponExist(data.get(6)) &&
//                                !data.get(7).equals("")
//                ) {
//                    return new SpaceMarine(data.get(0), new Coordinates(Integer.parseInt(data.get(1)), Float.parseFloat(data.get(2))), LocalDateTime.parse(data.get(7)), Float.parseFloat(data.get(3)), Enum.valueOf(AstartesCategory.class, data.get(4)), Enum.valueOf(Weapon.class, data.get(5)), Enum.valueOf(MeleeWeapon.class, data.get(6)), new Chapter(data.get(7)), Integer.parseInt(data.get(8)) > 0);
//                } else {
//                    System.out.println("Неправильно введены данные");
//                    return null;
//                }
//            } catch (NumberFormatException e) {
//                System.out.println("Неправильно введены данные");
//                return null;
//            }
//        }
//
//    }

//        try {
//            if ((!data.get(0).equals("")) && (Integer.parseInt(data.get(1)) > 0) && Float.parseFloat(data.get(2)) > 0 && (Float.parseFloat(data.get(3)) != 0 &&
//                    (Float.parseFloat(data.get(4)) > 0 && (!data.get(5).equals("") && data.get(5).length()<=944 ))&&(Integer.parseInt(data.get(6))>0) && (ReadManager.doesThisCategoryExist(data.get(7))) &&
//                    (ReadManager.doesThisWeaponExist(data.get(8))) && (ReadManager.doesThisMeleeWeaponExist(data.get(9))))) {
//                return new SpaceMarine(data.get(0), new Coordinates(Integer.parseInt(data.get(1)), Float.parseFloat(data.get(2))),Float.parseFloat(data.get(3)),Enum.valueOf(AstartesCategory.class, data.get(4)),Enum.valueOf(Weapon.class,data.get(8)),Enum.valueOf(MeleeWeapon.class, data.get(9)),
//                        new Chapter(data.get(5), Integer.parseInt(data.get(6))));
//
//            } else {
//                System.out.println("Неправильно введены данные");
//                return null;
//            }
//        } catch (NumberFormatException e) {
//            System.out.println("Неправильно введены данные");
//            return null;
//        }
//    }
}