package edu.escuelaing.arep.app.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import static spark.Spark.*;

import spark.Request;
import spark.Response;

public class MathServices {
    public static void main(String[] args) {
        port(getPort());
        get("/", (req, res) -> inputData(req, res));
        get("/results", (req, res) -> calculator(req, res));
    }

    public static Integer square(Integer i){
        return i*i;
    }

    private static String inputData(Request req, Response res) {
        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                +"<head>"
                +"<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css\">"
                +"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js\"></script>"
                +"</head>"
                + "<body>"
                +"<div class=\"center-align white-text blue darken-4\">"
                +"<h3 class=\"center-align\">Cuadrado de un numero</h3>"
                +"<h4>Escriba el numero que desea elevar al cuadrado: </h4>"
                +"</div>"
                +"<form action=\"/results\">"
                +"<div class=\"row\">"
                +"<div class=\"input-field col l4 m4 s12 offset-l4 offset-m4\">"
                +"<input type=\"text\" name=\"numero\" value=\"\" required>"
                +"<label for=\"numero\">Numero</label>"
                +"</div>"
                +"<div class=\"row\">"
                +"<div class=\"input-field col l6 m6 s12 offset-l5 offset-m5\">"
                +"<button class=\"btn waves-effect blue darken-4\" type=\"submit\">Calcular</button>"
                +"</div>"
                +"</div>"
                +"</div>"
                +"</form>"
                +"</body>"
                +"</html>";
        return pageContent;
    }

    private static String calculator(Request req, Response res) throws MalformedURLException, IOException {
        String pageContent;
        pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                +"<head>"
                +"<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css\">"
                +"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js\"></script>"
                +"</head>"
                + "<body>"
                +"<div class=\"center-align white-text blue darken-4\">"
                + "<h2>El numero " +req.queryParams("numero")+" elevado al cuadrado es igual a: ";

        URL url = new URL(
                "https://ukdez6464b.execute-api.us-east-1.amazonaws.com/Beta?value=" + req.queryParams("numero"));
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))){
            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                pageContent += inputLine;
            }
        } catch (IOException x) {
            System.err.println(x);
        }
        pageContent += "</h2>";
        return pageContent;
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

}