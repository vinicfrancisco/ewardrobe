package com.example.ewardrobeapp.models;

public class User {
    private String id;
    private String name;
    private String nickname;
    private String genre;
    private String email;
    private String password;


    public User(String id, String name, String nickname, String genre, String email, String password) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.genre = genre;
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
