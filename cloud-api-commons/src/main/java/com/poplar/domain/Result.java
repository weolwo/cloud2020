package com.poplar.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Create BY poplar ON 2020/3/28
 */
@Data
@NoArgsConstructor
public class Result<T> {

    private Integer code;

    private String message;

    private Object data;

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Result success(Object data) {
        return new Result(0, "success", data);
    }

    public static Result success(String message, Object data) {
        return new Result(0, message, data);
    }

    public static Result fail(String message) {
        return new Result(-1, message, null);
    }
}
