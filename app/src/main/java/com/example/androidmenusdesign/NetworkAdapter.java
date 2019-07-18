package com.example.androidmenusdesign;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkAdapter {
    public static final String GET = "GET";
    public static final String POST = "POST";
    public static final String PUT = "PUT";
    public static final String DELETE = "DELETE";
    public static final int TIMEOUT = 3000;

    public static String httpRequest(String stringUrl, String requestType) {
        return httpRequest(stringUrl, requestType, "");
    }

    public static String httpRequest(String stringUrl) {
        return httpRequest(stringUrl, GET, "");
    }

    // only handles get and post requests right now
    public static String httpRequest(String stringUrl, String requestType, String body) {
        String result = "";
        InputStream stream = null;
        HttpURLConnection connection = null;
        try {
            URL url = new URL(stringUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(TIMEOUT);
            connection.setConnectTimeout(TIMEOUT);
            connection.setRequestMethod(requestType);

            if(requestType.equals(GET) || requestType.equals(DELETE)) {
                connection.connect();
            } else if(requestType.equals(POST) || requestType.equals(PUT)) {
                OutputStream outputStream = connection.getOutputStream();
                outputStream.write(body.getBytes());
                outputStream.close();
            }

            if(connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                stream = connection.getInputStream();
                if(stream != null) {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
                    StringBuilder builder = new StringBuilder();
                    String line;
                    while((line = reader.readLine()) != null) {
                        builder.append(line);
                    }
                    result = builder.toString();
                }
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
            result = e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
            result = e.getMessage();
        } finally {
            if(connection != null) {
                connection.disconnect();
            }

            if(stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public static Bitmap getBitmapFromURL(final String urlString) {
        Bitmap            result     = null;
        InputStream       stream     = null;
        HttpURLConnection connection = null;
        try {

            URL url = new URL(urlString);
            connection = (HttpURLConnection) url
                    .openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            result = BitmapFactory.decodeStream(input);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close Stream and disconnect HTTPS connection.
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
        return result;
    }

}
