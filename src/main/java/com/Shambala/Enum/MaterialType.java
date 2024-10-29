package com.Shambala.Enum;

public enum MaterialType {
    WHITE_STEEL("WHITE_STEEL");

    private final String materialType;

    MaterialType(String material) {
        this.materialType = material;
    }

    public String getMaterialType() {
        return materialType;
    }
}
