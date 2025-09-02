package microservices.consumes;

import io.gatling.javaapi.core.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class VersionRequestScenario {
    public static ScenarioBuilder GetVersion(){
        String api = "/api/StarWarsIntro/Version";
        return scenario("Esceanrio de peticion de la Version")
                .exec(session -> {
                    return session;
                })
                .exec(http("Getting a resource")
                        .get(api)
                        .check(status().is(200))
                );
    }
}
