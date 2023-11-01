package objektwerks;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import org.slf4j.LoggerFactory;

class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        var logger = LoggerFactory.getLogger(App.class);
        var name = args.length > 0 ? args[0] : "Java geek";
        var prefix = "*** ";

        System.out.println(prefix + "Hello world!");
        System.out.println(prefix + "Hello, " + name + "!");

        logger.info(prefix + "App logging is working!");

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

        System.out.println(prefix + "http status code: " + statusCode);
        System.out.println(prefix + "http response text:\n" + text);

        logger.info(prefix + "http status code: " + statusCode);
        logger.info(prefix + "http response text:\n" + text);
    }
}