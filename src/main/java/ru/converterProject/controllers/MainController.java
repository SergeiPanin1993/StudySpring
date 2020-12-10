package ru.converterProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.converterProject.models.LengthConverter;
import ru.converterProject.models.VolumeConverter;
import ru.converterProject.models.WeightConverter;
import ru.converterProject.models.enums.LengthEnum;
import ru.converterProject.models.enums.WeightEnum;
import ru.converterProject.models.enums.VolumeEnum;

@Controller
@RequestMapping("/")
public class MainController {

    private final LengthConverter lengthConverter;
    private final WeightConverter weightConverter;
    private final VolumeConverter volumeConverter;

    @Autowired
    public MainController(LengthConverter lengthConverter, WeightConverter weightConverter, VolumeConverter volumeConverter){
        this.lengthConverter = lengthConverter;
        this.weightConverter = weightConverter;
        this.volumeConverter = volumeConverter;
    }

    @GetMapping()
    public String mainPage(Model model){
        addGeneralAttributes(model);
        return "mainPage";
    }

    @PostMapping("/length")
    public String getLengthAnswer(Model model, @RequestParam("firstLengthParam") String lengthEnumFirst,
                                  @RequestParam("secondLengthParam") String lengthEnumSecond,
                                  @RequestParam("inputLengthValue") String lengthInputValue){
        addGeneralAttributes(model);
        model.addAttribute("lengthAnswerParamFirst", lengthEnumFirst);
        model.addAttribute("lengthAnswerValueFirst", lengthInputValue);
        model.addAttribute("lengthEqually","=");
        model.addAttribute("lengthAnswerParamSecond", lengthEnumSecond);
        model.addAttribute("lengthAnswerValueSecond", lengthConverter.convert(lengthEnumFirst, lengthEnumSecond, lengthInputValue));
        return "mainPage";
    }

    @PostMapping("/weight")
    public String getWeightAnswer(Model model, @RequestParam("firstWeightParam") String weightEnumFirst,
                                  @RequestParam("secondWeightParam") String weightEnumSecond,
                                  @RequestParam("inputWeightValue") String weightInputValue){
        addGeneralAttributes(model);
        model.addAttribute("weightAnswerParamFirst", weightEnumFirst);
        model.addAttribute("weightAnswerValueFirst", weightInputValue);
        model.addAttribute("weightEqually","=");
        model.addAttribute("weightAnswerParamSecond", weightEnumSecond);
        model.addAttribute("weightAnswerValueSecond", weightConverter.convert(weightEnumFirst, weightEnumSecond, weightInputValue));
        return "mainPage";
    }

    @PostMapping("/volume")
    public String getVolumeAnswer(Model model, @RequestParam("firstVolumeParam") String volumeEnumFirst,
                                  @RequestParam("secondVolumeParam") String volumeEnumSecond,
                                  @RequestParam("inputVolumeValue") String volumeInputValue){
        addGeneralAttributes(model);
        model.addAttribute("volumeAnswerParamFirst", volumeEnumFirst);
        model.addAttribute("volumeAnswerValueFirst", volumeInputValue);
        model.addAttribute("volumeEqually","=");
        model.addAttribute("volumeAnswerParamSecond", volumeEnumSecond);
        model.addAttribute("volumeAnswerValueSecond", volumeConverter.convert(volumeEnumFirst, volumeEnumSecond, volumeInputValue));
        return "mainPage";
    }

    private void addGeneralAttributes(Model model){
        model.addAttribute("lengthValues", LengthEnum.getVALUES());
        model.addAttribute("weightValues", WeightEnum.getVALUES());
        model.addAttribute("volumeValues", VolumeEnum.getVALUES());
    }

    @GetMapping("/about")
    public String about(Model model){
        return "about";
    }

    @GetMapping("/darthVader")
    public String darthVader(Model model){
        return "darthVader";
    }

}
