package com.piffek.todoapp.response

import com.piffek.todoapp.persistance.task.Task
import java.util.*

data class TaskResponse(
    val id: UUID,
    val name: String,
    val rejected: Boolean,
    val subtasks: Set<SubtaskResponse>
) {
    companion object : Mapper<Task, TaskResponse> {
        override fun from(tasks: MutableList<Task>): MutableList<TaskResponse> =
            tasks.map { from(it) }.toMutableList()

        override fun from(task: Task) =
            TaskResponse(
                task.id,
                task.name,
                task.rejected,
                SubtaskResponse.from(task.subtasks)
            )
    }
}