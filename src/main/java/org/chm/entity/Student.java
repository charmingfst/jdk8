package org.chm.entity;

/**
 * Created by charming on 2017/2/10.
 */
public class Student {
    private String name;
    private int score;

    public Student(String name, int socre) {
        this.name = name;
        this.score = socre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public static int compareStudentByName(Student s1, Student s2) {
        return s1.getName().compareToIgnoreCase(s2.getName());
    }


    public static int compareStudentByScore(Student s1, Student s2) {
        return s1.getScore() - s2.getScore();
    }

    public int compareByName(Student std) {
        return this.getName().compareToIgnoreCase(std.getName());
    }

    public int compareBySocre(Student std) {
        return this.getScore() - std.getScore();
    }

}
