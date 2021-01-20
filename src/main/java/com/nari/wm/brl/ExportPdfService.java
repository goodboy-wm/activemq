package com.nari.wm.brl;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfWriter;
import com.nari.wm.entity.Sc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public interface ExportPdfService {

    void make(Map<String,Object> mode, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws DocumentException;

    List<Sc> getAll();

}
