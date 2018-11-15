/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package co.edu.sena.controller.dao;

import co.edu.sena.model.dao.dto.*;
import co.edu.sena.controller.dao.exceptions.*;

public interface FichaDao
{
	/** 
	 * Inserts a new row in the ficha table.
	 */
	public FichaPk insert(Ficha dto) throws FichaDaoException;

	/** 
	 * Updates a single row in the ficha table.
	 */
	public void update(FichaPk pk, Ficha dto) throws FichaDaoException;

	/** 
	 * Deletes a single row in the ficha table.
	 */
	public void delete(FichaPk pk) throws FichaDaoException;

	/** 
	 * Returns the rows from the ficha table that matches the specified primary-key value.
	 */
	public Ficha findByPrimaryKey(FichaPk pk) throws FichaDaoException;

	/** 
	 * Returns all rows from the ficha table that match the criteria 'numero_ficha = :numeroFicha'.
	 */
	public Ficha findByPrimaryKey(String numeroFicha) throws FichaDaoException;

	/** 
	 * Returns all rows from the ficha table that match the criteria ''.
	 */
	public Ficha[] findAll() throws FichaDaoException;

	/** 
	 * Returns all rows from the ficha table that match the criteria 'jornada_nombre = :jornadaNombre'.
	 */
	public Ficha[] findByJornada(String jornadaNombre) throws FichaDaoException;

	/** 
	 * Returns all rows from the ficha table that match the criteria 'programa_codigo_version = :programaCodigoVersion'.
	 */
	public Ficha[] findByPrograma(String programaCodigoVersion) throws FichaDaoException;

	/** 
	 * Returns all rows from the ficha table that match the criteria 'numero_ficha = :numeroFicha'.
	 */
	public Ficha[] findWhereNumeroFichaEquals(String numeroFicha) throws FichaDaoException;

	/** 
	 * Returns all rows from the ficha table that match the criteria 'programa_codigo_version = :programaCodigoVersion'.
	 */
	public Ficha[] findWhereProgramaCodigoVersionEquals(String programaCodigoVersion) throws FichaDaoException;

	/** 
	 * Returns all rows from the ficha table that match the criteria 'jornada_nombre = :jornadaNombre'.
	 */
	public Ficha[] findWhereJornadaNombreEquals(String jornadaNombre) throws FichaDaoException;

	/** 
	 * Returns all rows from the ficha table that match the criteria 'estado = :estado'.
	 */
	public Ficha[] findWhereEstadoEquals(String estado) throws FichaDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the ficha table that match the specified arbitrary SQL statement
	 */
	public Ficha[] findByDynamicSelect(String sql, Object[] sqlParams) throws FichaDaoException;

	/** 
	 * Returns all rows from the ficha table that match the specified arbitrary SQL statement
	 */
	public Ficha[] findByDynamicWhere(String sql, Object[] sqlParams) throws FichaDaoException;

}