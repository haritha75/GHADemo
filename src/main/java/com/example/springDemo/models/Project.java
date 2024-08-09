package com.example.springDemo.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long project_id;
    @Column(name="project_name")
    private String project_name;
    @Column(name="project_desc")
    private String project_desc;
    @OneToMany(mappedBy = "project" , cascade = CascadeType.ALL)
    private Set<Task> tasks;

    public Project(){

    }

    public Project(long project_id, String project_name, String project_desc, Set<Task> tasks) {
        this.project_id = project_id;
        this.project_name = project_name;
        this.project_desc = project_desc;
        this.tasks = tasks;
    }

    public long getProject_id() {
        return project_id;
    }

    public void setProject_id(long project_id) {
        this.project_id = project_id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getProject_desc() {
        return project_desc;
    }

    public void setProject_desc(String project_desc) {
        this.project_desc = project_desc;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }
}
