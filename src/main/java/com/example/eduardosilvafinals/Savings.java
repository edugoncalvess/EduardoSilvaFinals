package com.example.eduardosilvafinals;

public class Savings {

    private String custno;
    private String custname;
    private Double cdep;
    private Integer nyears;
    private String savtype;


    public Savings(String custno, String custname, Double cdep, Integer nyears, String savtype) {
        this.custno = custno;
        this.custname = custname;
        this.cdep = cdep;
        this.nyears = nyears;
        this.savtype = savtype;
    }

    public String getCustno() {
        return custno;
    }

    public void setCustno(String custno) {
        this.custno = custno;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public Double getCdep() {
        return cdep;
    }

    public void setCdep(Double cdep) {
        this.cdep = cdep;
    }

    public Integer getNyears() {
        return nyears;
    }

    public void setNyears(Integer nyears) {
        this.nyears = nyears;
    }

    public String getSavtype() {
        return savtype;
    }

    public void setSavtype(String savtype) {
        this.savtype = savtype;
    }
}
