package com.gdo.taskmanager.repository;

import com.gdo.taskmanager.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TaskRepository extends MongoRepository<Task, String> {
    List<Task> findByAssignedUserId(String userId);
}
