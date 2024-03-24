package org.syantovich;

import java.io.*;

public class SpectParser {
    String[] roles;
    String filePath;
    private String currentRole = null;

    public SpectParser(String[] roles, String fileWithAllRolesPath) {
        this.roles = roles;
        this.filePath = fileWithAllRolesPath;
    }

    public SpectParser(String filePath) {
        this(new String[]{"Romeo", "Gulieta"}, filePath);
    }

    public void removeAllRolesFiles() {
        for (String role : roles) {
            try {
                new File(String.format("%s.txt", role)).delete();
            } catch (Exception ignored) {
            }
        }
    }

    public void parseRoles() {
        this.removeAllRolesFiles();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            do {
                for (String role : roles) {
                    System.out.print(line.startsWith(String.format("%s:", role)) + " - ");
                    System.out.println(line);
                    if (line.startsWith(String.format("%s:", role))) {
                        this.currentRole = role;
                    }
                }
                System.out.println(line);
                if (currentRole != null) {
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(String.format("%s.txt", currentRole), true))) {
                        bw.write(line);
                        bw.newLine();
                    } catch (Exception ignored) {
                    }
                }
                line = br.readLine();
            } while (line != null);
        } catch (Exception ignored) {
            System.out.println(ignored);
        }
    }


    public static void main(String[] args) {
        SpectParser spectParser = new SpectParser("all.txt");
        spectParser.parseRoles();
    }
}
