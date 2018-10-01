package cat.tecnocampus.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cat.tecnocampus.domain.NoteLab;

@Repository
public class NoteLabDAO {
	private JdbcTemplate jdbcTemplate;
	private RowMapper mapper = (resultSet,i) -> {
		NoteLab noteLab =new NoteLab(resultSet.getString(columnLabel: "title"), resultSet.getString(columnLabel "content"));
		noteLab.setDateCreation(resultSet.getTimestamp(columnLabel: "date_creation").toLocalDateTime());
		noteLab.setDateEdit(resultSet.getTimestamp(columnLabel: "date_edit").toLocalDateTime());
	};
	private String NUM_NOTES= "select count(*) from note_lab";
	private String QUERY_BY_ID= "select * from note_lab where id = ?";
	
	public NoteLabDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}
	
	public int getNumNotes() {
		return jdbcTemplate.queryForObject(NUM_NOTES, Integer.class);
	}
	
	public NoteLab getNoteById(int id) {
		return jdbcTemplate.queryForObject(QUERY_BY_ID, new Object[] {id}, mapper)
	}
}
