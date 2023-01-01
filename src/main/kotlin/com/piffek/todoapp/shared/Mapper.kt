package com.piffek.todoapp.shared

interface Mapper<IN, OUT> {
    fun from(input: IN): OUT
    fun from(inputMap: MutableList<IN>): List<OUT>
}