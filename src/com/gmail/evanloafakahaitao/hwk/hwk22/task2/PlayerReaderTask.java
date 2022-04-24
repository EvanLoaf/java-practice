package com.gmail.evanloafakahaitao.hwk.hwk22.task2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PlayerReaderTask implements Callable<List<Player>> {

    private String path;

    public PlayerReaderTask(String path) {
        this.path = path;
    }

    @Override
    public List<Player> call() throws Exception {
        List<Player> allPlayers = getPlayers();
        List<Player> activeMaturePlayers = getMatureActive(allPlayers);
        return activeMaturePlayers;
    }

    public List<Player> getPlayers() {
        List<Player> playerList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            Pattern namePattern = Pattern.compile("(?<=name=\\')([a-zA-Z0-9[\\-]]+?)\\'");
            Pattern agePattern = Pattern.compile("(?<=age=)(\\d+?)\\,");
            Pattern activePattern = Pattern.compile("(?<=isActive=)(true|false)\\}");
            while (line != null) {
                Matcher nameMatcher = namePattern.matcher(line);
                String name;
                if (nameMatcher.find()) {
                    name = nameMatcher.group(1);
                } else name = null;
                Matcher ageMatcher = agePattern.matcher(line);
                int age;
                if (ageMatcher.find()) {
                    age = Integer.parseInt(ageMatcher.group(1));
                } else age = 0;
                Matcher activeMatcher = activePattern.matcher(line);
                boolean isActive;
                if (activeMatcher.find()) {
                    isActive = Boolean.valueOf(activeMatcher.group(1));
                } else isActive = false;
                Player player = new Player(name, age, isActive);
                playerList.add(player);
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return playerList;
    }

    public List<Player> getMatureActive(List<Player> playerList) {
        List<Player> matureActivePlayers = playerList.stream()
                .filter(player -> player.getAge() >= 25 && player.getAge() <=30 && player.isActive() == true)
                .collect(Collectors.toList());
        return matureActivePlayers;
    }
}
