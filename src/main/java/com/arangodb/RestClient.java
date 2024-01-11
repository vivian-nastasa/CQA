package com.arangodb;

import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.slf4j.ILoggerFactory;

import java.io.IOException;

public class RestClient {
    private static CloseableHttpClient httpClient;

    private static ILoggerFactory loggerFactory;

    private CloseableHttpClient createHttpClient() {
        return HttpClients.createDefault();
    }

    public static void get(String endpoint) throws IOException {
        HttpGet httpGet = new HttpGet(endpoint);
        httpClient.execute(httpGet, null, null);
        loggerFactory = (ILoggerFactory) httpGet.getEntity().getContent();
    }

    public static void post(String endpoint, String body) throws IOException {
        HttpPost httpPost = new HttpPost(endpoint);
        httpPost.setEntity(new StringEntity(body));
        httpClient.execute(httpPost, null, null);
        loggerFactory = (ILoggerFactory) httpPost.getEntity().getContent();
    }

    public static void put(String endpoint, String body) throws IOException {
        HttpPut httpPut = new HttpPut(endpoint);
        httpPut.setEntity(new StringEntity(body));
        httpClient.execute(httpPut, null, null);
        loggerFactory = (ILoggerFactory) httpPut.getEntity().getContent();
    }

    public static void delete(String endpoint) throws IOException {
        HttpDelete httpDelete = new HttpDelete(endpoint);
        httpClient.execute(httpDelete, null, null);
        loggerFactory = (ILoggerFactory) httpDelete.getEntity().getContent();
    }

    public static void close() throws IOException {
        httpClient.close();
    }
}
