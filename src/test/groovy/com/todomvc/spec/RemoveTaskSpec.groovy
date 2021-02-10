package com.todomvc.spec

import spock.lang.Unroll

import static com.codeborne.selenide.Condition.disappear

@Unroll
class RemoveTaskSpec extends BaseSpec {

    def 'task should be removed'() {
        given: 'task is added to the list'
        String taskName = 'Task to delete'
        todoMvcPage.addTask(taskName)
                .assertTasksAmount(1)

        when: ' task is removed from list'
        todoMvcPage.removeTask()

        then: 'list of tasks is empty'
        todoMvcPage.tasksListIs(disappear)
    }

    def '#tasksAmountToComplete completed task(s) should be removed (from all three tasks)'() {
        given: 'three tasks are added to the list'
        List<String> tasksName = ['task 1', 'task 2', 'task 3']
        int tasksAmount = tasksName.size()
        todoMvcPage.addTasks(tasksName)
                .assertTasksAmount(tasksAmount)

        and: '#tasksAmountToComplete tasks are marked as completed'
        todoMvcPage.markTasksAsCompleted(tasksAmountToComplete)
                .assertLeftTasksAmount(tasksLeftAmount)

        when: 'completed tasks are removed'
        todoMvcPage.removeCompletedTasks()

        then: '#tasksLeftAmount is/are left'
        todoMvcPage.assertLeftTasksAmount(tasksLeftAmount)

        where:
        tasksAmountToComplete | tasksLeftAmount
        1                     | 2
        2                     | 1
    }

    def 'all three completed tasks should be removed'() {
        given: 'three tasks are added to the list'
        List<String> tasksName = ['task 1', 'task 2', 'task 3']
        int tasksAmount = tasksName.size()
        todoMvcPage.addTasks(tasksName)
                .assertTasksAmount(tasksAmount)

        and: 'all tasks are marked as completed'
        todoMvcPage.markTasksAsCompleted(tasksAmount)
                .assertLeftTasksAmount(0)

        when: 'completed tasks are removed'
        todoMvcPage.removeCompletedTasks()

        then: 'list of tasks is empty'
        todoMvcPage.tasksListIs(disappear)
    }
}
