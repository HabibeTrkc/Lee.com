package base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class LeeComBase {

    protected RequestSpecification spec;

    @Before
    public void setup() {
        spec = new RequestSpecBuilder().setBaseUri("https://www.lee.com.tr/").build();
    }

}
