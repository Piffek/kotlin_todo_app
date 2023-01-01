package com.piffek.todoapp.rest

import com.piffek.todoapp.subtask.domain.SubtaskDto
import com.piffek.todoapp.task.TaskFacade
import com.piffek.todoapp.task.domain.TaskDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class TaskController(private val taskFacade: TaskFacade) {

    @GetMapping
    fun showAll(): List<TaskDto> =
        TaskDto.from(taskFacade.findAll())

    @GetMapping("/subtasks/{taskId}")
    fun showAllSubtaskAssignedToTask(@PathVariable("taskId") taskId: UUID): List<SubtaskDto> =
        SubtaskDto.from(taskFacade.findSubtasksForTask(taskId))
}