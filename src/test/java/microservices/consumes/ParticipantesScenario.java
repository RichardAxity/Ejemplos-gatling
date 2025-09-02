package microservices.consumes;

import io.gatling.javaapi.core.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class ParticipantesScenario {
    public static ScenarioBuilder GetPArticipants(){
        String api = "/api/StarWarsIntro/ObtenerParticipantes";
        return scenario("Escenario de peticion de los participantes")
                .exec(session -> {
                    return session;
                })
                .exec(http("Getting a resource")
                        .get(api)
                        .check(status().is(200))
                );
    }
}