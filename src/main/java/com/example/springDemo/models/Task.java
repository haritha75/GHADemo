package com.example.springDemo.models;

import jakarta.persistence.*;

@Entity
@Table(name="tasks")
public class Task {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long task_id;
    @Column(name="task_name")
    private String task_name;
    @Column(name="task_desc")
    private String task_desc;
    @Column(name="percentage")
    private double percentage;

    @Column(name="project")
    private long project;

    public Task(){

    }

    public Task(long task_id, String task_name, String task_desc, double percentage, long project) {
        this.task_id = task_id;
        this.task_name = task_name;
        this.task_desc = task_desc;
        this.percentage = percentage;
        this.project = project;
    }

    public long getTask_id() {
        return task_id;
    }

    public void setTask_id(long task_id) {
        this.task_id = task_id;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getTask_desc() {
        return task_desc;
    }

    public void setTask_desc(String task_desc) {
        this.task_desc = task_desc;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public long getProject() {
        return project;
    }

    public void setProject(long project) {
        this.project = project;
    }
}
