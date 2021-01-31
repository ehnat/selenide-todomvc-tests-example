package com.todomvc.spec

import spock.lang.Unroll

@Unroll
class ModifyTaskSpec extends BaseSpec {

    def 'task should be modified'() {
        given: 'task is added to the list'
        String taskName = 'Task to modify'
        String modifiedName = ' (modified)'

        todoMvcPage.addTask(taskName)
                .assertTasksAmount(1)

        when: 'task is modifying by adding new part to the task name'
        todoMvcPage.modifyTaskByAdding(modifiedName)

        then: 'modified task name is visible on the list'
        todoMvcPage.assertTasksAmount(1)
                .assertTaskIsAdded("$taskName$modifiedName")
    }

    def 'task should be marked as completed'() {
        given: 'task is added to the list'
        String taskName = 'Task to complete'

        todoMvcPage.addTask(taskName)
                .assertTasksAmount(1)

        when: 'task is marked as completed'
        todoMvcPage.markTaskAsCompleted()

        then: 'any task stays uncompleted'
        todoMvcPage.assertTasksAmount(1)
                .assertLeftTasksAmount(0)
    }

    def '#tasksAmountToComplete tasks should be marked as completed (from all four tasks)'() {
        given: 'four tasks are added to the list'
        List<String> tasksName = ['task 1', 'task 2', 'task 3', 'task 4']
        int tasksAmount = tasksName.size()
        todoMvcPage.addTasks(tasksName)
                .assertTasksAmount(tasksAmount)

        when: '#tasksAmountToComplete tasks are marked as completed'
        todoMvcPage.markTasksAsCompleted(tasksAmountToComplete)

        then: '#tasksAmountToComplete tasks are completed, #tasksLeftAmount in uncompleted'
        todoMvcPage.assertTasksAmount(tasksAmount)
                .assertLeftTasksAmount(tasksLeftAmount)

        where:
        tasksAmountToComplete | tasksLeftAmount
        4                     | 0
        3                     | 1
    }
}
