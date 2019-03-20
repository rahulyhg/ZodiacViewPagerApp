package com.example.zodiacsigns.Service;

import com.example.zodiacsigns.Model.ZodiacList;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ZodiacService {

    String END_POINT = "/JDVila/storybook/master/zodiac.json";

    @GET(END_POINT)
    Observable<ZodiacList> getZodiacSigns();

}
