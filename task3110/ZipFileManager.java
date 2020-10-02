package com.javarush.task.task31.Archiver.task3110;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileManager {
    private Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception {

        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile));
             InputStream inputStream = Files.newInputStream(source)) {
            ZipEntry entry1 = new ZipEntry(source.getFileName().toString());
            zipOutputStream.putNextEntry(entry1);


            while (inputStream.available() > 0) {
                zipOutputStream.write(inputStream.read());
            }


        }
    }
}
