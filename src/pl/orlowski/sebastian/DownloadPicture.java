package pl.orlowski.sebastian;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class DownloadPicture extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        byte[] bufor = readFile("c:\\lelelele.png");
        res.setContentType("image/png");
        res.setContentLength(bufor.length);
        //res.addHeader("Content-Disposition" , "attachment;fileName=jakisobrazek.png");
        OutputStream os = res.getOutputStream();
        os.write(bufor);
        os.close();
    }

    protected byte[] readFile(String fileName) throws IOException {
        File f = new File(fileName);
        long size = f.length();
        byte[] zawartosc = new byte[(int)size];
        FileInputStream fis = new FileInputStream(f);
        fis.read(zawartosc);
        fis.close();
        return zawartosc;
    }
}
