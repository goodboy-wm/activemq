package com.nari.wm.brl.impl;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;
import com.nari.wm.brl.ExportPdfService;
import com.nari.wm.entity.Sc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.List;
import java.util.Map;
@Service
public class ExportPdfServiceImpl implements ExportPdfService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void make(Map<String, Object> mode, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws DocumentException {
        document.setPageSize(PageSize.A4);
        document.addTitle("学生成绩表");
        document.add(new Chunk("\n"));

        Table table = new Table(3);

        Cell cell = null;
        Font font = new Font();
        font.setColor(Color.RED);
        font.setStyle(Font.BOLD);

        cell = new Cell(new Paragraph("SId",font));

        cell.setHorizontalAlignment(1);
        table.addCell(cell);

        cell = new Cell(new Paragraph("CId",font));
        cell.setHorizontalAlignment(1);
        table.addCell(cell);

        cell = new Cell(new Paragraph("score",font));
        cell.setHorizontalAlignment(1);
        table.addCell(cell);

        List<Sc> all = ( List<Sc>)mode.get("data");

        for(Sc sc :all){
            document.add(new Chunk("\n"));
            cell = new Cell(new Paragraph(sc.getSid(),font));
            table.addCell(cell);

            cell = new Cell(new Paragraph(sc.getCid(),font));
            table.addCell(cell);

            cell = new Cell(new Paragraph(sc.getScore()+"",font));
            table.addCell(cell);

        }

        document.add(table);

    }

    @Override
    public List<Sc> getAll(){
        StringBuffer sql =  new StringBuffer("select * from SC");
        List<Sc> list = jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(Sc.class));
        return list;
    }

}
