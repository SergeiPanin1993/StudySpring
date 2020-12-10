package ru.converterProject.models.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum VolumeEnum {
    LITER("liter", 1.0),
    MILLILITER("milliliter", 0.001),
    GALLON("gallon", 3.785411784),
    PINT("pint", 0.56826125),
    BARREL("barrel", 158.9873);

    private final String NAME;
    private final double VALUE_IN_LITER;

    private static final List<VolumeEnum> VALUES;

    public static List<VolumeEnum> getVALUES() {
        return VALUES;
    }

    static {
        VALUES = new ArrayList<>();
        VALUES.addAll(Arrays.asList(VolumeEnum.values()));
    }

    VolumeEnum(String NAME, double VALUE_IN_LITER) {
        this.NAME = NAME;
        this.VALUE_IN_LITER = VALUE_IN_LITER;
    }

    public String getNAME() {
        return NAME;
    }

    public double getVALUE_IN_LITER() {
        return VALUE_IN_LITER;
    }

    public static VolumeEnum getEnumValueByName(String name){
        return VolumeEnum.valueOf(name.toUpperCase());
    }
}
