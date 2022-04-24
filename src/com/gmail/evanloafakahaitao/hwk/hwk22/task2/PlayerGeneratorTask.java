package com.gmail.evanloafakahaitao.hwk.hwk22.task2;

import com.gmail.evanloafakahaitao.util.InputService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class PlayerGeneratorTask implements Callable<String> {

    private int numberOfPlayers;

    public PlayerGeneratorTask(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    @Override
    public String call() throws Exception {
        String path = String.format("my\\%s__players.txt", Thread.currentThread().getName());
        List<Player> playerList = generatePlayers();
        writePlayers(path, playerList);
        return path;
    }

    private List<Player> generatePlayers() {
        List<Player> playerList = new ArrayList<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            Player player = new Player(
                    "NameXD-" + Thread.currentThread().getName() + "-" + i,
                    InputService.getRandomNumberInRange(20, 40),
                    ThreadLocalRandom.current().nextBoolean()
            );
            playerList.add(player);
        }
        return playerList;
    }

    private void writePlayers(String path, List<Player> playerList) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (Player player : playerList) {
                bw.write(player.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
