/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package co.edu.sena.controller.dao.jdbc;

import co.edu.sena.controller.dao.*;
import co.edu.sena.controller.factory.*;
import co.edu.sena.model.dao.dto.*;
import co.edu.sena.controller.dao.exceptions.*;
import java.sql.Connection;
import java.util.Collection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class RaeDaoImpl extends AbstractDAO implements RaeDao
{
	/** 
	 * The factory class for this DAO has two versions of the create() method - one that
takes no arguments and one that takes a Connection argument. If the Connection version
is chosen then the connection will be stored in this attribute and will be used by all
calls to this DAO, otherwise a new Connection will be allocated for each operation.
	 */
	protected Connection userConn;

	/** 
	 * All finder methods in this class use this SELECT constant to build their queries
	 */
	protected final String SQL_SELECT = "SELECT codigo, denominacion, competencia_codigo, programa_codigo_version FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( codigo, denominacion, competencia_codigo, programa_codigo_version ) VALUES ( ?, ?, ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET codigo = ?, denominacion = ?, competencia_codigo = ?, programa_codigo_version = ? WHERE codigo = ? AND competencia_codigo = ? AND programa_codigo_version = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE codigo = ? AND competencia_codigo = ? AND programa_codigo_version = ?";

	/** 
	 * Index of column codigo
	 */
	protected static final int COLUMN_CODIGO = 1;

	/** 
	 * Index of column denominacion
	 */
	protected static final int COLUMN_DENOMINACION = 2;

	/** 
	 * Index of column competencia_codigo
	 */
	protected static final int COLUMN_COMPETENCIA_CODIGO = 3;

	/** 
	 * Index of column programa_codigo_version
	 */
	protected static final int COLUMN_PROGRAMA_CODIGO_VERSION = 4;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 4;

	/** 
	 * Index of primary-key column codigo
	 */
	protected static final int PK_COLUMN_CODIGO = 1;

	/** 
	 * Index of primary-key column competencia_codigo
	 */
	protected static final int PK_COLUMN_COMPETENCIA_CODIGO = 2;

	/** 
	 * Index of primary-key column programa_codigo_version
	 */
	protected static final int PK_COLUMN_PROGRAMA_CODIGO_VERSION = 3;

	/** 
	 * Inserts a new row in the rae table.
	 */
	public RaePk insert(Rae dto) throws RaeDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			stmt = conn.prepareStatement( SQL_INSERT );
			int index = 1;
			stmt.setString( index++, dto.getCodigo() );
			stmt.setString( index++, dto.getDenominacion() );
			stmt.setString( index++, dto.getCompetenciaCodigo() );
			stmt.setString( index++, dto.getProgramaCodigoVersion() );
			System.out.println( "Executing " + SQL_INSERT + " with DTO: " + dto );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
			reset(dto);
			return dto.createPk();
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new RaeDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the rae table.
	 */
	public void update(RaePk pk, Rae dto) throws RaeDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			System.out.println( "Executing " + SQL_UPDATE + " with DTO: " + dto );
			stmt = conn.prepareStatement( SQL_UPDATE );
			int index=1;
			stmt.setString( index++, dto.getCodigo() );
			stmt.setString( index++, dto.getDenominacion() );
			stmt.setString( index++, dto.getCompetenciaCodigo() );
			stmt.setString( index++, dto.getProgramaCodigoVersion() );
			stmt.setString( 5, pk.getCodigo() );
			stmt.setString( 6, pk.getCompetenciaCodigo() );
			stmt.setString( 7, pk.getProgramaCodigoVersion() );
			int rows = stmt.executeUpdate();
			reset(dto);
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new RaeDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the rae table.
	 */
	public void delete(RaePk pk) throws RaeDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			System.out.println( "Executing " + SQL_DELETE + " with PK: " + pk );
			stmt = conn.prepareStatement( SQL_DELETE );
			stmt.setString( 1, pk.getCodigo() );
			stmt.setString( 2, pk.getCompetenciaCodigo() );
			stmt.setString( 3, pk.getProgramaCodigoVersion() );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new RaeDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the rae table that matches the specified primary-key value.
	 */
	public Rae findByPrimaryKey(RaePk pk) throws RaeDaoException
	{
		return findByPrimaryKey( pk.getCodigo(), pk.getCompetenciaCodigo(), pk.getProgramaCodigoVersion() );
	}

	/** 
	 * Returns all rows from the rae table that match the criteria 'codigo = :codigo AND competencia_codigo = :competenciaCodigo AND programa_codigo_version = :programaCodigoVersion'.
	 */
	public Rae findByPrimaryKey(String codigo, String competenciaCodigo, String programaCodigoVersion) throws RaeDaoException
	{
		Rae ret[] = findByDynamicSelect( SQL_SELECT + " WHERE codigo = ? AND competencia_codigo = ? AND programa_codigo_version = ?", new Object[] { codigo, competenciaCodigo, programaCodigoVersion } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the rae table that match the criteria ''.
	 */
	public Rae[] findAll() throws RaeDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY codigo, competencia_codigo, programa_codigo_version", null );
	}

	/** 
	 * Returns all rows from the rae table that match the criteria 'competencia_codigo = :competenciaCodigo AND programa_codigo_version = :programaCodigoVersion'.
	 */
	public Rae[] findByCompetencia(String competenciaCodigo, String programaCodigoVersion) throws RaeDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE competencia_codigo = ? AND programa_codigo_version = ?", new Object[] { competenciaCodigo, programaCodigoVersion } );
	}

	/** 
	 * Returns all rows from the rae table that match the criteria 'codigo = :codigo'.
	 */
	public Rae[] findWhereCodigoEquals(String codigo) throws RaeDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE codigo = ? ORDER BY codigo", new Object[] { codigo } );
	}

	/** 
	 * Returns all rows from the rae table that match the criteria 'denominacion = :denominacion'.
	 */
	public Rae[] findWhereDenominacionEquals(String denominacion) throws RaeDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE denominacion = ? ORDER BY denominacion", new Object[] { denominacion } );
	}

	/** 
	 * Returns all rows from the rae table that match the criteria 'competencia_codigo = :competenciaCodigo'.
	 */
	public Rae[] findWhereCompetenciaCodigoEquals(String competenciaCodigo) throws RaeDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE competencia_codigo = ? ORDER BY competencia_codigo", new Object[] { competenciaCodigo } );
	}

	/** 
	 * Returns all rows from the rae table that match the criteria 'programa_codigo_version = :programaCodigoVersion'.
	 */
	public Rae[] findWhereProgramaCodigoVersionEquals(String programaCodigoVersion) throws RaeDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE programa_codigo_version = ? ORDER BY programa_codigo_version", new Object[] { programaCodigoVersion } );
	}

	/**
	 * Method 'RaeDaoImpl'
	 * 
	 */
	public RaeDaoImpl()
	{
	}

	/**
	 * Method 'RaeDaoImpl'
	 * 
	 * @param userConn
	 */
	public RaeDaoImpl(final Connection userConn)
	{
		this.userConn = userConn;
	}

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows)
	{
		this.maxRows = maxRows;
	}

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows()
	{
		return maxRows;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "observador_de_proyectos.rae";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected Rae fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			Rae dto = new Rae();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected Rae[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			Rae dto = new Rae();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		Rae ret[] = new Rae[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(Rae dto, ResultSet rs) throws SQLException
	{
		dto.setCodigo( rs.getString( COLUMN_CODIGO ) );
		dto.setDenominacion( rs.getString( COLUMN_DENOMINACION ) );
		dto.setCompetenciaCodigo( rs.getString( COLUMN_COMPETENCIA_CODIGO ) );
		dto.setProgramaCodigoVersion( rs.getString( COLUMN_PROGRAMA_CODIGO_VERSION ) );
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(Rae dto)
	{
	}

	/** 
	 * Returns all rows from the rae table that match the specified arbitrary SQL statement
	 */
	public Rae[] findByDynamicSelect(String sql, Object[] sqlParams) throws RaeDaoException
	{
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			// construct the SQL statement
			final String SQL = sql;
		
		
			System.out.println( "Executing " + SQL );
			// prepare statement
			stmt = conn.prepareStatement( SQL );
			stmt.setMaxRows( maxRows );
		
			// bind parameters
			for (int i=0; sqlParams!=null && i<sqlParams.length; i++ ) {
				stmt.setObject( i+1, sqlParams[i] );
			}
		
		
			rs = stmt.executeQuery();
		
			// fetch the results
			return fetchMultiResults(rs);
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new RaeDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(rs);
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns all rows from the rae table that match the specified arbitrary SQL statement
	 */
	public Rae[] findByDynamicWhere(String sql, Object[] sqlParams) throws RaeDaoException
	{
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			// construct the SQL statement
			final String SQL = SQL_SELECT + " WHERE " + sql;
		
		
			System.out.println( "Executing " + SQL );
			// prepare statement
			stmt = conn.prepareStatement( SQL );
			stmt.setMaxRows( maxRows );
		
			// bind parameters
			for (int i=0; sqlParams!=null && i<sqlParams.length; i++ ) {
				stmt.setObject( i+1, sqlParams[i] );
			}
		
		
			rs = stmt.executeQuery();
		
			// fetch the results
			return fetchMultiResults(rs);
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new RaeDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(rs);
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

}
