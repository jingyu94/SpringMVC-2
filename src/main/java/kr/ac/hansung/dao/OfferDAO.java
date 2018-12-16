package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Offer;

@Repository
public class OfferDAO {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSourece) {
		jdbcTemplate = new JdbcTemplate(dataSourece);
	}

	public int getRowCount() {
		String sqlStatement = "select count(*) from offers";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
	}

	public Offer getOffer(String name) {
		String sqlStatement = "select * from offers where name=?";

		return jdbcTemplate.queryForObject(sqlStatement, new Object[] { name }, new RowMapper<Offer>() {
			@Override
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {

				Offer offer = new Offer();

				offer.setId(rs.getInt("id"));
				offer.setSemester(rs.getString("semester"));
				offer.setName(rs.getString("name"));
				offer.setClassify(rs.getString("classify"));
				offer.setCode(rs.getString("code"));
				offer.setCredit(rs.getString("credit"));
				offer.setYear(rs.getString("year"));
				return offer;
			}
		}

		);
	}

	// query and return multiple objects
	public List<Offer> getOffers() {
		String sqlStatement = "select * from offers ";

		return jdbcTemplate.query(sqlStatement, new RowMapper<Offer>() {

			@Override
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {

				Offer offer = new Offer();

				offer.setId(rs.getInt("id"));
				offer.setSemester(rs.getString("semester"));
				offer.setName(rs.getString("name"));
				offer.setClassify(rs.getString("classify"));
				offer.setCode(rs.getString("code"));
				offer.setCredit(rs.getString("credit"));
				offer.setYear(rs.getString("year"));
				return offer;
			}
		}
	);
}

	public boolean insert(Offer offer) {
		String semester = offer.getSemester();
		String name = offer.getName();
		String classify = offer.getClassify();
		String code = offer.getCode();
		String credit = offer.getCredit();
		String year = offer.getYear();
		
		String sqlStatement = "insert into offers (semester, name, classify, code, credit, year) values (?, ?, ?, ?, ?, ?)";

		return (jdbcTemplate.update(sqlStatement, new Object[] {semester, name, classify, code, credit, year}) == 1);
	}

	public boolean update(Offer offer) {
		String semester = offer.getSemester();
		String name = offer.getName();
		String classify = offer.getClassify();
		String code = offer.getCode();
		String credit = offer.getCredit();
		String year = offer.getYear();
		int id = offer.getId();

		String sqlStatement = "update offers set semester=?, name=?, classify=?, code=?, credit=?, year=? where id=?";

		return (jdbcTemplate.update(sqlStatement, new Object[] { semester, name, classify, code, credit, year, id }) == 1);
	}
	
	public boolean delete(int id) {
		String sqlStatement = "delete from offers where id=?";

		return (jdbcTemplate.update(sqlStatement, new Object[] { id }) == 1);
	}
}
