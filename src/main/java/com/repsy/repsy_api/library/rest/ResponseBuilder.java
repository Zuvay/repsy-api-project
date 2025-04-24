package com.repsy.repsy_api.library.rest;

import java.util.List;


public class ResponseBuilder {
    public ResponseBuilder() {
    }

    public static <T> Response<DataResponse<T>> build(List<T> items) {
        return new Response<>(new DataResponse<>(items));
    }


    public static <T> Response<T> build(T item) {
        return new Response<>(item);
    }

    public static Response<MetaResponse> build(MetaResponse metaResponse) {
        return new Response<>(metaResponse);
    }
}
