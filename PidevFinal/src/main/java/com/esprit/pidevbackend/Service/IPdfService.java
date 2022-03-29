package com.esprit.pidevbackend.Service;

public interface IPdfService {
    public String toPDF(Long idUser, Long idQvt);
    public String toPDFResrvation(Long idUser, Long idReservation);
}
