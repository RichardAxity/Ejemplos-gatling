package microservices.simulations;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.HttpProtocolBuilder;
import microservices.consumes.ParticipantesScenario;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class ParticipantsSimulation extends Simulation {
    int nbUser = Integer.getInteger("users", 1);
    int myRamp = Integer.getInteger("ramp", 0);

    String baseURL = System.getProperty("baseURL", "localhost");

    HttpProtocolBuilder httpProtocol = http
            .baseUrl(baseURL)
            .header("Content-type","application/json; charset=utf-8")
            .check(status().is(200));
    {
        setUp(
                ParticipantesScenario.GetPArticipants().injectOpen(rampUsers(nbUser).during(myRamp))
        ).protocols(httpProtocol);
    }
}
