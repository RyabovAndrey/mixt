package Races;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Race {
    private double distance;
    private Horse[] horses;
    private boolean isOver;

    public Race(double distance) {
        this.distance = distance;
        horses=new Horse[3];
        horses[0]=new Horse("Быстрый");
        horses[1]=new Horse("Ленивый");
        horses[2]=new Horse("Пегий");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String string="";
        while (!string.equals("exit")) {
            System.out.println("Введите номер лошади (от 1 до 3) или exit для выхода");
            string = reader.readLine();
            if (!string.equals("exit")) {
                if (isNumber(string)) {
                    Race race = new Race(500.0);
                    while(true) {
                        for (int i = 0; i <3 ; i++) {
                            race.horses[i].doStep();
                            System.out.println(race.horses[i].getDistance());
                            if (!race.isOver && race.horses[i].getDistance()>=race.distance) {
                                race.isOver=true;
                            }
                        }
                        if (race.isOver) {
                            return;
                        }
                    }
                }
            }
        }

    }

    public static boolean isNumber(String string) {
        if (string.length()!=1) {
            return false;
        }
        return (string.getBytes()[0] >= 48 && string.getBytes()[0] <= 50);
    }


}
