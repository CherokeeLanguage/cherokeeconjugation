package net.cherokeedcitionary.verbal.stemming;

public class PatternMatchReplacement implements Comparable<PatternMatchReplacement>{
    public String regexmatch;
	public String[] match;
	public String[] replacement;
	@Override
	public int compareTo(PatternMatchReplacement o) {
		return -getSortId().compareTo(o.getSortId());
	}
	private String idnumber =null;
	public String getSortId(){
		if (idnumber!=null) {
			return idnumber;
		}
		int len=0;
		for (String r: replacement) {
			len=Math.min(len, r.length());
		}
		StringBuilder id = new StringBuilder();
		if (len<1000){
			id.append("0");
		}
		if (len<100){
			id.append("0");
		}
		if (len<10) {
			id.append("0");
		}
		id.append(len);
		id.append(regexmatch);
		idnumber=id.toString();
		return idnumber;
	}
}