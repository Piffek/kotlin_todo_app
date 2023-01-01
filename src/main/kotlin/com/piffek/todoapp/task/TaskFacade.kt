package com.piffek.todoapp.task

import com.piffek.todoapp.subtask.persistance.SubtaskRepository
import com.piffek.todoapp.subtask.persistance.entity.SubtaskSnapshot
import com.piffek.todoapp.task.persistance.TaskRepository
import com.piffek.todoapp.task.persistance.entity.TaskSnapshot
import java.util.UUID
import org.springframework.stereotype.Service

@Service
class TaskFacade(
    private val taskRepository: TaskRepository,
    private val subtaskRepository: SubtaskRepository
) {
    fun findAll(): MutableList<TaskSnapshot> = taskRepository.findAll()

    fun findSubtasksForTask(taskId: UUID): MutableList<SubtaskSnapshot> =
        subtaskRepository.findByTaskId(taskId)
}