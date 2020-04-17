package org.example;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;


import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {


        System.out.println("Hello World!");

        try {
            // create a writer
            BufferedWriter writer = Files.newBufferedWriter(Paths.get("D:\\customer.json"));

            // create customer object

            JSONObject customer = new JSONObject();
            customer.put("id", 1);
            customer.put("name", "John Doe");
            customer.put("email", "john.doe@example.com");
            customer.put("age", 32);

            // create address object
            JSONObject address = new JSONObject();
            address.put("street", "155 Middleville Road");
            address.put("city", "New York");
            address.put("state", "New York");
            address.put("zipCode", 10045);

            // add address to customer
            customer.put("address", address);

            // add customer payment methods
            JSONArray pm = new JSONArray();

            pm.put(Arrays.asList("PayPal", "Stripe"));
            customer.put("paymentMethods", pm);

            // create projects
            JSONArray projects = new JSONArray();

            // create 1st project
            JSONObject p1 = new JSONObject();
            p1.put("title", "Business Website");
            p1.put("budget", 4500);

            // create 2nd project
            JSONObject p2 = new JSONObject();
            p2.put("title", "Sales Dashboard");
            p2.put("budget", 8500);

            // add projects
            projects.put(Arrays.asList(p1, p2));

            // add projects to customer
            customer.put("projects", projects);

            System.out.println(customer.toString(1));

            writer.write(customer.toString(1));

            //close the writer
            writer.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}