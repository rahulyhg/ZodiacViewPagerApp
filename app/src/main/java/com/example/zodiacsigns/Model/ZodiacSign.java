package com.example.zodiacsigns.Model;

public class ZodiacSign {
    private String name;
    private String number;
    private String image;

    public ZodiacSign(String name, String number, String image) {
        this.name = name;
        this.number = number;
        this.image = image;
    }

    public String getZodiacName() {
        return name;
    }

    public String getZodiacDateRange() {
        return number;
    }

    public String getZodiacImage() {
        return image;
    }
}
