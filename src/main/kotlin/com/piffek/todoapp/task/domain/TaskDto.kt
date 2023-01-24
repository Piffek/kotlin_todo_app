package com.piffek.todoapp.task.domain

import com.piffek.todoapp.shared.Mapper
import com.piffek.todoapp.subtask.domain.SubtaskDto
import com.piffek.todoapp.task.persistance.entity.TaskSnapshot
import java.util.UUID

data class TaskDto(
    val id: UUID,
    val name: String,
    val rejected: Boolean,
    val subtasks: Set<SubtaskDto>
) {
    companion object : Mapper<TaskSnapshot, TaskDto> {
        override fun from(inputList: List<TaskSnapshot>): List<TaskDto> =
            inputList.map { from(it) }.toList()

        override fun from(input: TaskSnapshot) =
            TaskDto(
                input.id,
                input.name,
                input.rejected,
                SubtaskDto.from(input.subtasks)
            )
    }
}