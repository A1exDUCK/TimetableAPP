package rut.miit.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rut.miit.dto.AddCourseDto;
import rut.miit.dto.ShowCourseDto;
import rut.miit.models.entities.Course;
import rut.miit.repositories.CourseRepository;
import rut.miit.repositories.TeacherRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@EnableCaching
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    private final ModelMapper mapper;

    public CourseServiceImpl(CourseRepository courseRepository,TeacherRepository teacherRepository, ModelMapper mapper) {
        this.courseRepository = courseRepository;
        this.teacherRepository = teacherRepository;
        this.mapper = mapper;
    }

    @Transactional
    @CacheEvict(cacheNames = "courses", allEntries = true)
    public void addCourse(AddCourseDto addCourseDto) {
        Course course = mapper.map(addCourseDto, Course.class);
        course.setTeacher(teacherRepository.findByTeacherName(addCourseDto.getTeacherName()).orElse(null));
        courseRepository.saveAndFlush(course);
    }
       @Cacheable("courses")
        public List<ShowCourseDto> allCourses() {
            return courseRepository.findAll().stream().map(course -> mapper.map(course, ShowCourseDto.class))
                    .collect(Collectors.toList());
        }
        @Override
        public List<ShowCourseDto> allTeacherCourses(String teacherName) {
            return courseRepository.findAllWhatTeacherTeaches(teacherName).stream().map(course -> mapper.map(course, ShowCourseDto.class))
                    .collect(Collectors.toList());
        }

       @CacheEvict(cacheNames = "courses", allEntries = true)
        public void removeCourse(String courseName) {
            courseRepository.deleteByCourseName(courseName);
        }

    }
