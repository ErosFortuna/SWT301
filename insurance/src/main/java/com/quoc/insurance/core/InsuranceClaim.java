package com.quoc.insurance;

public class InsuranceClaim {

    private String claimId;
    private double amount;
    private String claimStatus;

    // Constructor with null check
    public InsuranceClaim(String id, double claimAmount) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Claim ID cannot be null or empty");
        }
        this.claimId = id;
        this.amount = claimAmount;
        this.claimStatus = "Pending";
    }

    // Process claim with null check
    public boolean processClaim(String statusUpdate) {
        if (statusUpdate == null) {
            throw new IllegalArgumentException("Status update cannot be null");
        }

        if ("Pending".equals(claimStatus)) {
            claimStatus = statusUpdate;
            return true;
        }
        return false;
    }

    public double calculatePayout() {
        if ("Approved".equals(claimStatus)) {
            return amount * 0.85;
        }
        return 0;
    }

    public void updateClaimAmount(double newAmount) {
        if (newAmount > 0) {
            this.amount = newAmount;
        }
    }

    public String getClaimId() {
        return claimId;
    }

    public double getAmount() {
        return amount;
    }

    public String getClaimStatus() {
        return claimStatus;
    }
}
