package ru.converterProject.models;

import org.springframework.stereotype.Component;
import ru.converterProject.models.enums.LengthEnum;
@Component
public class LengthConverter {
    public String convert(String lengthFrom, String lengthTo, String value){
        LengthEnum firstLengthParam = LengthEnum.getEnumValueByName(lengthFrom);
        LengthEnum secondLengthParam = LengthEnum.getEnumValueByName(lengthTo);
        double inputValue = 0.0;
        try {
            inputValue = Double.parseDouble(value);
        }catch (NumberFormatException e){
            //log exception
            return "Wrong enter value";
        }catch (NullPointerException e){
            //log exception
            return "Wrong enter value";
        }
        return "" + String.format ("%f", count(inputValue, firstLengthParam, secondLengthParam));
    }

    private static double count (double value, LengthEnum firstLengthParam, LengthEnum secondLengthParam){
        return value * (firstLengthParam.getVALUE_IN_METER()/secondLengthParam.getVALUE_IN_METER());
    }
}
