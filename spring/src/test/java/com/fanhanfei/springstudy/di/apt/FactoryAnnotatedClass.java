package com.fanhanfei.springstudy.di.apt;

import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.MirroredTypeException;
import org.apache.commons.lang3.StringUtils;

/**
 * @author zhangjunshuai
 * @date 2019/7/10
 * @description
 * https://www.jianshu.com/p/0aaa68263892
 * https://www.jianshu.com/p/c2298bc50bab
 **/
public class FactoryAnnotatedClass {

    private TypeElement annotatedClassElement;
    private String qualifiedGroupClassName;
    private String simpleFactoryGroupName;
    private String id;

    /**
     * @throws ProcessingException if id() from annotation is null
     */
    public FactoryAnnotatedClass(TypeElement classElement) throws ProcessingException {
        this.annotatedClassElement = classElement;
        Factory annotation = classElement.getAnnotation(Factory.class);
        id = annotation.id();

        if (StringUtils.isEmpty(id)) {
            throw new ProcessingException(classElement,
                    "id() in @%s for class %s is null or empty! that's not allowed",
                    Factory.class.getSimpleName(), classElement.getQualifiedName().toString());
        }

        // Get the full QualifiedTypeName
        try {
            Class<?> clazz = annotation.type();
            qualifiedGroupClassName = clazz.getCanonicalName();
            simpleFactoryGroupName = clazz.getSimpleName();
        } catch (MirroredTypeException mte) {
            DeclaredType classTypeMirror = (DeclaredType) mte.getTypeMirror();
            TypeElement classTypeElement = (TypeElement) classTypeMirror.asElement();
            qualifiedGroupClassName = classTypeElement.getQualifiedName().toString();
            simpleFactoryGroupName = classTypeElement.getSimpleName().toString();
        }
    }

    /**
     * Get the id as specified in {@link Factory#id()}.
     * 获取在{@link Factory#id()}中指定的id
     * return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Get the full qualified name of the type specified in  {@link Factory#type()}.
     * 获取在{@link Factory#type()}指定的类型合法全名
     * @return qualified name
     */
    public String getQualifiedFactoryGroupName() {
        return qualifiedGroupClassName;
    }

    /**
     * Get the simple name of the type specified in  {@link Factory#type()}.
     * 获取在 {@link Factory#type()} 中指定的类型的简单名字
     * @return qualified name
     */
    public String getSimpleFactoryGroupName() {
        return simpleFactoryGroupName;
    }

    /**
     * The original element that was annotated with @Factory
     * 获取被@Factory注解的原始元素
     */
    public TypeElement getTypeElement() {
        return annotatedClassElement;
    }
}
