package ru.converterProject.models;

import org.springframework.stereotype.Component;
import ru.converterProject.models.enums.VolumeEnum;

@Component
public class VolumeConverter {
    public String convert(String volumeFrom, String volumeTo, String volumeValue){
        VolumeEnum firstVolumeParam = VolumeEnum.getEnumValueByName(volumeFrom);
        VolumeEnum secondVolumeParam = VolumeEnum.getEnumValueByName(volumeTo);
        double inputValue = 0.0;
        try {
            inputValue = Double.parseDouble(volumeValue);
        }catch (NumberFormatException e){
            //log exception
            return "Wrong enter value";
        }catch (NullPointerException e){
            //log exception
            return "Wrong enter value";
        }
        double resultValue = count(inputValue, firstVolumeParam, secondVolumeParam);
        return "" + String.format ("%f", resultValue);
    }
    private static double count (double value, VolumeEnum firstVolumeParam, VolumeEnum secondVolumeParam){
        return value * (firstVolumeParam.getVALUE_IN_LITER()/secondVolumeParam.getVALUE_IN_LITER());
    }
}
