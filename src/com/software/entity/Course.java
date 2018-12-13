package com.software.entity;

public class Course {
	public String courseid;
	public String coursename;
	public Double credit;
	public String classtype;
	public String studyway ;
	
	public Course() {
		super();
		}
	public Course(String courseid,String coursename,double credit,String classtype,String studyway) {
		super();
		this.courseid=courseid;
		this.coursename=coursename;
		this.credit=credit;
		this.classtype=classtype;
		this.studyway=studyway;
	}
	public String getCourseid() {
		return courseid;
	}
	
	public String getCoursename() {
		return coursename;
	}
	
	public String getClasstype() {
		return classtype;
	}
	
	public double getCredit() {
		return credit;
	}
	
	public void setCousername(String coursename) {
		this.coursename=coursename;
	}
	
	public String getStudyway() {
		return studyway;
	}
	
	public String toString() {
		return "woshi "+coursename+"\t"+courseid+"\t"+credit+"\t"+classtype+"\t"+studyway+"\n";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseid == null) ? 0 : courseid.hashCode());
		result = prime * result + ((coursename == null) ? 0 : coursename.hashCode());
		result = prime * result + ((credit == null) ? 0 : credit.hashCode());
		result = prime * result + ((classtype == null) ? 0 : classtype.hashCode());
		result = prime * result + ((studyway == null) ? 0 : studyway.hashCode());

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
		Course other = (Course) obj;
		if (courseid == null) {
			if (other.courseid != null)
				return false;
		} else if (!courseid.equals(other.courseid))
			return false;
		
		if (coursename == null) {
			if (other.coursename != null)
				return false;
		} else if (!coursename.equals(other.coursename))
			return false;
		
		if (credit == null) {
			if (other.credit != null)
				return false;
		} else if (!credit.equals(other.credit))
			return false;
		
		if (classtype == null) {
			if (other.classtype != null)
				return false;
		} else if (!classtype.equals(other.classtype))
			return false;
		
		if (studyway == null) {
			if (other.studyway != null)
				return false;
		} else if (!studyway.equals(other.studyway))
			return false;
		
		return true;
	}
}
