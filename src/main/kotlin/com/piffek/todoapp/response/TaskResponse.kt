package com.piffek.todoapp.response

import com.piffek.todoapp.persistance.task.Task

data class TaskResponse(
    val id: Long,
    val name: String,
    val rejected: Boolean,
    val subtasks: Set<SubtaskResponse>
) {
    object ModelMapper {
        fun from(task: Task) =
            TaskResponse(
                task.id,
                task.name,
                task.rejected,
                SubtaskResponse.ModelMapper.from(task.subtasks)
            )

        fun from(tasks: MutableList<Task>): MutableList<TaskResponse> =
            tasks.map { from(it) }.toMutableList()
    }
}