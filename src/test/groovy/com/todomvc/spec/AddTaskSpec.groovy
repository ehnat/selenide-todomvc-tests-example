package com.todomvc.spec

class AddTaskSpec extends BaseSpec {

    def 'task should be added to the list'() {
        given: 'Task name'
        String taskName = 'Task 1'
        when: 'task is added to the list'
        todoMvcPage.addTask(taskName)

        then: 'task is visible on list of tasks'
        todoMvcPage.assertTasksAmount(1)
                .assertTaskIsAdded(taskName)
                .assertLeftTasksAmount(1)
    }

    def 'tasks should be added to the list'() {
        given: 'Task names'
        List<String> tasksName = ['Task 1', 'Task 2']

        when: 'task is added to the list'
        todoMvcPage.addTasks(tasksName)

        then: 'task is visible on list of tasks'
        todoMvcPage.assertTasksAmount(tasksName.size())
                .assertLeftTasksAmount(tasksName.size())
    }
}
