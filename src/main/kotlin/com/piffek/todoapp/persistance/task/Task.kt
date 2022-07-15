package com.piffek.todoapp.persistance.task

import com.fasterxml.jackson.annotation.JsonManagedReference
import com.piffek.todoapp.persistance.subtask.Subtask
import org.hibernate.annotations.Type
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "TASK")
data class Task(
    @Id
    @Type(type = "pg-uuid")
    val id: UUID,

    @Column(name = "name")
    val name: String,

    @Column(name = "rejected")
    val rejected: Boolean,

    @OneToMany(mappedBy = "taskId", fetch = FetchType.EAGER)
    val subtasks: Set<Subtask>
)