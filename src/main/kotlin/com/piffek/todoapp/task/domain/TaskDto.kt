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
        override fun from(tasks: MutableList<TaskSnapshot>): List<TaskDto> =
            tasks.map { from(it) }.toList()

        override fun from(task: TaskSnapshot) =
            TaskDto(
                task.id,
                task.name,
                task.rejected,
                SubtaskDto.from(task.subtasks)
            )
    }
}