package helpers;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;
public class BrowserstackHelper {
    public static String getVideoUrl(String sessionId) {

        String url = format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic("deveenok_1kNgLJ", "qSMpqV7mxWaSZo3T54EF")
                .when()
                .get(url)
                .then()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}
