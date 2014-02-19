/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package croz.repo;

import croz.model.Content;
import croz.model.ValidationResult;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author stojan
 */
@Repository
public class FileRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public FileRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void updateValidationResult(ValidationResult result) {
        String sql = "update file_content set valid = ? where id = ?";
        jdbcTemplate.update(sql, result.isValid(), result.getId());
    }

    // TODO: use RowCallbackHandler to handle bigger data sets
    public List<Content> findContentByFileName(String fileName) {
        String sql = "select c.id, c.type, c.value "
                + "from file_index f, file_content c "
                + "where f.id = c.file_id and f.file_name = ?";
        return jdbcTemplate.query(sql, new ContentMapper(), fileName);
    }

    public List<ValidationResult> findResultsByFileName(String fileName) {
        String sql = "select c.id, c.valid "
                + "from file_index f, file_content c "
                + "where f.id = c.file_id and f.file_name = ?";
        return jdbcTemplate.query(sql, new ValidationResultMapper(), fileName);
    }

    private class ValidationResultMapper implements RowMapper<ValidationResult> {

        @Override
        public ValidationResult mapRow(ResultSet rs, int rowNum) throws SQLException {
            int id = rs.getInt("ID");
            boolean valid = rs.getBoolean("VALID");
            return new ValidationResult(id, valid);
        }

    }

    private class ContentMapper implements RowMapper<Content> {

        @Override
        public Content mapRow(ResultSet rs, int rowNum) throws SQLException {
            int id = rs.getInt("ID");
            String type = rs.getString("type");
            String value = rs.getString("value");
            return new Content(id, type, value);
        }

    }

}
