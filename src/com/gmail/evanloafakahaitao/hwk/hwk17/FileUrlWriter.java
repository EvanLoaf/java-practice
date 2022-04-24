package com.gmail.evanloafakahaitao.hwk.hwk17;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUrlWriter implements Runnable {

    private String path;

    public FileUrlWriter(String path) {
        this.path = path;
    }

    @Override
    public void run() {
        synchronized (path) {
            writeUrls();
        }
    }

    public void writeUrls() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            bw.write("С:\\WebServers\\home\\testsite\\www\\myfile.txt");
            bw.newLine();
            for (int i = 0; i < 10; i++) {
                Path filepath = Paths.get(path);
                File file = new File(path);
                bw.write(filepath.toString() + i);
                bw.newLine();
                bw.write(file.getPath() + i);
                bw.newLine();
                bw.write(file.getAbsolutePath() + i);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
