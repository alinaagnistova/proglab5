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
}