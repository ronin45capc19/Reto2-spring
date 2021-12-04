package com.tismart.escuela.service;

import net.sf.jasperreports.engine.JRException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import com.tismart.escuela.model.ReporteVentasDTO;

public interface IReporteService {
	ReporteVentasDTO obtenerReporteVentas(Map<String, Object> params) throws JRException, IOException, SQLException;
}
