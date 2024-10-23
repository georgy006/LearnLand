package com.example.learnland.service.impl;

import com.example.learnland.service.AIService;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class AIServiceImpl implements AIService {
    private final String apiToken;
    private final OkHttpClient httpClient;
    private final String baseUrl = "https://api.proxyapi.ru/openai/v1/chat/completions"; // URL для ProxyAPI

    private List<JSONObject> messageHistory = new ArrayList<>();

    public AIServiceImpl(@Value("${api.token}") String apiToken) {
        this.apiToken = apiToken;
        this.httpClient = new OkHttpClient.Builder().build();
    }

    public String sendMessage(String prompt, String question) throws IOException {
        JSONObject systemMessage = new JSONObject()
                .put("role", "system")
                .put("content", prompt);
        JSONObject userMessage = new JSONObject()
                .put("role", "user")
                .put("content", question);
        messageHistory = new ArrayList<>(Arrays.asList(systemMessage, userMessage));

        return sendMessagesToChatGPT();
    }

    public void setPrompt(String prompt) {
        JSONObject systemMessage = new JSONObject()
                .put("role", "system")
                .put("content", prompt);
        messageHistory = new ArrayList<>(List.of(systemMessage));
    }

    public String addMessage(String question) throws IOException {
        JSONObject userMessage = new JSONObject()
                .put("role", "user")
                .put("content", question);
        messageHistory.add(userMessage);

        return sendMessagesToChatGPT();
    }

    private String sendMessagesToChatGPT() throws IOException {
        JSONObject requestJson = new JSONObject()
                .put("model", "gpt-4o-mini") // Можно использовать другую модель gpt-4o-mini gpt-4-turbo
                .put("messages", new JSONArray(messageHistory))
                .put("max_tokens", 3000)
                .put("temperature", 0.9);

        RequestBody body = RequestBody.create(requestJson.toString(), MediaType.parse("application/json"));

        Request request = new Request.Builder()
                .url(baseUrl)
                .post(body)
                .addHeader("Authorization", "Bearer " + apiToken)
                .addHeader("Content-Type", "application/json")
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            JSONObject responseJson = new JSONObject(response.body().string());
            JSONObject message = responseJson.getJSONArray("choices").getJSONObject(0).getJSONObject("message");
            messageHistory.add(message);

            return message.getString("content");
        }
    }

    public String getBalance() throws IOException {
        Request request = new Request.Builder()
                .url("https://api.proxyapi.ru/proxyapi/balance")
                .get()
                .addHeader("Authorization", "Bearer " + apiToken)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            JSONObject responseJson = new JSONObject(response.body().string());
            return responseJson.getString("balance");
        }
    }
}
