package com.piffek.todoapp.subtask.application

import com.piffek.todoapp.subtask.SubtaskFacade
import com.piffek.todoapp.subtask.persistance.SubtaskRepository
import com.piffek.todoapp.subtask.persistance.entity.SubtaskSnapshot
import java.util.UUID
import javax.transaction.Transactional
import org.springframework.stereotype.Service

@Service
@Transactional
class SubtaskFacadeImpl(private val subtaskRepository: SubtaskRepository) : SubtaskFacade {
    override fun findSubtasksForTask(taskId: UUID): List<SubtaskSnapshot> =
        subtaskRepository.findByTaskId(taskId)
}