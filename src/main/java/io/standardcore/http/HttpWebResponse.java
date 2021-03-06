package io.standardcore.http;

import io.standardcore.http.collection.NameValueCollection;

import java.util.Arrays;

public class HttpWebResponse {
    private final static byte[] EMPTY_BINARY = new byte[0];

    public HttpWebResponse(int statusCode, byte[] body){
        this.statusCode = statusCode;
        this.body = body;
    }

    public HttpWebResponse(int statusCode) {
        this(statusCode, EMPTY_BINARY);
    }

    private int statusCode;
    private byte[] body;
    private NameValueCollection<String, String> headers = new NameValueCollection<>();

    public int getStatusCode() {
        return statusCode;
    }

    public byte[] getBody() {
        return Arrays.copyOf(body, body.length);
    }

    public String getContentType() {
        return headers.firstValueOrDefault("content-type", "application/json");
    }

    public NameValueCollection<String, String> getHeaders() {
        return headers;
    }
}
