package com.fanhanfei.pattern.jike.create.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("单例测试")
public class SimpleSingleTest {

    static Stream<Arguments> testGetProvider() {
        return Stream.of(
                arguments(2, 1, 100),
                arguments(3, 12, 100)
        );
    }
    @Test
    @DisplayName("饿汉模式")
    @MethodSource("testGetProvider")
    public void Simple(){
        long id = SimpleSingle.getInstance().getId();

    }

}
