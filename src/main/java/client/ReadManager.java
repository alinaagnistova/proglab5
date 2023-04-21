package client;

import console.ConsoleManager;
import data.AstartesCategory;
import data.MeleeWeapon;
import data.Weapon;
import java.util.Arrays;
/**
 * The class is responsible for what the user enters
 */
public class ReadManager {
    ConsoleManager consoleManager = new ConsoleManager();
    /**
     * method checks if the name is entered correctly, it contains only letters or not
     *
     * @return name
     */
    public String readName(){
            System.out.println("Введите имя/название отряда:");
            String name = consoleManager.readLine();
        while (true) {
                if (name.equals("")) {
                    System.out.println("Имя не может быть пустой строкой, введите имя");
                    name = consoleManager.readLine();
                } else if (!name.matches("^[a-zA-Z-А-Яа-я]*$")) {
                    System.out.println("Имя не может быть иными знаками кроме букв");
                    name = consoleManager.readLine();
                } else {
                    return name;
                }
            }
    }

    /**
     * checks if the entered coordinate is correct, whether a number is entered or not
     *
     * @return X
     */
    public Integer readCoordinateX(){
        System.out.println("Введите координату X:");
        while (true) {
            try {
                String Xstring = consoleManager.readLine();
                int X = Integer.parseInt(Xstring);
                if (X <= -595) {
                    System.out.println("Значение поля должно быть больше -595, попробуйте ввести значение снова");
                    continue;
                }
                if (!Xstring.equals("")) {
                    return X;
                } else {
                    System.out.println("Вы должны ввести число, а не пустую строку");
                }
            } catch (NumberFormatException e) {
                System.out.println("Число введено неверно");
            }
        }
    }
    /**
     * checks if the entered coordinate is correct, whether a number is entered or not
     *
     * @return Y
     */
    public Float readCoordinateY(){
        System.out.println("Введите координату Y:");
        while (true) {
            try {
                String Ystring = consoleManager.readLine();
                Float Y = Float.parseFloat(Ystring);
                if (!Ystring.equals("")) {
                    return Y;
                } else {
                    System.out.println("Вы должны ввести число, а не пустую строку");
                }
            } catch (NumberFormatException e) {
                System.out.println("Число введено неверно");
            }
        }
    }

    /**
     * checks the correctness of the entered health, whether the number is entered or not, check for zero
     *
     * @return health
     */
    public Float readHealth(){
        System.out.println("Введите уровень здоровья бойца:");
        while (true) {
            String healthString = consoleManager.readLine();
            try {
                float health = Float.parseFloat(healthString);
                if (health > 0) {
                    return health;
                } else {
                    System.out.println("Уровень здоровье должен быть больше 0");
                }
            } catch (NumberFormatException e) {
                System.out.println("Число введено неверно");
            }
        }
    }

    public AstartesCategory readCategory() {
        consoleManager.write("Вы должны ввести одно из перечисленных видов оружия:" + Arrays.toString(AstartesCategory.values()));
        AstartesCategory astartesCategory;
        try{
            astartesCategory = AstartesCategory.valueOf(consoleManager.getValidatedValue("\nВведите вид оружия:").toUpperCase());
        }catch (IllegalArgumentException e){
            astartesCategory = readCategory();
        }
        return astartesCategory;
    }

    public Weapon readWeapon(){
        consoleManager.write("Вы должны ввести одно из перечисленных видов оружия:" + Arrays.toString(Weapon.values()));
        Weapon weapon;
        try {
            weapon = Weapon.valueOf(consoleManager.getValidatedValue("\nВведите вид оружия:").toUpperCase());
        }catch (IllegalArgumentException e){
            weapon = readWeapon();
        }
        return weapon;
    }

    public MeleeWeapon readMeleeWeapon() {
        consoleManager.write("Вы должны ввести одно из перечисленных видов оружия ближнего боя:" + Arrays.toString(MeleeWeapon.values()));
        MeleeWeapon meleeWeapon;
        try {
            meleeWeapon = MeleeWeapon.valueOf(consoleManager.getValidatedValue("\nВведите вид оружия ближнего боя:").toUpperCase());
        }catch (IllegalArgumentException e){
            meleeWeapon = readMeleeWeapon();
        }
        return meleeWeapon;
    }
    public Integer readChapterMarinesCount(){
        consoleManager.write("Введите количество бойцов в отряде:");
        Integer marinesCount;
        try {
            marinesCount = Integer.valueOf(consoleManager.getValidatedValue(""));
        }catch (NumberFormatException e){
            marinesCount = readChapterMarinesCount();
        }
        return marinesCount;
    }

    /**
     * checks the existence of the entered category
     *
     * @param categories
     * @return boolean true or false
     */
    public static boolean doesThisCategoryExist(String categories) {
        for (AstartesCategory category : AstartesCategory.values()) {
            if (category.name().equals(categories)) {
                return true;
            }
        }
        return false;
    }


    /**
     * checks the existence of the entered weapon
     *
     * @param weapons
     * @return boolean true or false
     */
    public static boolean doesThisWeaponExist(String weapons) {
        for (Weapon weapon : Weapon.values()) {
            if (weapon.name().equals(weapons)) {
                return true;
            }
        }
        return false;
    }


    /**
     * checks the existence of the entered color
     *
     * @param meleeWeapons
     * @return boolean true or false
     */
    public static boolean doesThisMeleeWeaponExist(String meleeWeapons) {
        for (MeleeWeapon meleeWeapon : MeleeWeapon.values()) {
            if (meleeWeapon.name().equals(meleeWeapons)) {
                return true;
            }
        }
        return false;
    }
}

