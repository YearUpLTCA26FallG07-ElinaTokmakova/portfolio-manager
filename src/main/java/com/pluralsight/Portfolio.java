package com.pluralsight;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Portfolio implements Valuable {
    private String name;
    private String owner;
    private List<Valuable> assets;

    public Portfolio(String name, String owner) {
        this.name = name;
        this.owner = owner;
        this.assets = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    // Adds valuable to assets List
    public void add(Valuable asset) {
        assets.add(asset);
    }

    // Returns net value of all assets
    public BigDecimal getValue() {
        BigDecimal total = BigDecimal.ZERO;
        for (Valuable v : assets) {
            total = total.add(v.getValue());
        }
        return total.setScale(2, RoundingMode.HALF_UP);
    }

    // Returns the asset that has the highest value
    public BigDecimal getMostValuable() {
        BigDecimal maxValue = assets.get(0).getValue();
        for (int i = 1; i < assets.size(); i++) {
            if (assets.get(i).getValue().compareTo(maxValue) > 0) {
                maxValue = assets.get(i).getValue();
            }
        }
        return maxValue.setScale(2, RoundingMode.HALF_UP);
    }

    // Returns the asset that has the lowest value
    public BigDecimal getLeastValuable() {
        BigDecimal minValue = assets.get(0).getValue();
        for (int i = 1; i < assets.size(); i++) {
            if (assets.get(i).getValue().compareTo(minValue) < 0) {
                minValue = assets.get(i).getValue();
            }
        }
        return minValue.setScale(2, RoundingMode.HALF_UP);
    }

    // Returns all assets in assets list
    public void getAllAssets() {
        for (Valuable v : assets) {
            System.out.println(v);
        }
    }
}
