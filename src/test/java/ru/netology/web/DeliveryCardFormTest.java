package ru.netology.web;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;


class DeliveryCardFormTest {

    WebDriver driver;

    public String generateDate(int days) {
        return
                LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    @Test
    void shouldRegisterTest1() {
        open("http://localhost:9999");
        Configuration.holdBrowserOpen = true;
        String planningDate = generateDate(5);

        //заполняем форму, делаем проверку
        $("div [data-test-id='city'] input").setValue("Иркутск");
        $("div [data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("div [data-test-id='date'] input").setValue(planningDate);
        $("div [data-test-id='name'] input").setValue("Пелагея Мамин-Сибиряк");
        $("div [data-test-id='phone'] input").setValue("+79996663355");
        $$("[data-test-id='agreement']").last().click();
        $$(By.className("button__content")).last().click();
        $("div.notification__title").shouldHave(exactText("Успешно!"), Duration.ofSeconds(40));
    }

    @Test
    void shouldRegisterTest2() {
        open("http://localhost:9999");
        Configuration.holdBrowserOpen = true;
        String planningDate = generateDate(3);

        //заполняем форму, делаем проверку
        $("div [data-test-id='city'] input").setValue("Великий Новгород");
        $("div [data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("div [data-test-id='date'] input").setValue(planningDate);
        $("div [data-test-id='name'] input").setValue("Йорик Панкратов-Черный");
        $("div [data-test-id='phone'] input").setValue("+79126663355");
        $$("[data-test-id='agreement']").last().click();
        $$(By.className("button__content")).last().click();
        $("div.notification__title").shouldHave(exactText("Успешно!"), Duration.ofSeconds(40));
    }

    @Test
    void shouldRegisterTest3() {
        open("http://localhost:9999");
        Configuration.holdBrowserOpen = true;
        String planningDate = generateDate(6);

        //заполняем форму, делаем проверку
        $("div [data-test-id='city'] input").setValue("Петропавловск-Камчатский");
        $("div [data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("div [data-test-id='date'] input").setValue(planningDate);
        $("div [data-test-id='name'] input").setValue("Анна-Мария Ю");
        $("div [data-test-id='phone'] input").setValue("+79656663851");
        $$("[data-test-id='agreement']").last().click();
        $$(By.className("button__content")).last().click();
        $("div.notification__title").shouldHave(exactText("Успешно!"), Duration.ofSeconds(40));
    }

    @Test
    void shouldRegisterTest4() {
        open("http://localhost:9999");
        Configuration.holdBrowserOpen = true;
        String planningDate = generateDate(4);

        //заполняем форму, делаем проверку
        $("div [data-test-id='city'] input").setValue("Калининград");
        $("div [data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("div [data-test-id='date'] input").setValue(planningDate);
        $("div [data-test-id='name'] input").setValue("Елена Гончарук-Дугач");
        $("div [data-test-id='phone'] input").setValue("+79996663351");
        $$("[data-test-id='agreement']").last().click();
        $$(By.className("button__content")).last().click();
        $("div.notification__content").shouldHave(Condition.text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(20)).shouldBe(Condition.visible);

    }

}
