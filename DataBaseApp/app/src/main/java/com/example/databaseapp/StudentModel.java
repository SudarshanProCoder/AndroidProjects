package com.example.databaseapp;

public class StudentModel {

        int id;
        String name, rollno, st_class, gender, elective_sub;

        public StudentModel(String name, String rollno, String st_class, String gender, String elective_sub) {
                super();
                this.name = name;
                this.rollno = rollno;
                this.st_class = st_class;
                this.gender = gender;
                this.elective_sub = elective_sub;
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getRollno() {
                return rollno;
        }

        public void setRollno(String rollno) {
                this.rollno = rollno;
        }

        public String getSt_class() {
                return st_class;
        }

        public void setSt_class(String st_class) {
                this.st_class = st_class;
        }

        public String getGender() {
                return gender;
        }

        public void setGender(String gender) {
                this.gender = gender;
        }

        public String getElective_sub() {
                return elective_sub;
        }

        public void setElective_sub(String elective_sub) {
                this.elective_sub = elective_sub;
        }
}
