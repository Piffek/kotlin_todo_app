package com.piffek.todoapp.controllers

import com.piffek.todoapp.persistance.task.Task
import com.piffek.todoapp.services.TaskService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TaskController(private val taskService: TaskService) {

    @GetMapping
    fun showAll(): MutableList<Task> {
        return taskService.findAll();
    }
}