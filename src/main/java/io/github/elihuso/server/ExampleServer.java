package io.github.elihuso.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import io.github.elihuso.data.JavaResources;
import io.github.elihuso.logic.MathEx;
import io.github.elihuso.logic.Streaming;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class ExampleServer implements HttpHandler {

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String body = Streaming.ReadInputStream(JavaResources.getResource("example.html"));
        byte[] response = body.getBytes(StandardCharsets.UTF_8);

        httpExchange.sendResponseHeaders(200, MathEx.getByteLength(response));
        OutputStream outputStream = httpExchange.getResponseBody();
        outputStream.write(response);
        outputStream.close();
    }
}
