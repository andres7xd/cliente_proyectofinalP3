/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.cliente_aeropuerto.Utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.una.cliente_aeropuerto.DTO.AuthenticationRequest;
import org.una.cliente_aeropuerto.DTO.AuthenticationResponse;

/**
 *
 * @author Andres
 */
public class ConnectionUtils {
     public static <T> List<T> ConnectionToObjectByCedula (String urlstring, String Cedula) throws MalformedURLException, IOException {
        Gson gson = new Gson();
        Type listtype = new TypeToken<ArrayList<T>>() {
        }.getType();

        URL url = new URL(urlstring);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "application/json");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            return gson.fromJson(response.toString(), listtype);
        }
    }

    public static <T> List<T> ListFromConnection(String urlstring, Class<T> type) throws MalformedURLException, IOException {
        Gson gson = new Gson();
        Type listtype = new TypeToken<ArrayList<T>>() {
        }.getType();

        URL url = new URL(urlstring);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "application/json");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            return gson.fromJson(response.toString(), listtype);
        }
    }
      public static <T> List<T> ConnectionToObjectByField (String urlstring, String Nombre) throws MalformedURLException, IOException {
        Gson gson = new Gson();
        Type listtype = new TypeToken<ArrayList<T>>() {
        }.getType();

        URL url = new URL(urlstring);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "application/json");
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            return gson.fromJson(response.toString(), listtype);
        }
    }

    public static void ObjectToConnection(String urlstring, Object object) throws MalformedURLException, IOException {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").create();

        URL url = new URL(urlstring);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);

        String data = gson.toJson(object);

        try (OutputStream os = con.getOutputStream()) {
            byte[] input = data.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
        }
    }

    public static void ObjectToConnectionLogin(String urlstring, AuthenticationRequest object) throws MalformedURLException, IOException {
        Type listtype = new TypeToken<AuthenticationResponse>() {
        }.getType();
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").create();

        URL url = new URL(urlstring);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);

        String data = gson.toJson(object);

        try (OutputStream os = con.getOutputStream()) {
            byte[] input = data.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());

            }

            System.out.println(response.toString());
        }

    }
   
}
