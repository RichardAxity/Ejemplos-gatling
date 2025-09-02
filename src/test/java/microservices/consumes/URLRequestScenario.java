package microservices.consumes;

import io.gatling.javaapi.core.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class URLRequestScenario {
    public static ScenarioBuilder GetCelulaPage(){
        String api = "/";
        return scenario("Escenario de peticion de la URL de la Celula")
                .exec(session -> {
                    return session;
                })
                .exec(http("Getting a resourse")
                        .get(api)
                        .check(status().is(200))
                );
    }
}