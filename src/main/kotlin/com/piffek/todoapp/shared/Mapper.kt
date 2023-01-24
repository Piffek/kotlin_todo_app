package com.piffek.todoapp.shared

interface Mapper<IN, OUT> {
    fun from(input: IN): OUT
    fun from(inputList: List<IN>): List<OUT>
}