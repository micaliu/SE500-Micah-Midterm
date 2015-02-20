package edu.olivet.dist;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Version implements Comparable<Version>  {
	private int majorVersion;
	private int minorVersion;
	private Date createTime;
	private int patchNo;
	private String alias;
	
	@Override
	public int compareTo(Version o) {
		int rc = majorVersion - o.getMajorVersion();
		if (rc != 0) {
			return -rc;
		}
		
		rc = minorVersion - o.getMinorVersion();
		if (rc != 0) {
			return -rc;
		}
		
		rc = createTime.compareTo(o.getCreateTime());
		if (rc != 0) {
			return -rc;
		}
		
		return -(patchNo - o.getPatchNo());
	}

	public int getMajorVersion() {
		return majorVersion;
	}
	public void setMajorVersion(int majorVersion) {
		this.majorVersion = majorVersion;
	}
	public int getMinorVersion() {
		return minorVersion;
	}
	public void setMinorVersion(int minorVersion) {
		this.minorVersion = minorVersion;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getPatchNo() {
		return patchNo;
	}
	public void setPatchNo(int patchNo) {
		this.patchNo = patchNo;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	@Override
	public String toString() {
		String lastDay = new SimpleDateFormat("yyyy-MM-dd").format(createTime);
		return String.format("%s.%s-%s.%s=%s", majorVersion, minorVersion, lastDay, patchNo, alias);
	}
	
	public String code() {
		String lastDay = new SimpleDateFormat("yyyy-MM-dd").format(createTime);
		return String.format("%s.%s-%s.%s", majorVersion, minorVersion, lastDay, patchNo);
	}
}
