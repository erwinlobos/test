/*
 * Copyright 2011-2018 GatlingCorp (https://gatling.io)
 *
 * All rights reserved.
 */

package frontline.sample

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class BasicSimulation extends Simulation {

  val httpConf = http
    .baseUrl("http://selfcarecvgt-uat-gt-eks.tigocloud.net")

  val scn = scenario("scenario1")
    .exec(
      http("Home")
        .get("/")
    )

  setUp(
    scn.inject(rampUsersPerSec(1) to (200) during(240))
  ).protocols(httpConf)
}
