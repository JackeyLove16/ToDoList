package com.example.todolist.services;

import com.example.todolist.model.Task;
import com.example.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task taskName){

        return taskRepository.save(taskName);
    }

    public List<Task> getAllTask(){
        return taskRepository.findAll();
    }
    public List<Task> findAllCompletedTask(){
        return taskRepository.findByCompletedTrue();
    }
    public List<Task> findAllIncompleteTask(){
        return taskRepository.findByCompletedFalse();
    }
    public Task updateTask(Task task){
        return taskRepository.save(task);
    }
    public void deleteTaskByID(Long id){
        taskRepository.deleteById(id);
    }
    public void deleteAllTask(){
        taskRepository.deleteAll();
    }

}
