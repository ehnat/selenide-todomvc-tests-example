# selenide-todomvc-tests

### How to run

1) mac
   `./gradlew clean test -Denv=ENVIRONMENT --info`

2) windows
   `gradlew.bat clean test -Denv=ENVIRONMENT --info`

where default is ENVIRONMENT=default

### Allure reports

- `allureReport` - create report in /ui-tests/build/reports/allure-report/index.html
- `allureServe` - create report and show it in browser
- `--continue` - even if any test is failed allure report is created. Without this commend report is not existed (when
  test is failed)

### Complete commend to run tests and show allure report

`./gradlew clean test -Denv=ENVIRONMENT allureReport allureServe --info --continue`