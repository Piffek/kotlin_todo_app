package com.piffek.todoapp.services

import com.piffek.todoapp.persistance.task.Task
import com.piffek.todoapp.persistance.task.TaskRepository
import org.springframework.stereotype.Service

@Service
class TaskService(private val taskRepository: TaskRepository) {

    fun findAll(): MutableList<Task> {
        return taskRepository.findAll();
    }
}