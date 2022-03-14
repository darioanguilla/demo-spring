package com.example.demo;


public class LoadDriver {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (Exception ex){

        }
    }
}
