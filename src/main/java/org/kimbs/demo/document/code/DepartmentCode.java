package org.kimbs.demo.document.code;

import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
public enum DepartmentCode {
    ACCOUNTING(10)
    , RESEARCH(20)
    , SALES(30)
    , OPERATIONS(40);

    private int departmentId;

    DepartmentCode(int departmentId) {
        this.departmentId = departmentId;
    }

    private static Map<Integer, DepartmentCode> map = Arrays.stream(values()).collect(Collectors.toMap(DepartmentCode::getDepartmentId, Function.identity()));

    public static DepartmentCode fromValue(int departmentId) {
        return Optional.ofNullable(map.get(departmentId)).orElseThrow(() -> new IllegalArgumentException("Not exists departmentId : " + departmentId));
    }
}
