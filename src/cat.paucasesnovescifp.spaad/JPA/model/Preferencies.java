//package model;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "preferencies")
//public class Preferencies {
//    @Id
//    private String NIF;
//    @Id
//    private int ordre;
//    private String idCossos;
//    private String idEspecialitat;
//    private String idIlla;
//
//    public Preferencies() {
//    }
//
//    public Preferencies(String NIF, int ordre, String idCos, String idEspecialitat, String idIlla) {
//        this.NIF = NIF;
//        this.ordre = ordre;
//        this.cossos = idCos;
//        this.idEspecialitat = idEspecialitat;
//        this.idIlla = idIlla;
//    }
//
//    public String getNIF() {
//        return NIF;
//    }
//
//    public void setNIF(String NIF) {
//        this.NIF = NIF;
//    }
//
//    public int getOrdre() {
//        return ordre;
//    }
//
//    public void setOrdre(int ordre) {
//        this.ordre = ordre;
//    }
//
//    public String getIdCos() {
//        return cossos;
//    }
//
//    public void setIdCos(String cossos) {
//        this.cossos = cossos;
//    }
//
//    public String getIdEspecialitat() {
//        return idEspecialitat;
//    }
//
//    public void setIdEspecialitat(String idEspecialitat) {
//        this.idEspecialitat = idEspecialitat;
//    }
//
//    public String getIdIlla() {
//        return idIlla;
//    }
//
//    public void setIdIlla(String idIlla) {
//        this.idIlla = idIlla;
//    }
//
//    @Override
//    public String toString() {
//        return "Preferencies{" +
//                "NIF='" + NIF + '\'' +
//                ", ordre=" + ordre +
//                ", idCos='" + cossos + '\'' +
//                ", idEspecialitat='" + idEspecialitat + '\'' +
//                ", idIlla='" + idIlla + '\'' +
//                '}';
//    }
//}
