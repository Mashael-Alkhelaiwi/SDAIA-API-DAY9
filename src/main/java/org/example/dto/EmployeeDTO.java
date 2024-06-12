package org.example.dto;

public class EmployeeDTO
{

    private String deptCode;
    private int IdSequence;
    private int hireYear;



    public void EmployeeDto(String deptCode, int idSequence, int hireYear) {
        this.deptCode = deptCode;
        IdSequence = idSequence;
        this.hireYear = hireYear;
    }

    public void EmployeeDto() {

    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public int getIdSequence() {
        return IdSequence;
    }

    public void setIdSequence(int idSequence) {
        IdSequence = idSequence;
    }

    public int getHireYear() {
        return hireYear;
    }

    public void setHireYear(int hireYear) {
        this.hireYear = hireYear;
    }

    @Override
    public String toString() {
        return deptCode + IdSequence + hireYear;
    }
}