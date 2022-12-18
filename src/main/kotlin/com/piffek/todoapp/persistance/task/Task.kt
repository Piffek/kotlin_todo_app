package com.piffek.todoapp.persistance.task

import com.piffek.todoapp.persistance.subtask.Subtask
import java.util.UUID
import org.hibernate.annotations.Type
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "TASK")
data class Task(
    @Id
    @Type(type = "pg-uuid")
    val id: UUID,

    val name: String,
    val rejected: Boolean,

    @OneToMany(mappedBy = "taskId", fetch = FetchType.EAGER)
    val subtasks: Set<Subtask>
)