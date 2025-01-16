package com.hmatewu.ewulife;

public class model {
    String instructor,course,day;
    String time;
   long section;

    public model() {
    }

    public model(String instructor, String course, String day, String time,long section) {
        this.instructor = instructor;
        this.course = course;
        this.day = day;
      this.time = time;
       this.section = section;
    }

    public long getSection() {
       return section;
    }

   public void setSection(long section) {
       this.section = section;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
       return time;
    }

    public void setTime(String time) {
       this.time = time;
    }
}
