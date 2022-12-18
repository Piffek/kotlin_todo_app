package com.piffek.todoapp.persistance.subtask

import org.hibernate.annotations.Type
import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "SUBTASK")
data class Subtask(
    @Id
    @Type(type = "pg-uuid")
    val id: UUID,

    @Column(name = "rememberTime")
    val rememberHours: Int,

    val titie: String,
    val description: String,
    val deadline: LocalDateTime,
    val done: Boolean,
    val rejected: Boolean,
    val taskId: UUID
)
