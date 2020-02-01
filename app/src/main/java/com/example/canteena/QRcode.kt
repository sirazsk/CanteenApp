package com.example.canteena

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import com.google.zxing.qrcode.QRCodeWriter
import com.google.zxing.BarcodeFormat
import android.graphics.Color
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_qrcode.*


class QRcode : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qrcode)


        var auth: FirebaseAuth
        auth = FirebaseAuth.getInstance()
        val content = auth.uid.toString()


        val writer = QRCodeWriter()
        val bitMatrix = writer.encode(content, BarcodeFormat.QR_CODE, 512, 512)
        val width = bitMatrix.width
        val height = bitMatrix.height

        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565)
        for (x in 0 until width) {
            for (y in 0 until height) {
                bitmap.setPixel(x, y, if (bitMatrix.get(x, y)) Color.BLACK else Color.WHITE)
            }
        }
        imageView.setImageBitmap(bitmap)
    }
}
