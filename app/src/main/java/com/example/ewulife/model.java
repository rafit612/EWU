package com.example.ewulife;

public class model {
    String instructor,course,day,time;

    public model() {
    }

    public model(String instructor, String course, String day, String time) {
        this.instructor = instructor;
        this.course = course;
        this.day = day;
        this.time = time;
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
