package com.org.java.test;

public class LoadBalancerInput {

	String ip;
	int weight;
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public LoadBalancerInput(String ip, int weight) {
		super();
		this.ip = ip;
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "LoadBalancerInput [ip=" + ip + ", weight=" + weight + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ip == null) ? 0 : ip.hashCode());
		result = prime * result + weight;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoadBalancerInput other = (LoadBalancerInput) obj;
		if (ip == null) {
			if (other.ip != null)
				return false;
		} else if (!ip.equals(other.ip))
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}
	
	public int compareTo(LoadBalancerInput obj) {
		if(this.getWeight() < obj.getWeight())
			return 1;
		else
			return 0;
	}

}
//COmparator class to compare ActiveRegexRxRule objects
	class ArrayCustomizedSorting implements java.util.Comparator<LoadBalancerInput>{

		  @Override
		  public int compare(LoadBalancerInput obj1, LoadBalancerInput obj2) {
		    return -obj1.compareTo(obj2);
		 }
	}
