package model;

import lombok.Setter;
import lombok.Getter;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Claim {
	
	private int claimId;
	private int policyId;
	private String claimDate;
	private int claimAmount;
	private int claimStatusId;
	private String description;

	public Claim(int claimId, int policyId, String claimDate, int claimAmount, int claimStatusId, String description) {
	    this.claimId = claimId;
	    this.policyId = policyId;
	    this.claimDate = claimDate;
	    this.claimAmount = claimAmount;
	    this.claimStatusId = claimStatusId;
	    this.description = description;
	}
	public Claim(int policyId, String claimDate, int claimAmount, int claimStatusId, String description) {
	    this.policyId = policyId;
	    this.claimDate = claimDate;
	    this.claimAmount = claimAmount;
	    this.claimStatusId = claimStatusId;
	    this.description = description;
	}

	public Claim() {

	}

		// Getter and Setter for claimId
	    public int getClaimId() {
	        return claimId;
	    }

	    public void setClaimId(int claimId) {
	        this.claimId = claimId;
	    }

	    // Getter and Setter for policyId
	    public int getPolicyId() {
	        return policyId;
	    }

	    public void setPolicyId(int policyId) {
	        this.policyId = policyId;
	    }

	    // Getter and Setter for claimDate
	    public String getClaimDate() {
	        return claimDate;
	    }

	    public void setClaimDate(String claimDate) {
	        this.claimDate = claimDate;
	    }

	    // Getter and Setter for claimAmount
	    public int getClaimAmount() {
	        return claimAmount;
	    }

	    public void setClaimAmount(int claimAmount) {
	        this.claimAmount = claimAmount;
	    }

	    // Getter and Setter for claimStatusId
	    public int getClaimStatusId() {
	        return claimStatusId;
	    }

	    public void setClaimStatusId(int claimStatusId) {
	        this.claimStatusId = claimStatusId;
	    }

	    // Getter and Setter for description
	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    @Override
	    public String toString() {
	        return "Claim{" +
	                "claimId=" + claimId +
	                ", policyId=" + policyId +
	                ", claimDate='" + claimDate + '\'' +
	                ", claimAmount=" + claimAmount +
	                ", claimStatusId=" + claimStatusId +
	                ", description='" + description + '\'' +
	                '}';
	    }


}