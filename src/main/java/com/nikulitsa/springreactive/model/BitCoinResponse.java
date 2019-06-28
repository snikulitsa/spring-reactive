package com.nikulitsa.springreactive.model;

import lombok.Data;

/**
 * @author Sergei Nikulitsa
 */
@Data
public class BitCoinResponse {

    private Data data;

    @lombok.Data
    public static class Data {
        private String base;
        private String currency;
        private String amount;
    }
}
