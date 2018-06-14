package com.thor.pawPrint.core.utils.file;

import com.thor.pawPrint.core.common.constant.CharsetConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Expand;
import org.springframework.util.ObjectUtils;

import java.io.File;

/**
 * 压缩工具类
 * Created by Thor on 2017/2/6.
 * happy coding - 1203!
 */
@Slf4j
public class ZipUtil {
    private static final String UN_ZIP_DEFAULT_TASK_NAME = "UNZIP";
    private static final String UN_ZIP_DEFAULT_TASK_TYPE = "UNZIP";

    public static boolean unZip(String zipPath, String destinationPath) {
        if (ObjectUtils.isEmpty(zipPath) || ObjectUtils.isEmpty(destinationPath)) {
            return false;
        }

        File zipFile = new File(zipPath);
        if (!zipFile.exists()) {
            log.error("zip file " + zipPath + " does not exist.");
            return false;
        }

        Project project = new Project();
        Expand expand = new Expand();

        expand.setProject(project);
        expand.setTaskType(UN_ZIP_DEFAULT_TASK_TYPE);
        expand.setTaskName(UN_ZIP_DEFAULT_TASK_NAME);
        expand.setSrc(zipFile);
        expand.setDest(new File(destinationPath));
        expand.setEncoding(CharsetConstant.GBK);
        expand.execute();

        return true;
    }

}
