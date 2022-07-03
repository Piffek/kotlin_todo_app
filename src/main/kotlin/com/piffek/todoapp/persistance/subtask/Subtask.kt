package com.piffek.todoapp.persistance.subtask

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "SUBTASK")
@SecondaryTable(
    name = "SUBTASK_DESCRIPTION",
    pkJoinColumns = [PrimaryKeyJoinColumn(
        name = "subtask_id",
        referencedColumnName = "id"
    )]
)
data class Subtask(
    @Id
    @GeneratedValue
    @Column(name = "id")
    val id: Long,

    @Column(name = "title")
    val titie: String,

    @Column(table = "SUBTASK_DESCRIPTION")
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
    val taskId: Long
)
