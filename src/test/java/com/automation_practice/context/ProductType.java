package com.automation_practice.context;

public enum ProductType {
    POPULAR("POPULAR"),
    BEST_SELLERS("BEST SELLERS");

    private String description;

    ProductType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
