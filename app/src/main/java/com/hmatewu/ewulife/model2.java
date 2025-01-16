package com.hmatewu.ewulife;

public class model2 {
    String Course,Room,Start,Start2,Instructor,Section,day,ref;

    public model2(String course, String room, String start, String start2, String instructor, String section, String day, String ref) {
        Course = course;
        Room = room;
        Start = start;
        Start2 = start2;
        Instructor = instructor;
        Section = section;
        this.day = day;
        this.ref = ref;
    }

    public String getCourse() {
        return Course;
    }

    public void setCourse(String course) {
        Course = course;
    }

    public String getRoom() {
        return Room;
    }

    public void setRoom(String room) {
        Room = room;
    }

    public String getStart() {
        return Start;
    }

    public void setStart(String start) {
        Start = start;
    }

    public String getStart2() {
        return Start2;
    }

    public void setStart2(String start2) {
        Start2 = start2;
    }

    public String getInstructor() {
        return Instructor;
    }

    public void setInstructor(String instructor) {
        Instructor = instructor;
    }

    public String getSection() {
        return Section;
    }

    public void setSection(String section) {
        Section = section;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public model2() {
    }
}
