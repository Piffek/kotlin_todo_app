package com.piffek.todoapp.subtask

import com.piffek.todoapp.subtask.persistance.entity.SubtaskSnapshot
import java.util.*

interface SubtaskFacade {
    fun findSubtasksForTask(taskId: UUID): List<SubtaskSnapshot>
}