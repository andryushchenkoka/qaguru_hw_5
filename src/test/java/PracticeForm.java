import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class PracticeForm {
    // тестовые данные
    private String  firstName       = "Kirill",
                    lastName        = "Andryushchenko",
                    userEmail       = "abc@mail.com",
                    userGender      = "Male",
                    userPhone       = "8005553535",
                    userBirthDay    = "26",
                    userBirthMonth  = "June",
                    userBirthYear   = "2001",
                    subjects        = "Maths",
                    hobbies         = "Music",
                    imagePath       = "profile.jpg",
                    currentAddress  = "Lenina Street",
                    userState       = "NCR",
                    userCity        = "Delhi";

    @BeforeAll
    public static void beforeSettings() {
        Configuration.holdBrowserOpen   = true;
        Configuration.browserSize       = "1920x1080";
        Configuration.baseUrl           = "https://demoqa.com";
    }

    @Test
    @DisplayName("Отправка формы регистрации с валидными данными")
    public void successfulSubmitOfRegistrationForm() {
        open("/automation-practice-form");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(new ByText(userGender)).click();
        $("#userNumber").setValue(userPhone);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-container").shouldBe(visible);
        $(".react-datepicker__month-select").selectOption(userBirthMonth);
        $(".react-datepicker__year-select").selectOption(userBirthYear);
        $x("//div[@class = 'react-datepicker__month']//div[text() = '" + userBirthDay + "']").click();
        $("#subjectsInput").setValue(subjects).pressEnter();
        $("#hobbiesWrapper").$(new ByText(hobbies)).click();
        $("#uploadPicture").uploadFromClasspath(imagePath);
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(new ByText(userState)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(new ByText(userCity)).click();
        $("#submit").click();
        $(".modal-content").shouldBe(visible);
        $(".table-responsive").shouldHave(
                text(firstName + " " + lastName),
                text(userEmail),
                text(userGender),
                text(userPhone),
                text(userBirthDay + " " + userBirthMonth + "," + userBirthYear),
                text(subjects),
                text(currentAddress),
                text(userState + " " + userCity)
        );
    }
}