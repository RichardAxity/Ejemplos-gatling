package microservices.simulations;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

import io.gatling.javaapi.core.Simulation;
import microservices.consumes.LoginScenario;
import static io.gatling.javaapi.core.CoreDsl.*;   // rampUsers, atOnceUsers, assertions...
import static io.gatling.javaapi.http.HttpDsl.*;


public class LoginSimulation extends Simulation {

    //se define la url sin los endpoint y los datos a enviar
    int nbUser = Integer.parseInt(System.getProperty("users", "1"));
    int myRamp = Integer.parseInt(System.getProperty("ramp", "10"));

    String baseURL = System.getProperty("BASE_URL", "https://opensource-demo.orangehrmlive.com");

//se crea un llamado de http con la url a ejecutar
    HttpProtocolBuilder httpProtocol = http
            .baseUrl(baseURL);

    {
        setUp(
                //Se agrega la clase y el nombre del metodo a utilizar
                LoginScenario.getPage()
                        .injectOpen(rampUsers(nbUser).during(myRamp)),   // patrón de injeccion de usuarios

                LoginScenario.Login()
                        .injectOpen(rampUsers(nbUser).during(myRamp))
        )
                .protocols(httpProtocol)
                .assertions(
                        forAll().failedRequests().count().is(0L),                // Se cuenta el numero de request fallidos
                        forAll().successfulRequests().percent().gt(99.0),        // se revisa por porcentaje
                        forAll().responseTime().percentile3().lt(1500),          // se revisa tiempo de respuesta
                        forAll().responseTime().max().lt(3000)              // Se revisa que el tiempo maximo no sea de 3s

                );
    }

}
