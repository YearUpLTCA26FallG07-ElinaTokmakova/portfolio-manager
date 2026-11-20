package com.pluralsight;

import java.math.BigDecimal;

public abstract class FixedAsset implements Valuable {
    private final String name;
    private final BigDecimal marketValue;

    public FixedAsset(String name, BigDecimal marketValue) {
        this.name = name;
        this.marketValue = marketValue;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getMarketValue() {
        return marketValue;
    }

    public BigDecimal getValue() {
        return marketValue;
    }
}
