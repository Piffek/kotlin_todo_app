package com.piffek.todoapp.persistance.task

import com.fasterxml.jackson.annotation.JsonManagedReference
import com.piffek.todoapp.persistance.subtask.Subtask
import javax.persistence.*

@Entity
@Table(name = "TASK")
data class Task(
    @Id
    @GeneratedValue
    @Column(name = "id")
    val id: Long,

    @Column(name = "name")
    val name: String,

    @Column(name = "rejected")
    val rejected: Boolean,

    @OneToMany(mappedBy = "taskId", fetch = FetchType.EAGER)
    val subtasks: Set<Subtask>
)