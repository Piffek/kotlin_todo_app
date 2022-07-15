package com.piffek.todoapp.services

import com.piffek.todoapp.persistance.subtask.Subtask
import com.piffek.todoapp.persistance.subtask.SubtaskRepository
import com.piffek.todoapp.persistance.task.Task
import com.piffek.todoapp.persistance.task.TaskRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class TaskService(
    private val taskRepository: TaskRepository,
    private val subtaskRepository: SubtaskRepository
) {

    fun findAll(): MutableList<Task> = taskRepository.findAll()

    fun findSubtasksForTask(taskId: UUID): MutableList<Subtask> =
        subtaskRepository.findByTaskId(taskId)
}