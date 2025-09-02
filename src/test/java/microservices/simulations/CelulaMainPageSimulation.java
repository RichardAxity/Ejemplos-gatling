package microservices.simulations;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.HttpProtocolBuilder;
import microservices.consumes.ObtenerScenario;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class CelulaMainPageSimulation extends Simulation {


    int nbUser = Integer.getInteger("users", 1);
    int myRamp = Integer.getInteger("ramp", 10); // evita 0s
    String baseURL = System.getProperty("BASE_URL", "https://opensource-demo.orangehrmlive.com");

    HttpProtocolBuilder httpProtocol = http
            .baseUrl(baseURL)
            .acceptHeader("application/json");

    {
        setUp(
                ObtenerScenario.GetSomething()
                        .injectOpen(rampUsers(nbUser).during(myRamp))
        )
                .protocols(httpProtocol)
                .assertions(
                        global().failedRequests().count().is(0L)
                );
    }
}
