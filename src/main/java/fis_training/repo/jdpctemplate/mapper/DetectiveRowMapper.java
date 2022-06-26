package fis_training.repo.jdpctemplate.mapper;

import fis_training.core.EmploymentStatus;
import fis_training.core.Rank;
import fis_training.model.Detective;
import fis_training.model.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DetectiveRowMapper implements RowMapper<Detective> {
    @Override
    public Detective mapRow(ResultSet rs, int rowNum) throws SQLException {
        long id = rs.getLong("ID");
        String badgeNumber = rs.getString("badgeNumber");
        String rank = rs.getString("RANK");
        boolean armed = rs.getBoolean("ARMED");
        String status = rs.getString("STATUS");
        long personId = rs.getLong("PERSON_ID");

        Person person = new Person();
        person.setId(personId);
        person.setUsername(rs.getString("USERNAME"));
        person.setFirstName(rs.getString("FIRSTNAME"));
        person.setLastName(rs.getString("LASTNAME"));
        person.setHiringDate(rs.getTimestamp("HIRINGDATE").toLocalDateTime());

        Detective detective = new Detective();
        detective.setId(id);
        detective.setPerson(person);
        detective.setBadgeNumber(badgeNumber);
        detective.setRank(Rank.valueOf(rank));
        detective.setArmed(armed);
        detective.setStatus(EmploymentStatus.valueOf(status));

        return detective;
    }
}
