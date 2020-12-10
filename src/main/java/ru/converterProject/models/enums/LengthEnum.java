package ru.converterProject.models.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum LengthEnum {

    CENTIMETER("centimeter", 0.01),
    METER("meter", 1.0),
    KILOMETER("kilometer", 1000),
    MILE("mile", 1609.344),
    FOOT("foot", 0.3048),
    INCH("inch", 0.0254),
    YARD("yard", 0.9144);

    private final String NAME;
    private final double VALUE_IN_METER;

    private static final List<LengthEnum> VALUES;

    public static List<LengthEnum> getVALUES() {
        return VALUES;
    }

    static {
        VALUES = new ArrayList<>();
        VALUES.addAll(Arrays.asList(LengthEnum.values()));
    }

    LengthEnum(String NAME, double VALUE_IN_METER) {
        this.NAME = NAME;
        this.VALUE_IN_METER = VALUE_IN_METER;
    }

    public String getNAME() {
        return NAME;
    }

    public double getVALUE_IN_METER() {
        return VALUE_IN_METER;
    }

    public static LengthEnum getEnumValueByName(String name){
        return LengthEnum.valueOf(name.toUpperCase());
    }

}
