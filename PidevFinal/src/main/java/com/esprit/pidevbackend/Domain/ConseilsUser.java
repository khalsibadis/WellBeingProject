package com.esprit.pidevbackend.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class ConseilsUser implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id ;
   private int PourCentageQVTBAD ;
   private int PourCentageQVTGOOD ;
   private int PourCentageQVTEX ;
   private String RemarqueQVT;
   private String RemarquePub;
   private String RemarqueJaime;
   private String RemarqueComment;
   private String RemarqueGenerale;
   @OneToOne(mappedBy = "conseilsUser")
   @JsonIgnore
   private User user;

    public ConseilsUser() {

    }

    public ConseilsUser(int PourCentageQVTBAD, int PourCentageQVTGOOD, int PourCentageQVTEX, String sRemarqueQVT, String RemarquePub, String RemarqueJaime, String RemarqueComment, String RemarqueGenerale) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPourCentageQVTBAD() {
        return PourCentageQVTBAD;
    }

    public void setPourCentageQVTBAD(int pourCentageQVTBAD) {
        PourCentageQVTBAD = pourCentageQVTBAD;
    }

    public int getPourCentageQVTGOOD() {
        return PourCentageQVTGOOD;
    }

    public void setPourCentageQVTGOOD(int pourCentageQVTGOOD) {
        PourCentageQVTGOOD = pourCentageQVTGOOD;
    }

    public int getPourCentageQVTEX() {
        return PourCentageQVTEX;
    }

    public void setPourCentageQVTEX(int pourCentageQVTEX) {
        PourCentageQVTEX = pourCentageQVTEX;
    }

    public String getRemarqueQVT() {
        return RemarqueQVT;
    }

    public void setRemarqueQVT(String remarqueQVT) {
        RemarqueQVT = remarqueQVT;
    }

    public String getRemarquePub() {
        return RemarquePub;
    }

    public void setRemarquePub(String remarquePub) {
        RemarquePub = remarquePub;
    }

    public String getRemarqueJaime() {
        return RemarqueJaime;
    }

    public void setRemarqueJaime(String remarqueJaime) {
        RemarqueJaime = remarqueJaime;
    }

    public String getRemarqueComment() {
        return RemarqueComment;
    }

    public void setRemarqueComment(String remarqueComment) {
        RemarqueComment = remarqueComment;
    }

    public String getRemarqueGenerale() {
        return RemarqueGenerale;
    }

    public void setRemarqueGenerale(String remarqueGenerale) {
        RemarqueGenerale = remarqueGenerale;
    }
}
