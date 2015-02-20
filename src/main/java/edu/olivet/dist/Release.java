package edu.olivet.dist;

public class Release {
	private Version version;
	private String versionTxt;
	private Note features;
	private Note enhancements;
	private Note bugFixes;
	
	public Version getVersion() {
		return version;
	}
	public void setVersion(Version version) {
		this.version = version;
	}
	public Note getFeatures() {
		return features;
	}
	public void setFeatures(Note features) {
		this.features = features;
	}
	public Note getEnhancements() {
		return enhancements;
	}
	public void setEnhancements(Note enhancements) {
		this.enhancements = enhancements;
	}
	public Note getBugFixes() {
		return bugFixes;
	}
	public void setBugFixes(Note bugFixes) {
		this.bugFixes = bugFixes;
	}
	@Override
	public String toString() {
		return "Release [version=" + version + ", features=" + features + ", enhancements=" + enhancements + ", bugFixes=" + bugFixes + "]";
	}
	public String getVersionTxt() {
		return versionTxt;
	}
	public void setVersionTxt(String versionTxt) {
		this.versionTxt = versionTxt;
	}
}
