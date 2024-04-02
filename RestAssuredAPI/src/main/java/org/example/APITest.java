package org.example;

import static  io.restassured.RestAssured.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class APITest {

    @Test
    void GetAPI(){
        given().header("Server","cloudflare")
                .get("https://www.kurtosys.com/").
                then().statusCode(200).and().
                log().all();
    }

    @Test
    void GetLoadTIme(){
        long actualTimeWithUnits = given().get("https://www.kurtosys.com/").getTimeIn(TimeUnit.SECONDS);
        Assert.assertTrue(actualTimeWithUnits < 2);
    }
}
