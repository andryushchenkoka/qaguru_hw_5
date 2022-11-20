package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationTest extends TestBase{

    private String  firstName       = "Kirill",
                    lastName        = "Andryushchenko",
                    userEmail       = "kirill@mail.com",
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

    @Test
    @DisplayName("Регистрация пользователя с валидными данными")
    public void successfulRegistration(){

        new RegistrationPage().openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setPhone(userPhone)
                .setBirthDay(userBirthDay, userBirthMonth, userBirthYear)
                .setSubject(subjects)
                .setHobbie(hobbies)
                .uploadPicture(imagePath)
                .setCurrentAddress(currentAddress)
                .selectState(userState)
                .selectCity(userCity)
                .submitForm()
                .verifyResultModule()
                .verifyResultValue("Student Name", firstName + " " + lastName)
                .verifyResultValue("Student Email", userEmail)
                .verifyResultValue("Gender", userGender)
                .verifyResultValue("Mobile", userPhone)
                .verifyResultValue("Date of Birth", userBirthDay + " " + userBirthMonth + "," + userBirthYear)
                .verifyResultValue("Subjects", subjects)
                .verifyResultValue("Hobbies", hobbies)
                .verifyResultValue("Picture", imagePath)
                .verifyResultValue("Address", currentAddress)
                .verifyResultValue("State and City", userState + " " + userCity);
    }
}