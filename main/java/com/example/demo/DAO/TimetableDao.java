package com.example.demo.DAO;
import com.example.demo.reporm.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class TimetableDao {
    @Autowired
    dayRepository dayRepository;
    @Autowired
    grouupRepository grouupRepository;
    @Autowired
    lessonsRepository lessonsRepository;
    @Autowired
    pairRepository pairRepository;
    @Autowired
    roomRepository roomRepository;
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int save(String namegrouup, String nameday, String pairnumber, String roomnumber, String namelessons) {
        return jdbcTemplate.update("INSERT INTO `timetable` (`ID`, `grouup_id`, `day_id`, `lessons_id`, `pair_id`, `room_id`) VALUES (NULL, ?, ?, ?, ?, ?)"
                , grouupRepository.findAllByName(namegrouup).getId(), dayRepository.findByName(nameday).getId(), lessonsRepository.findByName(namelessons).getId()
                ,pairRepository.findByNumber(Long.parseLong(pairnumber)).getId(), roomRepository.findByNumber(Integer.parseInt(roomnumber)).getId());
    }

    public int Update(Long id, String namegrouup, String nameday, String pairnumber, String roomnumber, String namelessons){
        return jdbcTemplate.update("UPDATE `timetable` SET `grouup_id` = ?, `day_id` = ?, `lessons_id` = ?, `pair_id` = ?, `room_id` = ? WHERE `timetable`.`ID` = ?;"
                , grouupRepository.findAllByName(namegrouup).getId(), dayRepository.findByName(nameday).getId(), lessonsRepository.findByName(namelessons).getId()
                ,pairRepository.findByNumber(Long.parseLong(pairnumber)).getId(), roomRepository.findByNumber(Integer.parseInt(roomnumber)).getId()
                ,id);
    }
}
