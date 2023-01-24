package com.piffek.todoapp.task.application

import com.piffek.todoapp.task.domain.TaskDto
import com.piffek.todoapp.task.persistance.TaskRepository
import com.piffek.todoapp.task.TaskFacade
import com.piffek.todoapp.task.persistance.entity.TaskSnapshot
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class TaskFacadeImpl(
    private val taskRepository: TaskRepository) : TaskFacade {
    override fun findAll(): List<TaskSnapshot> = taskRepository.findAll()

    override fun create(task: TaskDto) {
        val taskSnapshot = TaskSnapshot(task.id, task.name, task.rejected, emptySet())
        taskRepository.save(taskSnapshot)
    }
}