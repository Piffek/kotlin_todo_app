package com.piffek.todoapp.response

import com.piffek.todoapp.persistance.subtask.Subtask
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.HashSet

data class SubtaskResponse(
    val id: UUID,
    val titie: String,
    val description: String,
    val deadline: LocalDateTime,
    val rememberHours: Int,
    val done: Boolean,
    val rejected: Boolean,
) {
    companion object : Mapper<Subtask, SubtaskResponse> {
        fun from(subtasks: Set<Subtask>): Set<SubtaskResponse> =
            subtasks.mapTo(HashSet()) { from(it) }

        override fun from(subtasks: MutableList<Subtask>): MutableList<SubtaskResponse> =
            subtasks.map { from(it) }.toMutableList()

        override fun from(subtask: Subtask): SubtaskResponse =
            SubtaskResponse(
                subtask.id,
                subtask.titie,
                subtask.description,
                subtask.deadline,
                subtask.rememberHours,
                subtask.done,
                subtask.rejected,
            )
    }
}