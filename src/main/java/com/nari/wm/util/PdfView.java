package com.nari.wm.util;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;
import com.nari.wm.brl.ExportPdfService;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class PdfView extends AbstractPdfView {

    ExportPdfService pdfService;

    public PdfView(ExportPdfService pdfService) {
        this.pdfService = pdfService;
    }

    @Override
    protected void buildPdfDocument(Map<String, Object> map, Document document, PdfWriter pdfWriter, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        pdfService.make(map,document,pdfWriter,httpServletRequest,httpServletResponse);
    }
}
