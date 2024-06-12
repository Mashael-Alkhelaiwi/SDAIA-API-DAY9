package org.example.dto;

import jakarta.ws.rs.QueryParam;

public class EmployeeFilterDto {
    private @QueryParam("job_id") Integer job_id;
    private @QueryParam("hireYear") String hireYear;
    private @QueryParam("limit") Integer limit;
    private @QueryParam("offset") int offset;

    public String getHireYear() {
        return hireYear;
    }

    public void setHireYear(String hireYear) {
        this.hireYear = hireYear;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getJob_id() {
        return job_id;
    }

    public void setJob_id(Integer job_id) {
        this.job_id = job_id;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}