package model;

import lombok.Setter;
import lombok.Getter;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Policy {

	private int policyId;
	private int policyTypeId;
	private int customerId;
	private String startDate;
	private String endDate;
	private int coverageAmount;
	private int premiumAmount;
	private int agentId;
	

    public Policy(int policyId, int policyTypeId, int customerId, String startDate, String endDate, int coverageAmount, int premiumAmount, int agentId) {
        this.policyId = policyId;
        this.policyTypeId = policyTypeId;
        this.customerId = customerId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.coverageAmount = coverageAmount;
        this.premiumAmount = premiumAmount;
        this.agentId = agentId;
    }
    
    public Policy(int policyTypeId, int customerId, String startDate, String endDate, int coverageAmount, int premiumAmount, int agentId) {
        this.policyTypeId = policyTypeId;
        this.customerId = customerId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.coverageAmount = coverageAmount;
        this.premiumAmount = premiumAmount;
        this.agentId = agentId;
    }
    
    
    public Policy () {}

    // Getters and Setters
    public int getPolicyId() {
        return policyId;
    }

    public void setPolicyId(int policyId) {
        this.policyId = policyId;
    }

    public int getPolicyTypeId() {
        return policyTypeId;
    }

    public void setPolicyTypeId(int policyTypeId) {
        this.policyTypeId = policyTypeId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getCoverageAmount() {
        return coverageAmount;
    }

    public void setCoverageAmount(int coverageAmount) {
        this.coverageAmount = coverageAmount;
    }

    public int getPremiumAmount() {
        return premiumAmount;
    }

    public void setPremiumAmount(int premiumAmount) {
        this.premiumAmount = premiumAmount;
    }

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }
    
    @Override
    public String toString() {
        return "Policy {" +
                "policyId=" + policyId +
                ", policyTypeId=" + policyTypeId +
                ", customerId=" + customerId +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", coverageAmount=" + coverageAmount +
                ", premiumAmount=" + premiumAmount +
                ", agentId=" + agentId +
                '}';
    }
	
}
