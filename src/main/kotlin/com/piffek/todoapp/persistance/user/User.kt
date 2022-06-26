package com.piffek.todoapp.persistance.user

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?=null

    @Column
    val name: String?=null
}