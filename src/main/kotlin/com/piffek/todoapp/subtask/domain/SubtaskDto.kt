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

        override fun from(inputList: List<SubtaskSnapshot>): List<SubtaskDto> =
            inputList.map { from(it) }.toMutableList()

        override fun from(input: SubtaskSnapshot): SubtaskDto =
            SubtaskDto(
                input.id,
                input.title,
                input.description,
                input.deadline,
                input.rememberHours,
                input.done,
                input.rejected,
            )
    }
}