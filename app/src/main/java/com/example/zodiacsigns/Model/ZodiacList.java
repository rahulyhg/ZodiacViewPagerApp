package com.example.zodiacsigns.Model;

import java.util.List;

public class ZodiacList {
    private List<ZodiacSign> zodiac;

    public ZodiacList(List<ZodiacSign> zodiac) {
        this.zodiac = zodiac;
    }

    public List<ZodiacSign> getZodiacList() {
        return zodiac;
    }
}
