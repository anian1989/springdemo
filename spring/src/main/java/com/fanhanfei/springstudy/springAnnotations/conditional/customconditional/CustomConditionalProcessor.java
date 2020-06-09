package com.fanhanfei.springstudy.springAnnotations.conditional.customconditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author zhangjunshuai
 * @date 2020/6/9
 * @description
 **/
public class  CustomConditionalProcessor implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(ConditionalOnCustom.class.getName());
        System.out.println("读取@ConditionalOnCustom所有AnnotationAttributes:"+annotationAttributes);
        String property = context.getEnvironment().getProperty("os.names");
        System.out.println("读取配置信息："+property);
        if (Objects.nonNull(annotationAttributes)
                &&Objects.nonNull(annotationAttributes.get("osnames"))) {
            String[] osnames = (String[])annotationAttributes.get("osnames");
            List<String> list = Arrays.asList(osnames);
            System.out.println("读取@ConditionalOnCustom的osnames信息："+list);
            return list.contains(property);
        }

        return false;
    }
}
