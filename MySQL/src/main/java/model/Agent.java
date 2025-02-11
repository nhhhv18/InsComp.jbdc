package model;

public class Agent {

	private int agentId;
	private String agentName;
	
	
	public Agent (int agentId, String agentName) {
		this.agentId = agentId;
		this.agentName = agentName;
	}
	public Agent () {}
	
	public int getAgentId() {
		return agentId;
	}
	
	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}
	
	public String getAgentName() {
		return agentName;
	}
	
	public void setAgentName (String agentName) {
		this.agentName = agentName;
	}
	
    @Override
    public String toString() {
        return "Agent{" +
                "agentId=" + agentId +
                ", agentName='" + agentName + '\'' +
                '}';
    }

}
	
