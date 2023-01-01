package com.piffek.todoapp.task.persistance

import com.piffek.todoapp.task.persistance.entity.TaskSnapshot
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface TaskRepository : JpaRepository<TaskSnapshot, UUID>