package qa.quru.api;

import io.qameta.allure.Step;
import qa.quru.models.CredModel;
import qa.quru.models.LoginResponseModel;

import static io.restassured.RestAssured.given;
import static qa.quru.spec.LoginSpec.successLoginRequestSpec;
import static qa.quru.spec.LoginSpec.successLoginResponseSpec;

public class LoginAuthAPI {
    @Step("Authorization step")
    public LoginResponseModel login(CredModel credModel){
        return given(successLoginRequestSpec)
                .body(credModel)
                .when()
                .post("/Account/v1/Login")
                .then()
                .spec(successLoginResponseSpec)
                .extract().as(LoginResponseModel.class);

    }
}
