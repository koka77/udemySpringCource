package org.treguluvcource.aop;

public class Student {
    private String nameSurname;
    private int cource;
    private double avgGrade;

    public Student(String nameSurname, int cource, double avgGrade) {
        this.nameSurname = nameSurname;
        this.cource = cource;
        this.avgGrade = avgGrade;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public int getCource() {
        return cource;
    }

    public void setCource(int cource) {
        this.cource = cource;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "nameSurname='" + nameSurname + '\'' +
                ", cource=" + cource +
                ", avgGrade=" + avgGrade +
                '}';
    }
}
