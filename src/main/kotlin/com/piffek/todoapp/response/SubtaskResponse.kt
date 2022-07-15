package com.piffek.todoapp.response

import com.piffek.todoapp.persistance.subtask.Subtask
import java.time.LocalDateTime

data class SubtaskResponse(
    val id: Long,
    val titie: String,
    val description: String,
    val deadline: LocalDateTime,
    val rememberHours: Int,
    val done: Boolean,
    val rejected: Boolean,
    val taskId: Long
) {
    object ModelMapper {
        fun from(subtask: Subtask): SubtaskResponse =
            SubtaskResponse(
                subtask.id,
                subtask.titie,
                subtask.description,
                subtask.deadline,
                subtask.rememberHours,
                subtask.done,
                subtask.rejected,
                subtask.taskId
            )

        fun from(subtasks: Set<Subtask>): Set<SubtaskResponse> =
            subtasks.mapTo(HashSet<SubtaskResponse>()) { from(it) }

        fun from(subtasks: MutableList<Subtask>): MutableList<SubtaskResponse> =
            subtasks.map { from(it) }.toMutableList()
    }
}