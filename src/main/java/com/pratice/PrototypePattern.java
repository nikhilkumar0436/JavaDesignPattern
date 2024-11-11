package com.pratice;


public class PrototypePattern {
    public static void main(String[] args) {
        ProtoTypeBuilder emp=new Employee(1,"Jane","Admin");
        System.out.println(emp.toString());
        CloneClient cloneClient=new CloneClient(emp);
        ProtoTypeBuilder clone=cloneClient.createClone();
        System.out.println(clone.toString());

    }
}
//Expected result
//Employee{empId=1, name='Jane', dept='Admin'}
//Employee{empId=1, name='Jane', dept='Admin'
interface ProtoTypeBuilder {
    ProtoTypeBuilder getclone();
}
class CloneClient {
    private ProtoTypeBuilder protoTypeBuilder;
    public  CloneClient(ProtoTypeBuilder protoTypeBuilder){
        this.protoTypeBuilder=protoTypeBuilder;
    }

    public ProtoTypeBuilder createClone() {
        return protoTypeBuilder.getclone();
    }
}

class Employee implements ProtoTypeBuilder {
    public Employee(Integer empId, String name, String dept) {
        this.empId = empId;
        this.name = name;
        this.dept = dept;
    }

    private Integer empId;
    private String name;
    private String dept;

    @Override
    public ProtoTypeBuilder getclone() {
        return new Employee(empId,name,dept);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                '}';
    }
}