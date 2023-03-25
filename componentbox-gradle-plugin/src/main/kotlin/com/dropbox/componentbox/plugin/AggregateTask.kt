package com.dropbox.componentbox.plugin

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.TaskProvider

open class AggregateTask : DefaultTask() {
    @Input
    var taskList: List<TaskProvider<out DefaultTask>>? = null
    @TaskAction
    fun aggregate() {
        taskList?.forEach { taskProvider ->
            val task = taskProvider.get()
            task.actions.forEach { action ->
                action.execute(task)
            }
        }
    }
}