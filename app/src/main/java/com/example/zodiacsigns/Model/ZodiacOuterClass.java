package com.example.zodiacsigns.Model;

import java.util.List;

public class ZodiacOuterClass {
    private List<ZodiacSign> zodiac;

    public ZodiacOuterClass(List<ZodiacSign> zodiac) {
        this.zodiac = zodiac;
    }

    public List<ZodiacSign> getZodiacList() {
        return zodiac;
    }
}
