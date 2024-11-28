package com.example.labassignment3;



class Person {
    private String name;
    private String fatherName;
    private String cnic;
    private String dob;
    private String gender;
    private String city;

    public Person(String name, String fatherName, String cnic, String dob, String gender, String city) {
        this.name = name;
        this.fatherName = fatherName;
        this.cnic = cnic;
        this.dob = dob;
        this.gender = gender;
        this.city = city;
    }


    @Override
    public String toString() {

        return String.format(
                "----- Person Details -----\n" +
                        "%-15s : %s\n" +
                        "%-15s : %s\n" +
                        "%-15s : %s\n" +
                        "%-15s : %s\n" +
                        "%-15s : %s\n" +
                        "%-15s : %s\n" +
                        "--------------------------",
                "Name", name,
                "Father's Name", fatherName,
                "CNIC", cnic,
                "Date of Birth", dob,
                "Gender", gender,
                "City", city
        );


//        return String.format("Name : " +name + "\nFather's Name : " +fatherName +
//                "\nCNIC : " +cnic + "\nGender : " +gender + "\nDOB : " +dob +
//                "\nCity : " +city );
//    }
//        return "Person{" +
//                "name='" + name + '\'' +
//                ", fatherName='" + fatherName + '\'' +
//                ", cnic='" + cnic + '\'' +
//                ", city='" + city + '\'' +
//                ", dob='" + dob + '\'' +
//                ", gender='" + gender + '\'' +
//                '}';
    }
}