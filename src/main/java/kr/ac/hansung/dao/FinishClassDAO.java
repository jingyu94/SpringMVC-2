package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.FinishClass;

@Repository
public class FinishClassDAO {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSourece) {
		jdbcTemplate = new JdbcTemplate(dataSourece);
	}

	public int getRowCount() {
		String sqlStatement = "select count(*) from finishclass";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
	}

	public FinishClass getFinishClass(int id) {
		String sqlStatement = "select * from finishclass where id=?";
		

		return jdbcTemplate.queryForObject(sqlStatement, new Object[] { id }, new RowMapper<FinishClass>() {
			@Override
			public FinishClass mapRow(ResultSet rs, int rowNum) throws SQLException {

				FinishClass finishClass = new FinishClass();

				finishClass.setId(rs.getInt("id"));
				finishClass.setYear(rs.getString("year"));
				finishClass.setSemester(rs.getString("semester"));
				finishClass.setCode(rs.getString("text"));
				finishClass.setClassname(rs.getString("classname"));
				finishClass.setClassify(rs.getString("classify"));
				finishClass.setCredit(rs.getString("crediet"));
				return finishClass;
			}
		}
	);
}

	
	// query and return multiple objects
	public List<FinishClass> getFinishClasses() {
		String sqlStatement = "select * from finishclass";

		return jdbcTemplate.query(sqlStatement,	new RowMapper<FinishClass>() {

			@Override
			public FinishClass mapRow(ResultSet rs, int rowNum) throws SQLException {

				FinishClass finishClass = new FinishClass();

				finishClass.setId(rs.getInt("id"));
				finishClass.setYear(rs.getString("year"));
				finishClass.setSemester(rs.getString("semester"));
				finishClass.setCode(rs.getString("code"));
				finishClass.setClassname(rs.getString("classname"));
				finishClass.setClassify(rs.getString("classify"));
				finishClass.setCredit(rs.getString("credit"));
				return finishClass;
			}
		}
	);
}

	public boolean insert(FinishClass finishClass) {
		String year = finishClass.getYear();
		String semester = finishClass.getSemester();
		String code = finishClass.getCode();
		String classname = finishClass.getClassname();
		String classify = finishClass.getClassify();
		String credit = finishClass.getCredit();

		String sqlStatement = "insert into finishclass (year, semester, code, classname, classify, credit)"
				+ " values (?, ?, ?, ?, ?, ?)";

		return (jdbcTemplate.update(sqlStatement, new Object[] { year, semester, code, classname, classify, credit }) == 1);
	}

	public boolean update(FinishClass finishClass) {
		String year = finishClass.getYear();
		String semester = finishClass.getSemester();
		String code = finishClass.getCode();
		String classname = finishClass.getClassname();
		String classify = finishClass.getClassify();
		String credit = finishClass.getCredit();
		int id = finishClass.getId();

		String sqlStatement = "update finishclass set year=?, semester=?, code=?, classname=?, classify=?, credit=? where id=?";

		return (jdbcTemplate.update(sqlStatement, new Object[] { year, semester, code, classname, classify, credit, id }) == 1);
	}
	
	public boolean delete(int id) {
		String sqlStatement = "delete from finishclass where id=?";

		return (jdbcTemplate.update(sqlStatement, new Object[] { id }) == 1);
	}
}
