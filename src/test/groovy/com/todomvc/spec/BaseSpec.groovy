package com.todomvc.spec

import com.codeborne.selenide.Configuration
import com.todomvc.pages.TodoMvcPage
import spock.lang.Specification

import static com.codeborne.selenide.Selenide.closeWebDriver

class BaseSpec extends Specification {
    protected TodoMvcPage todoMvcPage

    static {
        Configuration.timeout = 8_000
    }

    def setup() {
        todoMvcPage = new TodoMvcPage().open()
    }

    def cleanup(){
        closeWebDriver()
    }
}
