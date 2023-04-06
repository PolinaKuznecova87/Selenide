package ru.netology.selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import org.junit.jupiter.api.Test;


import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.selector.ByDeepShadow.cssSelector;
import static java.nio.channels.Selector.open;

public class СardDeliveryForm {


    @Test
    public void shouldTestCardDeliveryForm() {
        Configuration.holdBrowserOpen = true;

        Selenide.open("http://localhost:9999/");
        $$("[type=text]").filter(Condition.visible).first().setValue("Краснодар");
        $("[data-test-id=date] input").setValue("08.04.2023");
        $("[name=name]").setValue("Кузнецов Сергей");
        $("[name=phone]").setValue("+79188055655");
        $(".checkbox__box").click();
        $x("//*[contains(text(), 'Забронировать')]").click();
        $x("//div[@class='notification__title']").shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    @Test
    public void shouldTestAnotherCity() {
        Configuration.holdBrowserOpen = true;

        Selenide.open("http://localhost:9999/");
        $$("[type=text]").filter(Condition.visible).first().setValue("Лабинск");
        $("[data-test-id=date] input").setValue("08.04.2023");
        $("[name=name]").setValue("Кузнецов Сергей");
        $("[name=phone]").setValue("+79188055655");
        $(".checkbox__box").click();
        $x("//*[contains(text(), 'Забронировать')]").click();
        $x("//*[contains(text(), 'Доставка в выбранный')]").shouldBe(Condition.visible, Duration.ofSeconds(15));


    }

    @Test
    public void shouldTestThenNameOfTheCityOnABC() {
        Configuration.holdBrowserOpen = true;

        Selenide.open("http://localhost:9999/");
        $$("[type=text]").filter(Condition.visible).first().setValue("Labinck");
        $("[data-test-id=date] input").setValue("08.04.2023");
        $("[name=name]").setValue("Кузнецов Сергей");
        $("[name=phone]").setValue("+79188055655");
        $(".checkbox__box").click();
        $x("//*[contains(text(), 'Забронировать')]").click();
        $x("//*[contains(text(), 'Доставка в выбранный')]").shouldBe(Condition.visible, Duration.ofSeconds(15));


    }

    @Test
    public void shouldTestThenNameOfTheCitySymbols() {
        Configuration.holdBrowserOpen = true;

        Selenide.open("http://localhost:9999/");
        $$("[type=text]").filter(Condition.visible).first().setValue("###@@66");
        $("[data-test-id=date] input").setValue("08.04.2023");
        $("[name=name]").setValue("Кузнецов Сергей");
        $("[name=phone]").setValue("+79188055655");
        $(".checkbox__box").click();
        $x("//*[contains(text(), 'Забронировать')]").click();
        $x("//*[contains(text(), 'Доставка в выбранный')]").shouldBe(Condition.visible, Duration.ofSeconds(15));


    }

    @Test
    public void shouldTestThenNameOfTheCityNotSpecified() {
        Configuration.holdBrowserOpen = true;

        Selenide.open("http://localhost:9999/");
        $$("[type=text]").filter(Condition.visible).first().setValue("");
        $("[data-test-id=date] input").setValue("08.04.2023");
        $("[name=name]").setValue("Кузнецов Сергей");
        $("[name=phone]").setValue("+79188055655");
        $(".checkbox__box").click();
        $x("//*[contains(text(), 'Забронировать')]").click();
        $x("//*[contains(text(), 'Поле обязательно для заполнения')]").shouldBe(Condition.visible, Duration.ofSeconds(15));


    }

    //@Test
    //public void shouldTestNoDate() {
    // Configuration.holdBrowserOpen = true;

    //Selenide.open("http://localhost:9999/");
    // $$("[type=text]").filter(Condition.visible).first().setValue("Краснодар");
    //$("[data-test-id=date] input").setValue("");
    //$("[name=name]").setValue("Кузнецов Сергей");
    //$("[name=phone]").setValue("+79188055655");
    //$(".checkbox__box").click();
    //$x("//*[contains(text(), 'Забронировать')]").click();
    //$x("//*[contains(text(), 'Неверно введена дата')]").shouldBe(Condition.visible, Duration.ofSeconds(15));


    //@Test
    //public void shouldTestThenOnDateAllZeros() {
    //Configuration.holdBrowserOpen = true;

    //Selenide.open("http://localhost:9999/");
    //$$("[type=text]").filter(Condition.visible).first().setValue("Краснодар");
    //$("[data-test-id=date] input").setValue("08.04.2023");
    //$("[name=name]").setValue("Кузнецов Сергей");
    //$("[name=phone]").setValue("+79188055655");
    //$(".checkbox__box").click();
    //$x("//*[contains(text(), 'Забронировать')]").click();
    //$x("//*[contains(text(), 'Неверно введена дата')]").shouldBe(Condition.visible, Duration.ofSeconds(15));


    //}
    //@Test
    //public void shouldTestThenDateEarlierThanThreeDaysFromTheCurrentDate() {
    //Configuration.holdBrowserOpen = true;

    //Selenide.open("http://localhost:9999/");
    //$$("[type=text]").filter(Condition.visible).first().setValue("Краснодар");
    //Текущая дата 05.04.2023
    //$("[data-test-id=date] input").setValue("08.04.2023");
    //$("[name=name]").setValue("Кузнецов Сергей");
    //$("[name=phone]").setValue("+79188055655");
    //$(".checkbox__box").click();
    //$x("//*[contains(text(), 'Забронировать')]").click();
    //$x("//*[contains(text(), 'Заказ на выбранную дату невозможен')]").shouldBe(Condition.visible, Duration.ofSeconds(15));


    //}
    @Test
    public void shouldTestThenLastNameWithHyphen() {
        Configuration.holdBrowserOpen = true;

        Selenide.open("http://localhost:9999/");
        $$("[type=text]").filter(Condition.visible).first().setValue("Краснодар");
        $("[data-test-id=date] input").setValue("08.04.2023");
        $("[name=name]").setValue("Кузнецов-Белов Сергей");
        $("[name=phone]").setValue("+79188055655");
        $(".checkbox__box").click();
        $x("//*[contains(text(), 'Забронировать')]").click();
        $x("//div[@class='notification__title']").shouldBe(Condition.visible, Duration.ofSeconds(15));

    }

    @Test
    public void shouldTestWithoutLastName() {
        Configuration.holdBrowserOpen = true;

        Selenide.open("http://localhost:9999/");
        $$("[type=text]").filter(Condition.visible).first().setValue("Краснодар");
        $("[data-test-id=date] input").setValue("08.04.2023");
        $("[name=name]").setValue("");
        $("[name=phone]").setValue("+79188055655");
        $(".checkbox__box").click();
        $x("//*[contains(text(), 'Забронировать')]").click();
        $x("//*[contains(text(), 'Поле обязательно для заполнения')]").shouldBe(Condition.visible, Duration.ofSeconds(15));

    }

    @Test
    public void shouldTestThenLastNameABC() {
        Configuration.holdBrowserOpen = true;

        Selenide.open("http://localhost:9999/");
        $$("[type=text]").filter(Condition.visible).first().setValue("Краснодар");
        $("[data-test-id=date] input").setValue("08.04.2023");
        $("[name=name]").setValue("Kepytwjd");
        $("[name=phone]").setValue("+79188055655");
        $(".checkbox__box").click();
        $x("//*[contains(text(), 'Забронировать')]").click();
        $x("//*[contains(text(), 'Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.')]").shouldBe(Condition.visible, Duration.ofSeconds(15));

    }

    @Test
    public void shouldTestThenLastNameSymbol() {
        Configuration.holdBrowserOpen = true;

        Selenide.open("http://localhost:9999/");
        $$("[type=text]").filter(Condition.visible).first().setValue("Краснодар");
        $("[data-test-id=date] input").setValue("08.04.2023");
        $("[name=name]").setValue("Куз№№%%");
        $("[name=phone]").setValue("+79188055655");
        $(".checkbox__box").click();
        $x("//*[contains(text(), 'Забронировать')]").click();
        $x("//*[contains(text(), 'Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.')]").shouldBe(Condition.visible, Duration.ofSeconds(15));

    }

    @Test
    public void shouldTestThenPhoneFieldHasFiveDigits() {
        Configuration.holdBrowserOpen = true;

        Selenide.open("http://localhost:9999/");
        $$("[type=text]").filter(Condition.visible).first().setValue("Краснодар");
        $("[data-test-id=date] input").setValue("08.04.2023");
        $("[name=name]").setValue("Кузнецов Сергей");
        $("[name=phone]").setValue("+79188");
        $(".checkbox__box").click();
        $x("//*[contains(text(), 'Забронировать')]").click();
        $x("//*[contains(text(), 'Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.')]").shouldBe(Condition.visible, Duration.ofSeconds(15));

    }

    @Test
    public void shouldTestThenPhoneFieldWithoutANumber() {
        Configuration.holdBrowserOpen = true;

        Selenide.open("http://localhost:9999/");
        $$("[type=text]").filter(Condition.visible).first().setValue("Краснодар");
        $("[data-test-id=date] input").setValue("08.04.2023");
        $("[name=name]").setValue("Кузнецов Сергей");
        $("[name=phone]").setValue("");
        $(".checkbox__box").click();
        $x("//*[contains(text(), 'Забронировать')]").click();
        $x("//*[contains(text(), 'Поле обязательно для заполнения')]").shouldBe(Condition.visible, Duration.ofSeconds(15));

    }

    @Test
    public void shouldTestThenTheNumberStartsWith8() {
        Configuration.holdBrowserOpen = true;

        Selenide.open("http://localhost:9999/");
        $$("[type=text]").filter(Condition.visible).first().setValue("Краснодар");
        $("[data-test-id=date] input").setValue("08.04.2023");
        $("[name=name]").setValue("Кузнецов Сергей");
        $("[name=phone]").setValue("89188056355");
        $(".checkbox__box").click();
        $x("//*[contains(text(), 'Забронировать')]").click();
        $x("//*[contains(text(), 'Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.')]").shouldBe(Condition.visible, Duration.ofSeconds(15));

    }

    @Test
    public void shouldTestThenTheNumberMoreThan11Digits() {
        Configuration.holdBrowserOpen = true;

        Selenide.open("http://localhost:9999/");
        $$("[type=text]").filter(Condition.visible).first().setValue("Краснодар");
        $("[data-test-id=date] input").setValue("08.04.2023");
        $("[name=name]").setValue("Кузнецов Сергей");
        $("[name=phone]").setValue("+7918805635566666");
        $(".checkbox__box").click();
        $x("//*[contains(text(), 'Забронировать')]").click();
        $x("//*[contains(text(), 'Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.')]").shouldBe(Condition.visible, Duration.ofSeconds(15));

    }

    @Test
    public void shouldTestThenTheFlagIsNotSet() {
        Configuration.holdBrowserOpen = true;

        Selenide.open("http://localhost:9999/");
        $$("[type=text]").filter(Condition.visible).first().setValue("Краснодар");
        $("[data-test-id=date] input").setValue("08.04.2023");
        $("[name=name]").setValue("Кузнецов Сергей");
        $("[name=phone]").setValue("+79188053655");

        $x("//*[contains(text(), 'Забронировать')]").click();
        $(".checkbox__box").shouldBe();
    }

    @Test
    public void shouldTestSelectCityFromTheList() {
        Configuration.holdBrowserOpen = true;

        Selenide.open("http://localhost:9999/");
        $$("[type=text]").filter(Condition.visible).texts("Краснодар");

        $("[data-test-id=date] input").setValue("08.04.2023");
        $("[name=name]").setValue("Кузнецов Сергей");
        $("[name=phone]").setValue("+79188055655");
        $(".checkbox__box").click();
        $x("//*[contains(text(), 'Забронировать')]").click();
        $x("//div[@class='notification__title']").shouldBe(Condition.visible, Duration.ofSeconds(15));
    }


}






