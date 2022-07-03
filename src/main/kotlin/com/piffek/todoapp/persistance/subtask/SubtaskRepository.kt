package com.piffek.todoapp.persistance.subtask

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SubtaskRepository : JpaRepository<Subtask, Long> {
    fun findByTaskId(taskId: Long): MutableList<Subtask>
}