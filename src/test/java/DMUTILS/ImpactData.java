package DMUTILS;

public class ImpactData {
	 public String name;
	    public String description;
	    public String sustainabilityMatter;
	    public String assessment;
	    public String type;
	    public String nature;
	    public String timeframe;

	    // Constructor
	    public ImpactData(String name, String description, String sustainabilityMatter,
	                      String assessment, String type, String nature, String timeframe) {
	        this.name = name;
	        this.description = description;
	        this.sustainabilityMatter = sustainabilityMatter;
	        this.assessment = assessment;
	        this.type = type;
	        this.nature = nature;
	        this.timeframe = timeframe;
	    }

	   
	    public String toString() {
	        return name + " | " + description + " | " + sustainabilityMatter + " | " +
	               assessment + " | " + type + " | " + nature + " | " + timeframe;
	    }
}
