package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("div", "med", "dig");
        List<String> urls = Arrays.asList("https://ekstrabladet.dk/", "https://dr.dk/", "https://tv2.dk/");
        UrlReader urlReader = new UrlReader();
        Map<String, Map<String, Integer>> result = urlReader.readUrls(urls, words);
        result.forEach((url, wordCounts) -> {
            System.out.println("URL: " + url);
            wordCounts.forEach((word, count) -> System.out.println(word + " count=" + count));
        });
    }
}
