package com.piffek.todoapp.subtask.persistance

import com.piffek.todoapp.subtask.persistance.entity.SubtaskSnapshot
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SubtaskRepository : JpaRepository<SubtaskSnapshot, UUID> {
    fun findByTaskId(taskId: UUID): List<SubtaskSnapshot>
}