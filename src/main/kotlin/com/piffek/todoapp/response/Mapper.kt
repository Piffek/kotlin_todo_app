package com.piffek.todoapp.response

interface Mapper<IN, OUT> {
    fun from(input: IN): OUT
    fun from(inputMap: MutableList<IN>): MutableList<OUT>
}