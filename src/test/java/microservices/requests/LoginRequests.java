package microservices.requests;

import io.gatling.javaapi.http.HttpRequestActionBuilder;

import static io.gatling.javaapi.http.HttpDsl.*;
public class LoginRequests {

    public static HttpRequestActionBuilder getLoginPage() {
        return http("Ingresar al login")
                .get("/web/index.php/auth/login");
    }

    public static HttpRequestActionBuilder postLogin(String user, String pass) {
        return http("Enviar formulario")
                .post("/web/index.php/auth/validateCredentials")
                .formParam("username", user)
                .formParam("password", pass);
    }
}
