package com.piffek.todoapp.rest

import com.piffek.todoapp.subtask.SubtaskFacade
import com.piffek.todoapp.subtask.domain.SubtaskDto
import java.util.UUID
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class SubtaskController(private val subtaskFacade: SubtaskFacade) {
    @GetMapping("/subtasks/{taskId}")
    fun showAllSubtaskAssignedToTask(@PathVariable("taskId") taskId: UUID): List<SubtaskDto> =
        SubtaskDto.from(subtaskFacade.findSubtasksForTask(taskId))
}