package com.piffek.todoapp.persistance.subtask

import org.hibernate.annotations.Type
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "SUBTASK")
data class Subtask(
    @Id
    @Type(type = "pg-uuid")
    val id: UUID,

    @Column(name = "title")
    val titie: String,

    @Column(name = "description")
    val description: String,

    @Column(name = "deadline")
    val deadline: LocalDateTime,

    @Column(name = "rememberTime")
    val rememberHours: Int,

    @Column(name = "done")
    val done: Boolean,

    @Column(name = "rejected")
    val rejected: Boolean,

    @Column(name = "taskId")
    val taskId: UUID
)
