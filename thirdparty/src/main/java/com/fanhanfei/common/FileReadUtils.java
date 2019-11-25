package com.fanhanfei.common;

import com.google.common.base.Charsets;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author zhangjunshuai
 * @date 2019/10/30
 * @description
 **/
@Slf4j
public class FileReadUtils {

    public static List<String> getContentFromCsv(String path){
        File testFile = new File(path);
        List<String> lines = null;
        try {
            lines = com.google.common.io.Files.readLines(testFile, Charsets.UTF_8);
        } catch (IOException e) {
            log.error("读取数据异常",e);
        }
        return lines;
    }
}
