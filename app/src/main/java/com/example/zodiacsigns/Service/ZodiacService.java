package com.example.zodiacsigns.Service;

import com.example.zodiacsigns.Model.ZodiacList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ZodiacService {

    String END_POINT = "/JDVila/storybook/master/zodiac.json";

    @GET(END_POINT)
    Call<ZodiacList> getZodiacSigns();
}
