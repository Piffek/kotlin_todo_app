package com.piffek.todoapp.rest

import com.piffek.todoapp.subtask.SubtaskFacade
import com.piffek.todoapp.subtask.domain.SubtaskDto
import java.util.UUID
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/rest-api/subtask")
class SubtaskRestService(private val subtaskFacade: SubtaskFacade) {
    @GetMapping("/all/{taskId}")
    fun showAllSubtaskAssignedToTask(@PathVariable("taskId") taskId: UUID): List<SubtaskDto> =
        SubtaskDto.from(subtaskFacade.findSubtasksForTask(taskId))
}