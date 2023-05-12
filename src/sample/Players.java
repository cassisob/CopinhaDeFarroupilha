package sample;

import java.util.Objects;

public class Players {

	private String nick;
	private String steam;
	private String name;
	private String city;

	public Players(String nick, String steam, String name, String city) {
		this.nick = nick;
		this.steam = steam;
		this.name = name;
		this.city = city;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public void setSteam(String steam) {
		this.steam = steam;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public String getNick() {
		return nick;
	}

	public String getSteam() {
		return steam;
	}

	public String getCity() {
		return city;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Players players = (Players) o;
		return Objects.equals(nick, players.nick) &&
				Objects.equals(steam, players.steam) &&
				Objects.equals(name, players.name) &&
				Objects.equals(city, players.city);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nick, steam, name, city);
	}
}