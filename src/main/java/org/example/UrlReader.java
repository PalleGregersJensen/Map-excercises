package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UrlReader {

    public Map<String, Integer> readUrl(String strUrl, List<String> words) {
        Map<String, Integer> mapWords = new HashMap<>();
        try {
            URL url = new URL(strUrl);
            URLConnection urlConnection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                for (String word : words) {
                    if (line.contains(word)) {
                        int count = mapWords.getOrDefault(word, 0);
                        mapWords.put(word, count + 1);
                    }
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Fejl: " + e.getMessage());
        }
        return mapWords;
    }

    public Map<String, Map<String, Integer>> readUrls(List<String> urls, List<String> words) {
        Map<String, Map<String, Integer>> result = new HashMap<>();
        for (String url : urls) {
            Map<String, Integer> wordCounts = readUrl(url, words);
            result.put(url, wordCounts);
        }
        return result;
    }
}
