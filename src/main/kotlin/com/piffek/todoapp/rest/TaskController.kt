package com.piffek.todoapp.rest

import com.piffek.todoapp.response.SubtaskResponse
import com.piffek.todoapp.response.TaskResponse
import com.piffek.todoapp.services.TaskService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.UUID;

@RestController
class TaskController(private val taskService: TaskService) {

    @GetMapping
    fun showAll(): List<TaskResponse> =
        TaskResponse.from(taskService.findAll())

    @GetMapping("/subtasks/{taskId}")
    fun showAllSubtaskAssignedToTask(@PathVariable("taskId") taskId: UUID): List<SubtaskResponse> =
        SubtaskResponse.from(taskService.findSubtasksForTask(taskId))
}