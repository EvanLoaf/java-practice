package com.gmail.evanloafakahaitao.hwk.hwk17;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileUrlParserToFile implements Callable<Long> {

    private String path;

    public FileUrlParserToFile(String path) {
        this.path = path;
    }

    @Override
    public Long call() throws Exception {
        List<String> urls = new ArrayList<>();
        synchronized (path) {
            urls = parseUrls();
        }
        return writeUrls(urls);
    }

    public List<String> parseUrls() {
        List<String> filenames = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            Pattern pattern = Pattern.compile("(?<=\\\\)([a-z0-9]+\\.[a-z0-9]+)\\b");
            String line = br.readLine();
            while (line != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    System.out.println("MATCH");
                    filenames.add(matcher.group());
                }
                System.out.println(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filenames;
    }

    public Long writeUrls(List<String> filenames) {
        String newPath = "..\\my\\filenames.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(newPath))) {
            for (String filename : filenames) {
                bw.write(filename);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file = new File(newPath);
        Path filePath = Paths.get(newPath);
        Long fileLength = 0L;
        try {
            fileLength = Files.size(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("stupid file length : " + file.length());
        return fileLength;
    }
}
