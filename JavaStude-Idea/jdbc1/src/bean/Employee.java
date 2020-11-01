package bean;

import java.util.Date;

/**
 * @ author:吴云鹏
 * Date:2020/5/31
 * Time:10:38
 */
public class Employee {
    private int sid;
    private String name;
    private String dname;
    private String job;
    private Double salary;
    private Double comm;
    private Integer deptno;
    private Date join_date;

    public Employee() {
    }

    public Employee(int sid, String name, String dname, String job, Double salary, Double comm, Integer deptno, Date join_date) {
        this.sid = sid;
        this.name = name;
        this.dname = dname;
        this.job = job;
        this.salary = salary;
        this.comm = comm;
        this.deptno = deptno;
        this.join_date = join_date;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getComm() {
        return comm;
    }

    public void setComm(Double comm) {
        this.comm = comm;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public Date getJoin_date() {
        return join_date;
    }

    public void setJoin_date(Date join_date) {
        this.join_date = join_date;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", dname='" + dname + '\'' +
                ", job='" + job + '\'' +
                ", salary=" + salary +
                ", comm=" + comm +
                ", deptno=" + deptno +
                ", join_date=" + join_date +
                '}';
    }
}
