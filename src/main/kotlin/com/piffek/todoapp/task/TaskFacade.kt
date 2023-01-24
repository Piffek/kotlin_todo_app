package com.piffek.todoapp.task

import com.piffek.todoapp.task.domain.TaskDto
import com.piffek.todoapp.task.persistance.entity.TaskSnapshot

interface TaskFacade {
    fun findAll(): List<TaskSnapshot>
    fun create(task: TaskDto)
}