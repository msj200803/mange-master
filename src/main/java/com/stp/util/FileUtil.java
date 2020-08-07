package com.stp.util;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileUtil {
    //存储File
    public static int saveFile(InputStream inputStream, String path) throws IOException {
        if (isExists(path)){ //判断文件夹创建了没
            File file = new File(path);
            if (file.exists()){ //判断文件是否存在
                file.delete();
            }
            Files.copy(inputStream, Paths.get(path));
        }
        return 1;
    }

    private static boolean isExists(String path){
        String substring = path.substring(0, path.lastIndexOf("/"));
        File file = new File(substring);
        if (!file.exists()){
            file.mkdir();
        }
        return true;
    }

}
