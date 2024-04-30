package org.example;

import org.apache.commons.io.comparator.SizeFileComparator;
import org.apache.commons.io.filefilter.FileFileFilter;

import java.io.File;
import java.io.FileFilter;

public class Main {
    public static void main(String[] args) {
        File currentDirectory = new File(".");
        SizeFileComparator comparator = new SizeFileComparator();

        File[] sortedFiles =
                comparator.sort(currentDirectory.listFiles((FileFilter) FileFileFilter.FILE));

        System.out.println("Sorted By Size: ");
        for(File file:sortedFiles) {
            System.out.println(file.getName() + ", size(kb) :" + file.length());
        }
    }
}