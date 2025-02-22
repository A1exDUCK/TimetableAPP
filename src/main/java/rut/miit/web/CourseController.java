package rut.miit.web;

import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import rut.miit.dto.AddCourseDto;
import rut.miit.dto.ShowCourseDto;
import rut.miit.services.CourseService;
import rut.miit.services.TeacherService;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private final CourseService courseService;
    @Autowired
    private final TeacherService teacherService;

    public CourseController(CourseService courseService, TeacherService teacherService) {
        this.courseService = courseService;
        this.teacherService = teacherService;
    }

    @GetMapping("/add")
    public String addCourse(Model model) {
        model.addAttribute("availableTeachers", teacherService.allTeachers());
        return "course-add";
    }

    @ModelAttribute("courseModel")
    public AddCourseDto initCourse() {
        return new AddCourseDto();
    }

    @PostMapping("/add")
    public String addCourse(@Valid AddCourseDto courseModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("courseModel", courseModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.lessonModel",
                    bindingResult);
            return "redirect:/courses/add";
        }
        courseService.addCourse(courseModel);

        return "redirect:/courses/all";
    }

    @GetMapping("/all")
    public String showAllCourses(Model model) {
        List<ShowCourseDto> courses = courseService.allCourses();
        System.out.println("Courses sent to view: " + courses.size());
        model.addAttribute("coursesInfos", courses);
        return "courses-all";
    }

    @GetMapping("/course-delete/{id}")
    public String deleteCourse(
            @PathVariable("id") String id) {
        courseService.removeCourse(id);
        return "redirect:/courses/all";
    }
}