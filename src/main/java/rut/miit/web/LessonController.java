package rut.miit.web;


import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import rut.miit.dto.AddLessonDto;
import rut.miit.services.LessonService;

import java.time.LocalDate;


@Controller
@RequestMapping("/specialities")
public class LessonController {

    @Autowired
    private final LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping("/add")
    public String addLesson() {
        return "lesson-add";
    }

    @ModelAttribute("lessonModel")
    public AddLessonDto initLesson() {
        return new AddLessonDto();
    }

    @PostMapping("/add")
    public String addLesson(@Valid AddLessonDto lessonModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("lessonModel", lessonModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.lessonModel",
                    bindingResult);
            return "redirect:/lessons/add";
        }
        lessonService.addLesson(lessonModel);

        return "redirect:/lessons/all";
    }

    @GetMapping("/all")
    public String showAllLessons(Model model) {
        model.addAttribute("lessonsInfos", lessonService.allLessons());
        return "lessons-all";
    }

    @GetMapping("/lesson-delete/{date}/{selectedPair}/{classroom}")
    public String deleteLesson(
            @PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @PathVariable("selectedPair") String selectedPair,
            @PathVariable("classroom") String classroom
    ) {
        lessonService.removeLesson(date, selectedPair, classroom);
        return "redirect:/lessons/all"; // Перенаправление на список уроков
    }
}
