package rut.miit.web;



import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import rut.miit.dto.AddLessonDto;
import rut.miit.services.LessonService;
import rut.miit.services.CourseService;


@Controller
@RequestMapping("/lessons")
public class LessonController {

    private final LessonService lessonService;
    private final CourseService courseService;

    public LessonController(LessonService lessonService, CourseService courseService) {
        this.lessonService = lessonService;
        this.courseService = courseService;
    }

    @GetMapping("/add")
    public String addLesson(Model model) {
        model.addAttribute("availableCourses", courseService.allCourses());
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

    @GetMapping("/lesson-delete/{id}")
    public String deleteLesson(@PathVariable("id") String id) {
        lessonService.removeLesson(id);
        return "redirect:/lessons/all";
    }

}
