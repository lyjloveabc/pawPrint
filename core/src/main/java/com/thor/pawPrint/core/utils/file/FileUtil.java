package com.thor.pawPrint.core.utils.file;

import org.springframework.util.ObjectUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 文件操作工具类
 * Created by Thor on 2017/2/6.
 * happy coding - 1203!
 */
public class FileUtil {
    /**
     * 一次性写入文件，使用NIO
     *
     * @param data 数据
     * @param path 路径
     * @param name 文件名（包含扩展名）
     * @return 写操作是否成功
     */
    public static boolean write(byte[] data, String path, String name) {
        if (ObjectUtils.isEmpty(data) || ObjectUtils.isEmpty(name)) {
            return false;
        }

        boolean flag = true;
        boolean pathFlag = ObjectUtils.isEmpty(path);

        if (!pathFlag) {
            File pathDir = new File(path);

            //没有文件夹则创建文件夹
            if (!pathDir.exists() && !pathDir.isDirectory()) {
                //创建文件夹成功
                if (!pathDir.mkdir()) {
                    //创建文件夹失败
                    flag = false;
                }
            }
        }

        String fullFileName = pathFlag ? name : path + File.separator + name;

        //已经存在该名字的文件则删除该文件
        File file = new File(fullFileName);
        if (file.exists()) {
            if (!file.delete()) {
                //删除文件失败
                flag = false;
            }
        }

        if (flag) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(fullFileName);
                FileChannel fileChannel = fileOutputStream.getChannel();

                ByteBuffer byteBuffer = ByteBuffer.allocate(data.length);
                byteBuffer.put(data);

                fileChannel.write(byteBuffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return flag;
    }

}
