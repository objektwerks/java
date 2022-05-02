package objektwerks;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws IOException, InterruptedException {
        String name = args.length > 0 ? args[0] : "Java geek";
        String prefix = "*** ";

        System.out.println(prefix + "Hello world!");
        System.out.println(prefix + "Hello, " + name + "!");

        logger.info(prefix + "App lgging is working!");

        var client = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

        var request = HttpRequest.newBuilder()
            .GET()
            .uri(URI.create("http://api.icndb.com/jokes/random/"))
            .build();

        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        var statusCode = response.statusCode();
        var text = response.body();

        System.out.println("status code: " + statusCode);
        System.out.println("text:\n" + text);

        logger.info(prefix + "status code: " + statusCode);
        logger.info(prefix + "text:\n" + text);
    }
}