package com.aluracursos.conversor.model;

public class CurrencyConverted {
    private String baseCurrency;
    private String targetCurrency;
    private double conversionRate;

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public double getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(double conversionRate) {
        this.conversionRate = conversionRate;
    }

    public CurrencyConverted(ExchangeRate exchangeRate) {
        this.baseCurrency = exchangeRate.base_code();
        this.targetCurrency = exchangeRate.target_code();
        this.conversionRate = exchangeRate.conversion_rate();
    }
}
