package com.example.springDemo.controllers;

import com.example.springDemo.models.Project;
import com.example.springDemo.models.Task;
import com.example.springDemo.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project project){
        return new ResponseEntity<>(projectService.createProject(project),HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Project>> getProjectDetails(){
        return new ResponseEntity<>(projectService.getProjectDetails(), HttpStatus.OK);

    }
    @GetMapping("/{project_id}")
    public ResponseEntity<Project> getTaskById(@PathVariable Long project_id){
        return new ResponseEntity<>(projectService.getProjectId(project_id).get(),HttpStatus.OK);
    }

    @PutMapping("/{project_id}")
    public ResponseEntity<Project> updateProjectById(@RequestBody Project project,@PathVariable Long  project_id){
        return new ResponseEntity<>(projectService.updateProject(project),HttpStatus.OK);

    }
    @DeleteMapping("/{project_id}")
    public ResponseEntity<Project> deleteProjectById(@PathVariable Long project_id){
        return new ResponseEntity<>(projectService.deleteProject(project_id),HttpStatus.OK);
    }
    @GetMapping("/{project_id}/tasks")
    public ResponseEntity<Set<Task>> getTaskByProjectId(@PathVariable Long project_id){
        return new ResponseEntity<>(projectService.getTasksByProjectId(project_id),HttpStatus.OK);
    }

}
