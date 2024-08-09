package com.example.springDemo.services;

import com.example.springDemo.dao.ProjectRepository;
import com.example.springDemo.dao.TaskRepository;
import com.example.springDemo.models.Project;
import com.example.springDemo.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;


    public Project createProject(Project project) {
        projectRepository.save(project);
        return project;
    }

    public List<Project> getProjectDetails() {
        return projectRepository.findAll();

    }

    public Optional<Project> getProjectId(long id) {
        return projectRepository.findById(id);
    }

    public Project updateProject(Project project) {
        projectRepository.save(project);
        return project;
    }

    public Project deleteProject(long id) {
        Optional<Project> project = getProjectId(id);
        projectRepository.deleteById(id);
        return project.get();
    }
    public Set<Task> getTasksByProjectId(long projectId){
        Optional<Project> project = getProjectId(projectId);

        Set<Task> tasks = project.get().getTasks();
        return tasks;

    }

}
