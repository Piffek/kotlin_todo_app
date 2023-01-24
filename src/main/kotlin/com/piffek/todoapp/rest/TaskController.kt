package com.piffek.todoapp.rest

import com.piffek.todoapp.task.TaskFacade
import com.piffek.todoapp.task.domain.TaskDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody

@RestController("/task")
class TaskController(private val taskFacade: TaskFacade) {

    @GetMapping
    fun showAll(): List<TaskDto> = TaskDto.from(taskFacade.findAll())

    @PutMapping("/create")
    fun create(@RequestBody task: TaskDto) = taskFacade.create(task)
}