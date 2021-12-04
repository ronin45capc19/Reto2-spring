package com.tismart.escuela.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tismart.escuela.commons.JasperReportManager;
import com.tismart.escuela.enums.TipoReporteEnum;
import com.tismart.escuela.model.ReporteVentasDTO;

import net.sf.jasperreports.engine.JRException;

@Service
public class ReporteServiceImpl implements IReporteService {
	
	@Autowired
	private JasperReportManager reportManager;

	@Autowired
	private DataSource dataSource;
	
	@Override
	public ReporteVentasDTO obtenerReporteVentas(Map<String, Object> params)
			throws JRException, IOException, SQLException {
		String fileName = "reporte";
		ReporteVentasDTO dto = new ReporteVentasDTO();
		String extension = params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name()) ? ".xlsx"
				: ".pdf";
		dto.setFileName(fileName + extension);

		ByteArrayOutputStream stream = reportManager.export(fileName, params.get("tipo").toString(), params,
				dataSource.getConnection());

		byte[] bs = stream.toByteArray();
		dto.setStream(new ByteArrayInputStream(bs));
		dto.setLength(bs.length);

		return dto;
	}

}
