package com.fanhanfei.common.collections;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangjunshuai
 * @date 2020/3/10
 * @description
 **/
public class StringListUtils {

    /**
     * 转换string 到list
     * @param sourceStr
     * @param splitKey
     * @param ignoreList
     * @return
     */
    public static List<String> stringToList(String sourceStr,String splitKey,List<String> ignoreList){
        if (StringUtils.isNotBlank(sourceStr)){
            String[] split = sourceStr.split(splitKey);
            List<String> objects = CollectionUtils.isNotEmpty(ignoreList) ? ignoreList : Collections.emptyList();
            return Arrays.stream(split)
                    .filter(kk -> StringUtils.isNotBlank(kk) && !objects.contains(kk))
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    public static List<String> stringToListWithDistinct(String sourceStr,String splitKey,List<String> ignoreList){
        return stringToList(sourceStr, splitKey, ignoreList)
                .stream()
                .distinct()
                .collect(Collectors.toList());
    }
}
