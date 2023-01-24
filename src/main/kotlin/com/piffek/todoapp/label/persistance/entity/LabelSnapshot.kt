package com.piffek.todoapp.label.persistance.entity

import com.piffek.todoapp.label.domain.LabelColor
import java.util.UUID
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.Id
import org.hibernate.annotations.Type

data class LabelSnapshot(
    @Id
    @Type(type = "pg-uuid")
    val id: UUID,
    val name: String,
    @Enumerated(EnumType.STRING)
    val color: LabelColor
)
