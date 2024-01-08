import io.restassured.http.ContentType;
import org.testng.annotations.Test;
//alttaki 2 importu her zaman eklemekte fayda var cogu komutu kullanmada yardimci oluyor ( bknz equalTo)
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ZippoTest {

    @Test
    public void test1(){

        given().
                // hazirlik islemleri kodlari

                when().
                // Endpoint (url) , method u verip istek gonderiliyor.

                then()
                // assertion, test, data islemleri.
        ;
    }

    @Test
    public void statusCodeTest(){
        given()
                //hazirlik kismi bos
                .when()
                .get("http://api.zippopotam.us/us/90210")


                .then()
                .log().body() //donen body yani json data, log().all() da diyebiliriz. -> gidip gelen hersey
                .statusCode(200) // assertion. status code 200 mu demis oluyoruz
                .contentType(ContentType.JSON) // content type json mu yani gelen sonuc
        ;
    }


    @Test
    public void contentTypeTest(){
        given()
                //hazirlik kismi bos
                .when()
                .get("http://api.zippopotam.us/us/90210")


                .then()
                .log().body() //donen body yani json data, log().all() da diyebiliriz. -> gidip gelen hersey
                .statusCode(200) // assertion. status code 200 mu demis oluyoruz
                .contentType(ContentType.JSON) // content type json mu yani gelen sonuc
        ;
    }


    @Test
    public void checkCountryInResponseBody(){

        given()

                .when()
                .get("http://api.zippopotam.us/us/90210")


                .then()
                .log().body()
                .statusCode(200)
                .body("country", equalTo("United States")) //assertion body nin country degeri United States mi?

        ;
    }

    // Soru : "http://api.zippopotam.us/us/90210"  endpoint indne dönen
    // place dizisinin ilk elemanının state değerinin  "California"
    // olduğunu doğrulayınız

    @Test
    public void test4() {
        given()

                .when()
                .get("http://api.zippopotam.us/us/90210")


                .then()
                .log().body()
                .statusCode(200)
                .body("places[0].state", equalTo("California"))

        ;
    }


    // Soru : "http://api.zippopotam.us/tr/01000"  endpoint in dönen
    // place dizisinin herhangi bir elemanında  "Dörtağaç Köyü" değerinin
    // olduğunu doğrulayınız
    @Test
    public void checkHasItem(){
        given()

                .when()
                .get("http://api.zippopotam.us/tr/01000")


                .then()
                .log().body()
                .statusCode(200)
                .body("places.'place name'",hasItem("Dörtağaç Köyü"))
        ;
    }

    // Soru : "http://api.zippopotam.us/us/90210"  endpoint in dönen
    // place dizisinin dizi uzunluğunun 1 olduğunu doğrulayınız.

    @Test
    public void BodyHasSize(){

        given()

                .when()
                .get("http://api.zippopotam.us/us/90210")
                .then()
                .log().body()
                .statusCode(200)
                .body("places", hasSize(1))

        ;
    }



}
