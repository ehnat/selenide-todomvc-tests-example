### Project description
The project contains UI tests checking a few scenarios for Todomvc application: https://todomvc.com/examples/vanillajs/ .
Scenarios tested in current project:
1) Creating a new task
2) Modifying existing task
3) Removing task
4) Marking task as completed
5) Marking a few tasks as completed
6) Removing completed tasks


### Technical description
- Used technologies: Groovy, Gradle
- Used frameworks/libraries: Selenide, Spock, Allure
- Used patterns: Page Object Pattern


### Allure reports
Allure is using for generation test results. Useful commands:
- `allureReport` - create report in `/ui-tests/build/reports/allure-report/index.html`
- `allureServe` - create report and show it in browser
- `--continue` - even if any test is failed allure report is created. Without this commend report is not existed (when
  test is failed)


### Taking screenshots
- Selenide takes screenshots from default for failing tests
- screenshots are placed `build/reports/tests`
- for making additional configuration: https://selenide.org/documentation/screenshots.html


### Choosing browser
- from default tests use `chrome` browser
- for running tests in a different browser e.g. in firefox `-Dselenide.browser=firefox`
- additional information for using browser in Selenide: https://github.com/selenide/selenide/wiki/How-Selenide-creates-WebDriver

### How to run
1) mac
   `./gradlew clean test -Denv=ENVIRONMENT --info`

2) windows
   `gradlew.bat clean test -Denv=ENVIRONMENT --info`

where default is ENVIRONMENT=default (files `env.properties` and `build.gradle`)


### Full command to run tests and show allure report
`./gradlew clean test -Denv=ENVIRONMENT allureReport allureServe --info --continue`

