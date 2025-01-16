
interface Weather {
    int getAverageTemp();
}

enum Season implements Weather {
    WINTER {
        public String getHours() { return "11am - 5pm"; }
    },
    SPRING {
        public String getHours() { return "9am - 5pm"; }
    },
    SUMMER {
        public String getHours() { return "8am - 8pm"; }
    },
    FALL {
        public String getHours() { return "9am - 5pm"; }
    };
    public abstract String getHours();
    public int getAverageTemp() {
        return 30;
    }
}

public class TestingSeason {
    public static void main(String[] args) {
        System.out.println(Season.FALL + " -> " + Season.FALL.ordinal() + " -> " + Season.FALL.getHours() + ", Av. Temp. -> " + Season.FALL.getAverageTemp());
        Season season = Season.SUMMER;
        System.out.println(season + " -> " + season.ordinal() + " -> " + season.getHours() + ", Av. Temp -> " + season.getAverageTemp());
        
    }
}