package com.ia.master.flink;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FlinkAPI {

    public static final String UPLOAD_JARS = "/jars/upload";
    public static final String SUBMIT_JOB = "/jars/:jarid/run";
    public static final String GET_JOBS = "/jobs";

    private String url;
    private String jarFileName;

    public FlinkAPI(String url) {
        this.url = url;
    }

    public void uploadJar(String name) throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(this.url + UPLOAD_JARS);
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();

        builder.addPart("jarfile", new FileBody(getResourceAsFile(name)));
        HttpEntity multipart = builder.build();
        httpPost.setEntity(multipart);

        CloseableHttpResponse response = client.execute(httpPost);
        JsonParser parser = new JsonParser();
        JsonElement jsonElement = parser.parse(EntityUtils.toString(response.getEntity()));
        if (jsonElement.isJsonObject()) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            System.out.println(jsonObject.toString());
            String[] path = jsonObject.get("filename").getAsString().split("/");
            this.jarFileName = path[path.length - 1];
        }
    }

    public JsonElement submitJob(JsonArray args) throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(this.url + SUBMIT_JOB.replace(":jarid", this.jarFileName));

        JsonObject jsonObject = new JsonObject();
        jsonObject.add("programArgsList", args);
        httpPost.setEntity(new StringEntity(jsonObject.toString()));
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");

        CloseableHttpResponse response = client.execute(httpPost);
        JsonParser parser = new JsonParser();
        return parser.parse(EntityUtils.toString(response.getEntity()));
    }

    public JsonElement getJobs() throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(this.url + GET_JOBS);

        CloseableHttpResponse response = client.execute(httpGet);
        JsonParser parser = new JsonParser();
        return parser.parse(EntityUtils.toString(response.getEntity()));
    }

    private File getResourceAsFile(String resourcePath) throws Exception {
        InputStream in = getClass().getResourceAsStream(resourcePath);
        if (in == null) {
            throw new Exception("File not found in resources!");
        }

        File tempFile = File.createTempFile(String.valueOf(in.hashCode()), ".jar");
        tempFile.deleteOnExit();

        try (FileOutputStream out = new FileOutputStream(tempFile)) {
            //copy stream
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
        return tempFile;
    }
}
