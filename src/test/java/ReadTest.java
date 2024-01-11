import com.arangodb.RestClient;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ReadTest {

    private static String baseUrl;

    @BeforeAll
    public static void precondition(){
        //add if any
    }

    @Test
    public void connectRead() throws IOException {
        RestClient.get(baseUrl+"stringy-boy");
    }

    @AfterAll
    public static void cleanUp() throws IOException {
        RestClient.close();
    }
}
