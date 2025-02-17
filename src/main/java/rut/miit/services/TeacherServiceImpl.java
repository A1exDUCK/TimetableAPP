package rut.miit.services;

import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;
import rut.miit.dto.AddTeacherDto;
import rut.miit.dto.ShowTeacherDto;
import rut.miit.models.entities.Teacher;
import rut.miit.repositories.TeacherRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@EnableCaching
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final ModelMapper mapper;

    public TeacherServiceImpl(TeacherRepository teacherRepository, ModelMapper mapper) {
        this.teacherRepository = teacherRepository;
        this.mapper = mapper;
    }

    @CacheEvict(cacheNames = "teachers", allEntries = true)
    public void addTeacher(AddTeacherDto addTeacherDto) {
        teacherRepository.saveAndFlush(mapper.map(addTeacherDto, Teacher.class));
    }

    @Cacheable("teachers")
    public List<ShowTeacherDto> allTeachers() {
        return teacherRepository.findAll().stream().map(teacher -> mapper.map(teacher, ShowTeacherDto.class))
                .collect(Collectors.toList());
    }

    @CacheEvict(cacheNames = "teachers", allEntries = true)
    public void removeTeacher(String teacherNumber) {
        teacherRepository.deleteByTeacherNumber(teacherNumber);
    }
}