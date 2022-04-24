package com.gmail.evanloafakahaitao.prac.class13.supatask;

import com.gmail.evanloafakahaitao.util.InputService;

import java.io.*;
import java.nio.file.*;

public class MyDirectoryService {

    public boolean createDirectories(Path directory) {
        File file = new File(directory.toString());
        return file.mkdirs();
    }

    public void createAndFillFiles(Path directory, int files, int numbersPerFile) {
        for (int i = 0; i < files; i++) {
            File file = new File(String.format("%s%sMyFile%d.txt", directory.toString(), FileSystems.getDefault().getSeparator(), i));
            /*file.delete();*/
            try (FileWriter fw = new FileWriter(file, true)) {
                /*boolean success = file.createNewFile();*/
                if (!file.exists()) file.createNewFile();
                for (int j = 0; j < numbersPerFile; j++) {
                    fw.write(String.valueOf(InputService.getRandomNumberInRange(0, 10)));
                    fw.write(System.lineSeparator());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void readFilesAndAssemble(Path directory) {
        File file = new File(directory.toString());
        /*FilenameFilter filenameFilter = (dir, name) -> name.endsWith(".txt"); // dir.isFile() && name.endsWith(".txt")*/
        FileFilter fileFilter = pathname -> pathname.isFile() && pathname.getName().endsWith(".txt");
        String mergedFile = directory.toString() + "\\merge.txt";
        File[] files = file.listFiles(fileFilter);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(mergedFile))) {
            for (File myFile : files) {
                try (BufferedReader br = new BufferedReader(new FileReader(myFile))) {
                    String line = br.readLine();
                    while (line != null) {
                        bw.write(line);
                        bw.write(System.lineSeparator());
                        line = br.readLine();
                    }
                }
            }
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void showCatalogue(Path directory) {
        File file = new File(directory.toString());
        File[] files = file.listFiles();
        StringBuilder directoryContent = new StringBuilder();
        String fileOrDir = null;
        for (File myFile : files) {
            /*if (myFile.isDirectory()) {
                fileOrDir = "Directory";
            } else fileOrDir = "File(?)";*/
            if (myFile.isFile()) {
                fileOrDir = "File(?)";
            } else fileOrDir = "Directory";
            directoryContent.append(String.format("%s : %s%n", fileOrDir, myFile.getName()));
        }
        System.out.println("DIRECTORY CONTENT : %n%n\n");
        System.out.println(directoryContent);
    }

}
