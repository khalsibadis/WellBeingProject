package com.esprit.pidevbackend.API;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class QRService {

    public byte[] getQRCodeImage(Long idOffer, int width, int height) throws WriterException, IOException {

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(String.valueOf(idOffer), BarcodeFormat.QR_CODE, width, height);

        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        /*
         * To color the qr code image
         * MatrixToImageConfig con = new MatrixToImageConfig(0xFF000002, 0xFFFFC041);
         */
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream /*, con*/);
        byte[] pngData = pngOutputStream.toByteArray();
        return pngData;
    }
}
