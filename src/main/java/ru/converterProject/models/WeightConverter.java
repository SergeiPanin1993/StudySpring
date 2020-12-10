package ru.converterProject.models;

import org.springframework.stereotype.Component;
import ru.converterProject.models.enums.WeightEnum;

@Component
public class WeightConverter {
    public String convert(String weightFrom, String weightTo, String value){
        WeightEnum firstWeightParam = WeightEnum.getEnumValueByName(weightFrom);
        WeightEnum secondWeightParam = WeightEnum.getEnumValueByName(weightTo);
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
        return "" + String.format ("%f", count(inputValue, firstWeightParam, secondWeightParam));

    }

    private static double count (double value, WeightEnum firstWeightParam, WeightEnum secondWeightParam){
        return value * (firstWeightParam.getVALUE_IN_KILOGRAM()/secondWeightParam.getVALUE_IN_KILOGRAM());
    }
}
