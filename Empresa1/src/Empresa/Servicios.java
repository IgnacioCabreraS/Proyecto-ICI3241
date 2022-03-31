
package Empresa;


public class Servicios {
    private String plan;
    private int diaV;
    private String mesV;

 
    public Servicios(String plan, int diaV, String mesV){
        this.plan = plan;
        this.diaV = diaV;
        this.mesV = mesV;
    }
  
    public void setPlan(String plan) {
        this.plan = plan;
    }
    
    public String getPlan() {
        return plan;
    }
    
    public void setDiaV(int diaV) {
        this.diaV = diaV;
    }
    
    public int getDiaV() {
        return diaV;
    }
    public void getMesV(String mesV) {
        this.mesV = mesV;
    }
    
    public String getMesV() {
        return mesV;
    }

    
}
