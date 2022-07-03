package com.piffek.todoapp.controllers

import com.piffek.todoapp.persistance.subtask.Subtask
import com.piffek.todoapp.persistance.task.Task
import com.piffek.todoapp.services.TaskService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import javax.persistence.Id

@RestController
class TaskController(private val taskService: TaskService) {

    @GetMapping
    fun showAll(): MutableList<Task> =
        taskService.findAll()

    @GetMapping("/subtasks/{taskId}")
    fun showAllSubtaskAssignedToTask(@PathVariable("taskId") taskId: Long): MutableList<Subtask> =
        taskService.findSubtasksForTask(taskId)
}