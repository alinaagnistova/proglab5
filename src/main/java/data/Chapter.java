package data;

import error.InvalidInputException;

import javax.xml.bind.annotation.*;
/**
 * The class with spaceMarine's chapter
 */
@XmlRootElement
@XmlAccessorType (XmlAccessType.FIELD)
public class Chapter {
    private String name;
    private Integer marinesCount;

    public Chapter() {
    }

    public Chapter(String name, Integer marinesCount) {
        if (name == null || name.isEmpty() || name.isBlank()){
            throw new InvalidInputException("Строка не может быть пустой");
        }
        if (marinesCount == null){
            throw new InvalidInputException("marinesCount не может быть null");
        }
        this.name = name;
        this.marinesCount = marinesCount;
    }
    public Chapter setMarinesCount(int marinesCount) {
        if (0 >= marinesCount || marinesCount > 1000){
            throw new InvalidInputException("Значение поля должно быть больше 0, Максимальное значение поля: 1000");
        }
        this.marinesCount = marinesCount;
        return null;
    }

    public String getName() {
        return name;
    }

    public Integer getMarinesCount() {
        return marinesCount;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "name='" + name + '\'' +
                ", marinesCount=" + marinesCount +
                '}';
    }
}
