package microservices.consumes;

import io.gatling.javaapi.core.ScenarioBuilder;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class ObtenerScenario {
    public static ScenarioBuilder GetSomething() {
        String api = "/web/index.php/auth/logn";
        return scenario("Escenario de peticion de Algo")
                .exec(session -> session)
                .exec(
                        http("GET login page")
                                .get(api)
                                .check(status().is(200))
                );
    }


}
