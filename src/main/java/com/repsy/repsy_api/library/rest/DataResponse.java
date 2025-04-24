package com.repsy.repsy_api.library.rest;

import java.util.List;


public class DataResponse<T> {
    private List<T> items = List.of();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("listItems: ");
        if (items != null) {
            items.forEach(item -> {
                sb.append(item.toString());
                sb.append('\n');
            });
        }
        return sb.toString();
    }

    public DataResponse(List<T> items) {
        this.items = items;
    }

    public DataResponse() {
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
