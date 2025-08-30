# AmericanEagle Test Project Java

[![Java](https://img.shields.io/badge/Java-17-%23ED8B00?logo=coffee)](https://www.java.com/)
[![Maven](https://img.shields.io/badge/Maven-3.9.8-%23ED8B00?logo=apachemaven)](https://maven.apache.org/)
[![TestNG](https://img.shields.io/badge/TestNG-7.11.0-%23ED8B00?logo=testng)](https://testng.org/)
[![Selenium](https://img.shields.io/badge/Selenium-4.33-%23ED8B00?logo=selenium)](https://www.selenium.dev/)
[![GitHub Actions](https://img.shields.io/badge/GitHub%20Actions-CI-%232671E5?logo=githubactions)](https://github.com/features/actions)
[![Allure](https://img.shields.io/badge/Allure-Report-%23FF6A00?logo=allure)](https://allurereport.org/)

---

Это репозиторий для проекта по автоматизации тестовых сценариев для сайта [American Eagle](https://www.ae.com/us/en) с
использованием UI и API тестов.

**American Eagle** — американская розничная компания по продаже одежды и аксессуаров, со штаб-квартирой в Питтсбурге,
штат Пенсильвания.

## Содержание

- [🛠️ Технологический стек](#-технологический-стек)
- [📈 Тест план](./test_plan.pdf)
- [🚀 Запуск тестов](#-запуск-тестов)
- [⚙️ Запуск в Github Actions](#-запуск-в-github-actions)
- [📊 Allure отчет в Github Actions](#-allure-отчет-в-github-actions)

---

## 🛠️ Технологический стек

<p align="center">
  <a href="https://www.jetbrains.com/idea/" rel="nofollow"><img width="10%" title="IntelliJ IDEA" src="images/logo/intellij.png" alt="Intellij_IDEA" style="max-width: 100%;"></a>
  <a href="https://www.java.com/" rel="nofollow"><img width="10%" title="Java" src="images/logo/Java.png" alt="Java" style="max-width: 100%;"></a>
  <a href="https://www.selenium.dev/" rel="nofollow"><img width="10%" title="Selenium" src="images/logo/selenium.png" alt="Selenium" style="max-width: 100%;"></a>
  <a href="https://rest-assured.io/" rel="nofollow"><img width="10%" title="Rest Assured" src="images/logo/RestAssured.svg" alt="RestAssured" style="max-width: 100%;"></a>
  <a href="https://maven.apache.org/" rel="nofollow"><img width="10%" title="Gradle" src="images/logo/Maven.png" alt="Maven"></a>
  <a href="https://testng.org/" rel="nofollow"><img width="10%" title="JUnit5" src="images/logo/TestNG.png" alt="TestNG" style="max-width: 100%;"></a>
  <a href="https://allurereport.org/" rel="nofollow"><img width="10%" title="Allure Report" src="images/logo/Allure.png" alt="Allure" style="max-width: 100%;"></a>
  <a href="https://github.com/" rel="nofollow"><img width="10%" title="GitHub" src="images/logo/github.png" alt="GitHub" style="max-width: 100%;"></a>
  <a href="https://github.com/features/actions" rel="nofollow"><img width="10%" title="Github Actions" src="images/logo/GitHubActions.png" alt="Github Actions" style="max-width: 100%;"></a>
</p>

- **Язык программирования:** Java 17
- **UI тестирование:** Selenium
- **API тестирование:** REST Assured
- **Сборка:** Maven
- **Тестовый фреймворк:** TestNG
- **Шаблон проектирования:** Page Object Model (POM)
- **Упрощение создания моделей в API тестировании:** Lombok
- **Отчетность:** Allure Report
- **CI/CD:** GitHub Actions, который создаёт Allure отчёт и публикует результаты на GitHub Pages.

**Содержание Allure отчёта:**

- Шаги тестов
- Автоматические скриншоты для упавших UI-тестов (кроме тестов с секретными данными)
- Page Source для упавших UI-тестов

---

## 🚀 Запуск тестов

⛔️ Я тестирую реальный сайт работающего магазина, поэтому некоторые тесты **блокируются защитой от ботов (Akamai)**: не
работают тесты, которые связаны с **авторизацией и регистрацией** на сайте.
В связи с этим в данном проекте эти тесты отмечены тегом "Defect" и для их локального запуска используется отдельная
команда.

### Команды для запуска:

Все тесты (кроме дефектных):

   ```bash     
       mvn clean test       
   ```

Только API-тесты (кроме дефектных):

   ```bash
       mvn clean test -Dsuite=api
   ```

Только UI-тесты (кроме дефектных):

   ```bash
       mvn clean test -Dsuite=ui
   ```

---

## ⚙️ Запуск в Github Actions

1. Перейдите в репозиторий `AmericanEagle`

2. Откройте вкладку `Actions`

<p align="center"> <img src="images/githubactions/1.png" alt="Press to Actions tab" width="700"/> </p>

3. Выберите workflow `Java CI with Maven`

<p align="center"> <img src="images/githubactions/2.png" alt="Press AE tests workflow" width="700"/> </p>

4. Нажмите `Run workflow`

<p align="center"> <img src="images/githubactions/3.png" alt="Press run workflow" width="700"/> </p>
<p align="center"> <img src="images/githubactions/4.png" alt="Press run workflow" width="700"/> </p>

4. Началось выполнение тестов

<p align="center"> <img src="images/githubactions/5.png" alt="Press run workflow" width="700"/> </p>

5. Дождитесь завершения выполнения

---

## 📊 Allure отчет в Github Actions

1. После завершения сборки перейдите в `Actions` снова

<p align="center"> <img src="images/githubactions/6.png" alt="Press to Actions tab" width="700"/> </p>

2. Нажмите на `pages build and deployment`

<p align="center"> <img src="images/githubactions/7.png" alt="Press to Actions tab" width="700"/> </p>

3. Перейдите по ссылке в отчет

<p align="center"> <img src="images/githubactions/8.png" alt="Click on the link" width="700"/> </p>

4. Просмотрите отчет

<p align="center"> <img src="images/githubactions/9.png" alt="Allure report" width="700"/> </p>
<p align="center"> <img src="images/githubactions/10.png" alt="Allure report" width="700"/> </p>

