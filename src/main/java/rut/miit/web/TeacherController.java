package rut.miit.web;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import rut.miit.dto.AddTeacherDto;

import rut.miit.services.TeacherService;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/add")
    public String addTeacher() {
        return "teacher-add";
    }

    @ModelAttribute("teacherModel")
    public AddTeacherDto initCourse() {
        return new AddTeacherDto();
    }

    @PostMapping("/add")
    public String addTeacher(@Valid AddTeacherDto teacherModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("teacherModel", teacherModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.lessonModel",
                    bindingResult);
            return "redirect:/teachers/add";
        }
        teacherService.addTeacher(teacherModel);

        return "redirect:/teachers/all";
    }

    @GetMapping("/all")
    public String showAllTeacher(Model model) {
        model.addAttribute("teachersInfos", teacherService.allTeachers());
        return "teachers-all";
    }

    @GetMapping("/teacher-delete/{teacher-number}")
    public String deleteTeacher(
            @PathVariable("teacher-number") String teacherNumber) {
        teacherService.removeTeacher(teacherNumber);
        return "redirect:/teachers/all";
    }
}