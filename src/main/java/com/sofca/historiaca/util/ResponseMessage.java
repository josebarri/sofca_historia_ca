package com.sofca.historiaca.util;

public record ResponseMessage<T> (
    int code,
    String message,
    T data
    ){
}
