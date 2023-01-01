package com.piffek.todoapp.subtask.domain

import com.piffek.todoapp.shared.Mapper
import com.piffek.todoapp.subtask.persistance.entity.SubtaskSnapshot
import java.time.LocalDateTime
import java.util.UUID
import kotlin.collections.HashSet

data class SubtaskDto(
    val id: UUID,
    val titie: String,
    val description: String,
    val deadline: LocalDateTime,
    val rememberHours: Int,
    val done: Boolean,
    val rejected: Boolean,
) {
    companion object : Mapper<SubtaskSnapshot, SubtaskDto> {
        fun from(subtasks: Set<SubtaskSnapshot>): Set<SubtaskDto> =
            subtasks.mapTo(HashSet()) { from(it) }

        override fun from(subtasks: MutableList<SubtaskSnapshot>): List<SubtaskDto> =
            subtasks.map { from(it) }.toMutableList()

        override fun from(subtask: SubtaskSnapshot): SubtaskDto =
            SubtaskDto(
                subtask.id,
                subtask.title,
                subtask.description,
                subtask.deadline,
                subtask.rememberHours,
                subtask.done,
                subtask.rejected,
            )
    }
}