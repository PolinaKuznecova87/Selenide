package ru.netology.selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import org.junit.jupiter.api.Test;


import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.selector.ByDeepShadow.cssSelector;
import static java.nio.channels.Selector.open;

public class СardDeliveryForm {



        @Test
        public void shouldTestCardDeliveryForm () {
            Configuration.holdBrowserOpen = true;

            Selenide.open("http://localhost:9999/");
            $$("[type=text]").filter(Condition.visible).first().setValue("Краснодар");
            $("[placeholder='Дата встречи']").setValue("06.04.2025");
            $("[name=name]").setValue("Кузнецов Сергей");
            $("[name=phone]").setValue("+79188055655");
            $(".checkbox__box").click();
            $x("//*[contains(text(), 'Забронировать')]").click();
            $x("//div[@class='notification__title']").shouldBe(Condition.visible, Duration.ofSeconds(15));









            
        }

}
