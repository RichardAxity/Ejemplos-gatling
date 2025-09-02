package microservices.consumes;
import io.gatling.javaapi.core.ScenarioBuilder;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;


public class LoginScenario {

    public static ScenarioBuilder getPage() {
        String api = "/web/index.php/auth/login";
        return scenario("GET login page") //nombre del scenario
                .exec(
                        http("GET login")//nombre del request que se esta haciendo
                                .get(api)//obtencion de la api
                                .check(status().is(200))     //validacion del status
                );
    }

    //recibiendo parametros del simulador
    public static ScenarioBuilder getPageParam(String api) {
        return scenario("GET login page (param)")
                .exec(
                        http("GET login (param)")
                                .get(api)
                                .check(status().is(200))
                );
    }

    public static ScenarioBuilder Login() {
        String api = "/web/index.php/auth/validate";
        return scenario("Post Login")
                .exec(
                        http("Post login")
                                .post(api)
                                .formParam("username","Admin")
                                .formParam("password","admin123")
                                .check(status().is(200))
                );
    }

    public static ScenarioBuilder LoginParam(String api, String user, String pass) {
        return scenario("Post Login (param)")
                .exec(
                        http("Post login (param)")
                                .post(api)
                                .formParam("username",user)
                                .formParam("password",pass)
                                .check(status().is(200))
                );
    }
}
