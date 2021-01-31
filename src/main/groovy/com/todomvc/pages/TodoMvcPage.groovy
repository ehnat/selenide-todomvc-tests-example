package com.todomvc.pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.SelenideElement
import groovy.transform.CompileStatic

import java.util.stream.IntStream

import static com.codeborne.selenide.Selenide.$
import static com.codeborne.selenide.Selenide.open
import static com.todomvc.config.Config.envConfig

@CompileStatic
class TodoMvcPage {

    private final SelenideElement mainInput = $('.new-todo')
    private final SelenideElement todoList = $('.todo-list')
    private final List<SelenideElement> tasksList = todoList.$$('li')
    private final SelenideElement leftTasksAmount = $('.todo-count>strong')
    private final SelenideElement removeCompleteTasksButton = $('button.clear-completed')

    TodoMvcPage open() {
        open(new URL(envConfig.getBaseUrl()), TodoMvcPage)
    }

    TodoMvcPage addTask(String taskName) {
        mainInput.setValue(taskName)
                .pressEnter()
        this
    }

    TodoMvcPage addTasks(ArrayList<String> tasksName) {
        tasksName.forEach({ it -> addTask(it) })
        this
    }

    TodoMvcPage modifyTaskByAdding(String modifiedText) {
        tasksList[0].doubleClick()
        SelenideElement taskToModify = tasksList[0].$('input.edit')
        taskToModify.sendKeys(modifiedText)
        taskToModify.pressEnter()
        this
    }

    TodoMvcPage markTaskAsCompleted(int taskId = 0) {
        tasksList[taskId].$('input[type="checkbox"]')
                .click()
        this
    }

    TodoMvcPage markTasksAsCompleted(int tasks) {
        IntStream.range(0, tasks).forEach({
            it -> markTaskAsCompleted(it)
        })
        this
    }

    TodoMvcPage removeTask(int taskId = 0) {
        tasksList[taskId].hover()
                .$('button.destroy')
                .click()
        this
    }

    TodoMvcPage removeCompletedTasks() {
        removeCompleteTasksButton.click()
        this
    }

    TodoMvcPage assertTaskIsAdded(String taskName) {
        assert tasksList[0].text == taskName
        this
    }

    TodoMvcPage assertTasksAmount(int amount) {
        assert tasksList.size() == amount
        this
    }

    TodoMvcPage assertLeftTasksAmount(int amount) {
        assert leftTasksAmount.text == amount.toString()
        this
    }

    void tasksListIs(Condition condition) {
        todoList.shouldBe(condition)
    }
}
