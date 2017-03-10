package com.ericsson.eqinson.thread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLParser {
    public static void main(String... args) throws Exception {
        CompletableFuture.supplyAsync(() -> URLParser.BlockingReadPage("http://www.sina.com/")).
                thenApply(URLParser::parseUrl).thenAccept(s -> s.forEach(System.out::println));
        ForkJoinPool.commonPool().awaitQuiescence(100, TimeUnit.SECONDS);
    }

    private static List<String> parseUrl(String contents) {
        List<String> address = new ArrayList<>();
        Pattern p = Pattern.compile("src=\"(http://[a-zA-Z./]+)");
        Matcher matcher = p.matcher(contents);
        while (matcher.find()) {
            String url = matcher.group(1);
            address.add(url);

        }
        return address;
    }

    private static String BlockingReadPage(String url_address) {
        StringBuilder sb = new StringBuilder();
        URLConnection urlConn = null;
        InputStreamReader in = null;
        try {
            URL url = new URL(url_address);
            urlConn = url.openConnection();
            if (urlConn != null)
                urlConn.setReadTimeout(60 * 1000);
            if (urlConn != null && urlConn.getInputStream() != null) {
                in = new InputStreamReader(urlConn.getInputStream(), Charset.defaultCharset());
                BufferedReader bufferedReader = new BufferedReader(in);
                int cp;
                while ((cp = bufferedReader.read()) != -1) {
                    sb.append((char) cp);
                }
                bufferedReader.close();
                in.close();
            }
        } catch (Exception e) {
            throw new RuntimeException("Exception while calling URL:" + url_address, e);
        }

        return sb.toString();
    }
}
