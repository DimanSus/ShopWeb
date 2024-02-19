package com.example.shopweb.services;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

@Service
public class CarencyService {
    public  double getEurPrice(double bynPrice){
        try {
            URL url = new URL("https://api.nbrb.by/exrates/rates/EUR?parammode=2");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            String course = bufferedReader.readLine();
            JSONObject jsonObject = new JSONObject(course);
            double eur = Double.parseDouble(jsonObject.get("Cur_OfficialRate").toString());
            return (bynPrice/eur)-(bynPrice/eur)%0.01;
        }catch (Exception e){
            return -10;
        }
    }

    public  double getUsdPrice(double bynPrice){
        try {
            URL url = new URL("https://api.nbrb.by/exrates/rates/USD?parammode=2");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            String course = bufferedReader.readLine();
            JSONObject jsonObject = new JSONObject(course);
            double usd = Double.parseDouble(jsonObject.get("Cur_OfficialRate").toString());
            return (bynPrice/usd)-(bynPrice/usd)%0.01;
        }catch (Exception e){
            return -10;
        }
    }
}
