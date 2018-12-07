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
public class GetClientAccount {
    
public static void main(String[] args) {

        int port = 8080;
        String getUrl = "http://localhost:" + port + "/api/customers/{customer_id}/accounts/save";
        Client client = Client.create();
        WebResource target = client.resource(getUrl);

        ClientResponse response = target
                .queryParam("sort_code", "")
                .queryParam("account_number", "")
                .queryParam("current_balance", "")
                .queryParam("type", "")
                .queryParam("status", "")
                .get(ClientResponse.class);
        System.out.println(response.getEntity(String.class));
        try {
           // Client client = Client.create();
             port = 8080;
            String url = "http://localhost:" + port + "/api/customers/{customer_id}/accounts/echo ";
            WebResource webResource = client.resource(url);
            String input = "{\"band\":\"Metallica\" ,\"title\":\"Fade To Black\"}";
            ClientResponse response3 =  webResource.type(" application/json ")
                    .post(ClientResponse.class, input);
            String output = response3.getEntity(String.class);
            System.out.println(output);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
