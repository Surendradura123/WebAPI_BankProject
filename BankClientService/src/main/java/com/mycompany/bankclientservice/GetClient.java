/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankclientservice;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 *
 * @author suren
 */
public class GetClient {

    public static void main(String[] args) {

        int port = 8080;
        String getUrl = "http://localhost:" + port + "/api/customers/save";
        Client client = Client.create();
        WebResource target = client.resource(getUrl);

        ClientResponse response = target
                .queryParam("first_name", "name")
                .queryParam("last_name", "surname")
                .queryParam("address", "")
                .queryParam("phone_number", "")
                .queryParam("email", "")
                .queryParam("inputted_password", "")
                .get(ClientResponse.class);
        System.out.println(response.getEntity(String.class));
        try {
           // Client client = Client.create();
             port = 8080;
            String url = "http://localhost:" + port + "/api/customers/echo ";
            WebResource webResource = client.resource(url);
            String input = "{\"band\":\"Metallica\" ,\"title\":\"Fade To Black\"}";
            ClientResponse response2 =  webResource.type(" application/json ")
                    .post(ClientResponse.class, input);
            String output = response2.getEntity(String.class);
            System.out.println(output);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
