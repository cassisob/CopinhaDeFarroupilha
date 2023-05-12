package sample.banco;

import java.io.Serializable;

public class Teams implements Serializable {
    private String born, city, contact, id_steam, name, nick, password;

    public Teams(String born, String city, String contact, String id_steam, String name, String nick, String password) {
        setBorn(born);
        setCity(city);
        setContact(contact);
        setId_steam(id_steam);
        setName(name);
        setNick(nick);
        setPassword(password);
    }

    public Teams() {}


    public void setBorn(String born) {
        this.born = born;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setId_steam(String id_steam) {
        this.id_steam = id_steam;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBorn() {
        return this.born;
    }

    public String getCity() {
        return this.city;
    }

    public String getContact() {
        return this.contact;
    }

    public String getId_steam() {
        return this.id_steam;
    }

    public String getName() {
        return this.name;
    }

    public String getNick() {
        return this.nick;
    }

    public String getPassword() {
        return this.password;
    }
}
