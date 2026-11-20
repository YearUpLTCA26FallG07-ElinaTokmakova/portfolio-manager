package com.pluralsight;

import java.math.BigDecimal;

public abstract class FixedAsset implements Valuable {
    private String name;
    private BigDecimal marketValue;

    public FixedAsset(String name, BigDecimal marketValue) {
        this.name = name;
        this.marketValue = marketValue;
    }

    public BigDecimal getValue() {
        return marketValue;
    }
}
