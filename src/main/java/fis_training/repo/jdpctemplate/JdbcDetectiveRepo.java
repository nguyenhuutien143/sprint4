package fis_training.repo.jdpctemplate;

import fis_training.core.Rank;
import fis_training.model.Detective;
import fis_training.repo.jdpctemplate.mapper.DetectiveRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

//@Transactional
@Repository
public class JdbcDetectiveRepo implements DetectiveRepo {

    private RowMapper<Detective> rowMapper = new DetectiveRowMapper();
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcDetectiveRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate=jdbcTemplate;
    }


    @Override
    public List<Detective> findAll() {
        String sql = "select ID, badgeNumber, RANK, ARMED, STATUS,PERSON_ID from evidence_db2.DETECTIVE";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public Optional<Detective> findByBadgeNumber(String badgeNumber) {
        String sql = "select ID, badgeNumber, RANK, ARMED, STATUS,PERSON_ID from DETECTIVE where badgeNumber= ?";
        Detective detective = jdbcTemplate.queryForObject(sql, rowMapper, badgeNumber);
        return detective == null ? Optional.empty() : Optional.of(detective);
    }

    @Override
    public List<Detective> findbyRank(Rank rank) {
        String sql = "select ID, BADGE_NUMBER, RANK, ARMED, STATUS,PERSON_ID from DETECTIVE where RANK= ?";
        return jdbcTemplate.query(sql, rowMapper, rank);
    }

    @Override
    public void save(Detective detective) {
        jdbcTemplate.update(
                "insert into DETECTIVE(ID, BADGE_NUMBER, RANK, ARMED, STATUS,PERSON_ID) values(?,?,?,?,?,?)",
                detective.getId(), detective.getBadgeNumber(), detective.getRank(),
                detective.getStatus(), detective.getPerson().getId()
        );
    }

    @Override
    public void delete(Detective entity) {
        jdbcTemplate.update("delete from DETECTIVE where ID =? ", entity.getId());

    }

    @Override
    public Detective update(Detective detective) {
        jdbcTemplate.update(
                "insert into DETECTIVE(ID, BADGE_NUMBER, RANK, ARMED, STATUS,PERSON_ID) values(?,?,?,?,?,?)",
                detective.getId(), detective.getBadgeNumber(), detective.getRank(),
                detective.getStatus(), detective.getPerson().getId()
        );
        return  detective;
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update("delete from DETECTIVE where ID =? ", id);
    }
    @Override
    public Optional<Detective> findById(Long id) {
        String sql = "select d.ID, d.BADGE_NUMBER, d.RANK, d.ARMED, d.STATUS,d.PERSON_ID, " +
                "p.USERNAME, p.FIRSTNAME, p.LASTNAME, p.HIRINGDATE "+
                "from DETECTIVE d, PERSON p where d.ID= ? and d.PERSON_ID=p.ID";
        return Optional.of(jdbcTemplate.queryForObject(sql, rowMapper, id));
    }
}
