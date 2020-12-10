package ru.converterProject.models.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum WeightEnum {
    KILOGRAM("kilogram", 1.0),
    POUND("pound", 0.45359243),
    CARAT("carat", 0.0002),
    OUNCE("ounce", 0.028349523125),
    GRAM("gram", 0.001),
    TON("ton", 1000);

    private final String NAME;
    private final double VALUE_IN_KILOGRAM;

    private static final List<WeightEnum> VALUES;


    public static List<WeightEnum> getVALUES() {
        return VALUES;
    }

    static {
        VALUES = new ArrayList<>();
        VALUES.addAll(Arrays.asList(WeightEnum.values()));
    }

    WeightEnum(String NAME, double VALUE_IN_KILOGRAM) {
        this.NAME = NAME;
        this.VALUE_IN_KILOGRAM = VALUE_IN_KILOGRAM;
    }

    public String getNAME() {
        return NAME;
    }

    public double getVALUE_IN_KILOGRAM() {
        return VALUE_IN_KILOGRAM;
    }

    public static WeightEnum getEnumValueByName(String name){
        return WeightEnum.valueOf(name.toUpperCase());
    }
}
