package org.kimbs.demo.document.code;

import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
public enum JobCode {

      CLERK("clerk")
    , SALESMAN("salesman")
    , MANAGER("manager")
    , ANALYST("analyst")
    , PRESIDENT("president");

    private String code;

    JobCode(String code) {
        this.code = code;
    }

    private static Map<String, JobCode> map = Arrays.stream(values()).collect(Collectors.toMap(JobCode::getCode, Function.identity()));

    public static JobCode fromValue(String value) throws IllegalArgumentException {
        return Optional.ofNullable(map.get(value)).orElseThrow(() -> new IllegalArgumentException("Not exists code : " + value));
    }
}
