package com.piffek.todoapp.persistance.subtask

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface SubtaskRepository : JpaRepository<Subtask, UUID> {
    fun findByTaskId(taskId: UUID): MutableList<Subtask>
}