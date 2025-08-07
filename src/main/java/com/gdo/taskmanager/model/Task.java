package com.gdo.taskmanager.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("tasks")
public class Task{

    @Id
    private String id;
    private String title;
    private String description;
    private TaskPriority priority;
    private TaskStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime dueDate;
    private String assignedUserId;

    public Task(){
       this.createdAt=LocalDateTime.now();
    }
    public Task(String title, String description, TaskPriority priority, TaskStatus status, LocalDateTime dueDate) {
        this.title=title;
        this.description=description;
        this.priority=priority != null ? priority : TaskPriority.MEDIUM;
        this.status= status != null ? status : TaskStatus.TODO ;
        this.createdAt=LocalDateTime.now();
        this.dueDate= dueDate != null ? dueDate : createdAt;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }
}
enum TaskStatus{
    TODO,INPROGRESS,COMPLETED
}

enum TaskPriority{
    HIGH,MEDIUM,LOW
}
