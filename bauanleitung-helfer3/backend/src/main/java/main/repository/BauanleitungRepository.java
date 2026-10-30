package main.repository;

import main.entities.DbBauanleitung;
import org.springframework.data.repository.CrudRepository;

public interface BauanleitungRepository extends CrudRepository<DbBauanleitung, Integer> {
    DbBauanleitung findDbBauanleitungById(Integer id);
}
