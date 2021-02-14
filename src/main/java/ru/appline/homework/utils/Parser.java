package ru.appline.homework.utils;

public class Parser {

    public static String parse(String text){
        return text.replaceAll("[^\\d,]", "");
    }
}
