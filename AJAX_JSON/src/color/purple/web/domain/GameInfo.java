package color.purple.web.domain;

import java.util.List;
import java.util.Map;

public class GameInfo {
    private String station;
    private List<String> game ;

    @Override
    public String toString() {
        return "Game{" +
                "station='" + station + '\'' +
                ", game=" + game +
                ", game_credit=" + game_credit +
                '}';
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public List<String> getGame() {
        return game;
    }

    public void setGame(List<String> game) {
        this.game = game;
    }

    public Map<String, String[]> getGame_credit() {
        return game_credit;
    }

    public void setGame_credit(Map<String, String[]> game_credit) {
        this.game_credit = game_credit;
    }

    private Map<String,String[]> game_credit;
}
