package com.automation_practice.context;

public enum PaymentType {
    PAY_BY_CHECK(4),
    PAY_BY_BANK(6);

    private int referenceNumberIndex;

    PaymentType(int referenceNumberIndex) {
        this.referenceNumberIndex = referenceNumberIndex;
    }

    public int getReferenceNumberIndex() {
        return referenceNumberIndex;
    }
}
