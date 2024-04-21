package org.syantovich;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SpectParser {
    List<String> roles = List.of("Romeo", "Gulieta");
    String filePath = "all.txt";
    private String currentRole = null;
    private int currentRoleIndex = -1;

    public void clearAllFiles() {
        for (String role : this.roles) {
            try {
                new File(role + ".txt").delete();
            } catch (Exception ignored) {
            }
        }
    }

    private void checkRole(String line) {
        for (int i = 0; i < this.roles.size(); i++) {
            String role = roles.get(i);

            if (line.startsWith(role + ":")) {
                this.currentRole = role;
                this.currentRoleIndex = i;
                break;
            }
        }
    }

    public void parseRoles() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            this.clearAllFiles();

            String line = br.readLine();
            List<BufferedWriter> bwList = new ArrayList<>();

            for (String role : roles) {
                bwList.add(new BufferedWriter(new FileWriter(role + ".txt", true)));
            }
            while (line != null) {

                this.checkRole(line);
                if (currentRole != null) {
                    BufferedWriter bw = bwList.get(this.currentRoleIndex);
                    System.out.println(bw);
                    bw.write(line);
                    bw.newLine();
                }
                line = br.readLine();
            }
            for (BufferedWriter bw : bwList) {
                bw.close();
            }
        } catch (FileNotFoundException exc) {
            System.out.println("File for reading is not found");
        } catch (IOException exc) {
            System.out.println("Error to read or write");
        }
    }


    public static void main(String[] args) {
        SpectParser spectParser = new SpectParser();
        spectParser.parseRoles();
    }
}
