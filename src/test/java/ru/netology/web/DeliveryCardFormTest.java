package ru.netology.web;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;


class DeliveryCardFormTest {

    WebDriver driver;


    @Test
    void shouldRegisterTest1() {
        open("http://localhost:9999");
        Configuration.holdBrowserOpen = true;

        // устанавливаем текущую дату ПЛЮС 3 дня
        Date currentDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        c.add(Calendar.DATE, 3);
        SimpleDateFormat formatForCurrentDate = new SimpleDateFormat("dd.MM.y");
        String newCurrentDate = formatForCurrentDate.format(c.getTime());

        //заполняем форму, делаем проверку
        $("div [data-test-id='city'] input").setValue("Иркутск");
        $("div [data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("div [data-test-id='date'] input").setValue(newCurrentDate);
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

        // устанавливаем текущую дату ПЛЮС 3 дня
        Date currentDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        c.add(Calendar.DATE, 3);
        SimpleDateFormat formatForCurrentDate = new SimpleDateFormat("dd.MM.y");
        String newCurrentDate = formatForCurrentDate.format(c.getTime());

        //заполняем форму, делаем проверку
        $("div [data-test-id='city'] input").setValue("Великий Новгород");
        $("div [data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("div [data-test-id='date'] input").setValue(newCurrentDate);
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

        // устанавливаем текущую дату ПЛЮС 3 дня
        Date currentDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        c.add(Calendar.DATE, 3);
        SimpleDateFormat formatForCurrentDate = new SimpleDateFormat("dd.MM.y");
        String newCurrentDate = formatForCurrentDate.format(c.getTime());

        //заполняем форму, делаем проверку
        $("div [data-test-id='city'] input").setValue("Петропавловск-Камчатский");
        $("div [data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("div [data-test-id='date'] input").setValue(newCurrentDate);
        $("div [data-test-id='name'] input").setValue("Анна-Мария Ю");
        $("div [data-test-id='phone'] input").setValue("+79656663851");
        $$("[data-test-id='agreement']").last().click();
        $$(By.className("button__content")).last().click();
        $("div.notification__title").shouldHave(exactText("Успешно!"), Duration.ofSeconds(40));
    }

}
